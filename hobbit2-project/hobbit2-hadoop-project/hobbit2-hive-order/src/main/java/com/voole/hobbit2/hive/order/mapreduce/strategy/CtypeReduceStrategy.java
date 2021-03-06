package com.voole.hobbit2.hive.order.mapreduce.strategy;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.avro.data.RecordBuilder;
import org.apache.avro.mapred.AvroValue;
import org.apache.avro.specific.SpecificRecordBase;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer.Context;

import com.voole.dungbeetle.ad.record.avro.InterfacePlayLogDry;
import com.voole.dungbeetle.ad.transform.AdPlayLogTransformerImpl;
import com.voole.dungbeetle.api.DumgBeetleTransformException;
import com.voole.dungbeetle.api.model.HiveTable;
import com.voole.dungbeetle.order.record.OrderDetailDumgBeetleTransformer;
import com.voole.dungbeetle.order.record.avro.HiveOrderDetailRecord;
import com.voole.hobbit2.camus.order.OrderPlayAliveReqV2;
import com.voole.hobbit2.camus.order.OrderPlayAliveReqV3;
import com.voole.hobbit2.camus.order.OrderPlayBgnReqV2;
import com.voole.hobbit2.camus.order.OrderPlayBgnReqV3;
import com.voole.hobbit2.camus.order.OrderPlayEndReqV2;
import com.voole.hobbit2.camus.order.OrderPlayEndReqV3;
import com.voole.hobbit2.hive.order.avro.HiveOrderDryRecord;
import com.voole.hobbit2.hive.order.mapreduce.HiveOrderInputReducer;
import com.voole.hobbit2.order.common.HiveOrderDryRecordGenerator;
import com.voole.hobbit2.order.common.OrderSessionInfo;
import com.voole.hobbit2.order.common.exception.OrderSessionInfoException;
import com.voole.hobbit2.order.common.exception.OrderSessionInfoException.OrderSessionInfoExceptionType;

public class CtypeReduceStrategy {
	private final OrderSessionInfo sessionInfo;
	private OrderDetailDumgBeetleTransformer orderDetailDumgBeetleTransformer;
	private AdPlayLogTransformerImpl adPlayLogTransformerImpl;
	private long currCamusExecTime;
	private boolean isRunadPlayLogTransformer;

	private final Map<Class<?>, Method> clazzToCreateBuilderMethod;

	public CtypeReduceStrategy() {
		sessionInfo = new OrderSessionInfo();
		clazzToCreateBuilderMethod = new HashMap<Class<?>, Method>();
	}

	public void reduce(Text sessionIdAndNatip,
			Iterable<AvroValue<SpecificRecordBase>> iterable, Context context)
			throws IOException, InterruptedException {
		sessionInfo.clear();
		sessionInfo.setSessId(sessionIdAndNatip.toString());
		try {
			for (AvroValue<SpecificRecordBase> avroValue : iterable) {
				SpecificRecordBase record = deepCopy(avroValue.datum());
				if (record instanceof OrderPlayBgnReqV2) {
					sessionInfo.setBgn((OrderPlayBgnReqV2) record);
				} else if (record instanceof OrderPlayBgnReqV3) {
					sessionInfo.setBgn((OrderPlayBgnReqV3) record);
				} else if (record instanceof OrderPlayEndReqV2) {
					sessionInfo.setEnd((OrderPlayEndReqV2) record);
				} else if (record instanceof OrderPlayEndReqV3) {
					sessionInfo.setEnd((OrderPlayEndReqV3) record);
				} else if (record instanceof OrderPlayAliveReqV2) {
					sessionInfo.setAlive((OrderPlayAliveReqV2) record);
				} else if (record instanceof OrderPlayAliveReqV3) {
					sessionInfo.setAlive((OrderPlayAliveReqV3) record);
				} else {
					throw new UnsupportedOperationException(record.getClass()
							.getName() + " don't support");
				}
			}
			sessionInfo.verify();
			HiveOrderDryRecord orderRecord = HiveOrderDryRecordGenerator
					.generate(sessionInfo);
			if (!isEnd(orderRecord, context)) {
				writeNoEnd(context);
				return;
			}

			Map<HiveTable, List<SpecificRecordBase>> result = orderDetailDumgBeetleTransformer
					.transform(orderRecord);
			if (result != null && result.size() > 0) {
				for (Entry<HiveTable, List<SpecificRecordBase>> entry : result
						.entrySet()) {
					context.write(entry.getKey(), entry.getValue());
					if (isRunadPlayLogTransformer && orderRecord.getIsAdMod()) {
						context.getCounter("ad", "num").increment(1l);
						List<SpecificRecordBase> details = entry.getValue();
						for (SpecificRecordBase detailRecord : details) {
							if (detailRecord instanceof HiveOrderDetailRecord) {
								processAdRecord(
										(HiveOrderDetailRecord) detailRecord,
										orderRecord, context);
							}
						}
					}
				}
			}
		} catch (OrderSessionInfoException e) {
			if (e.getType() == OrderSessionInfoExceptionType.BGN_IS_NULL
					&& isDelayBgn()) {
				writeNoEnd(context);
			} else {
				writeError(e, context);
			}
		} catch (DumgBeetleTransformException e) {
			// write order detail TransformException
			context.write(
					HiveOrderInputReducer.ORDER_DETAIL_TRANSFORM_EXCEPTION,
					e.getMessage());
		} catch (Exception e) {
			context.write(
					HiveOrderInputReducer.ORDER_DETAIL_TRANSFORM_EXCEPTION,
					e.getMessage());
		}

	}

	protected <T extends SpecificRecordBase> T deepCopy(T record)
			throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		RecordBuilder<?> builder = (RecordBuilder<?>) getBuilderMethod(record)
				.invoke(null, record);
		return (T) builder.build();
	}

	protected Method getBuilderMethod(SpecificRecordBase record)
			throws NoSuchMethodException, SecurityException {
		Class<?> clazz = record.getClass();
		if (!clazzToCreateBuilderMethod.containsKey(clazz)) {
			clazzToCreateBuilderMethod.put(clazz,
					clazz.getMethod("newBuilder", clazz));
		}
		return clazzToCreateBuilderMethod.get(clazz);
	}

	private void processAdRecord(HiveOrderDetailRecord detailRecord,
			HiveOrderDryRecord orderRecord, Context context)
			throws IOException, InterruptedException {
		try {
			Map<HiveTable, List<SpecificRecordBase>> result = adPlayLogTransformerImpl
					.transform(createAdDry(detailRecord, orderRecord));
			if (result != null && result.size() > 0) {
				context.getCounter("ad", "result_num").increment(result.size());
				for (Entry<HiveTable, List<SpecificRecordBase>> entry : result
						.entrySet()) {
					context.write(entry.getKey(), entry.getValue());
				}
			}
		} catch (DumgBeetleTransformException e) {
			context.write(HiveOrderInputReducer.AD_TRANSFORM_EXCEPTION,
					e.getMessage());
		}
	}

	private InterfacePlayLogDry createAdDry(HiveOrderDetailRecord detail,
			HiveOrderDryRecord orderRecord) {
		InterfacePlayLogDry adDry = new InterfacePlayLogDry();
		adDry.setArea(detail.getDimAreaId() == null ? null : detail
				.getDimAreaId().toString());
		adDry.setEpgid(detail.getDimEpgId() == null ? null : detail
				.getDimEpgId().toString());
		adDry.setHid(detail.getDimUserHid());
		adDry.setIp(detail.getUserip());
		adDry.setOemid(detail.getDimOemId() == null ? null : detail
				.getDimOemId().toString());
		adDry.setPlayurl(orderRecord.getPlayurl());
		adDry.setSectionid(detail.getDimSectionId());
		adDry.setSessionid(detail.getSessid());
		adDry.setSpeed(detail.getMetricAvgspeed() == null ? null : detail
				.getMetricAvgspeed().toString());
		adDry.setSpid(detail.getDimIspId() == null ? null : detail
				.getDimIspId().toString());
		adDry.setStarttime(detail.getMetricPlaybgntime());
		adDry.setEndtime(detail.getMetricPlayendtime());
		adDry.setLastalivetime(detail.getMetricPlayalivetime());
		return adDry;

	}

	public void writeNoEnd(Context context) throws IOException,
			InterruptedException {
		if (sessionInfo._bgn != null) {
			context.write(NullWritable.get(), sessionInfo._bgn);
		}
		if (sessionInfo._lastAlive != null) {
			context.write(NullWritable.get(), sessionInfo._lastAlive);
		}
		if (sessionInfo._end != null) {
			context.write(NullWritable.get(), sessionInfo._end);
		}
	}

	public void writeError(OrderSessionInfoException e, Context context)
			throws IOException, InterruptedException {
		context.getCounter("session_error", e.getType().name()).increment(1l);
		if (e.getDiff() != null) {
			context.getCounter("session_error_diff", e.getType().name())
					.increment(e.getDiff());
		}
	}

	private boolean isEnd(HiveOrderDryRecord orderRecord, Context context) {
		Long last = null;
		if (orderRecord.getPlayEndTime() != null) {
			last = orderRecord.getPlayEndTime();
		} else if (orderRecord.getPlayAliveTime() != null) {
			last = orderRecord.getPlayAliveTime();
		} else {
			last = orderRecord.getPlayBgnTime();
		}
		if (last != null) {
			return last < currCamusExecTime - 10 * 60;
		}
		return true;
	}

	private boolean isDelayBgn() {
		Long last = null;
		if (sessionInfo._end != null) {
			last = sessionInfo._endTime;
		} else if (last == null && sessionInfo._lastAlive != null) {
			last = sessionInfo._lastAliveTime;
		}
		if (last != null) {
			return last > currCamusExecTime - 10 * 60;
		}
		return false;
	}

	public OrderSessionInfo getSessionInfo() {
		return sessionInfo;
	}

	public OrderDetailDumgBeetleTransformer getOrderDetailDumgBeetleTransformer() {
		return orderDetailDumgBeetleTransformer;
	}

	public void setOrderDetailDumgBeetleTransformer(
			OrderDetailDumgBeetleTransformer orderDetailDumgBeetleTransformer) {
		this.orderDetailDumgBeetleTransformer = orderDetailDumgBeetleTransformer;
	}

	public AdPlayLogTransformerImpl getAdPlayLogTransformerImpl() {
		return adPlayLogTransformerImpl;
	}

	public void setAdPlayLogTransformerImpl(
			AdPlayLogTransformerImpl adPlayLogTransformerImpl) {
		this.adPlayLogTransformerImpl = adPlayLogTransformerImpl;
	}

	public long getCurrCamusExecTime() {
		return currCamusExecTime;
	}

	public void setCurrCamusExecTime(long currCamusExecTime) {
		this.currCamusExecTime = currCamusExecTime;
	}

	public boolean isRunadPlayLogTransformer() {
		return isRunadPlayLogTransformer;
	}

	public void setRunadPlayLogTransformer(boolean isRunadPlayLogTransformer) {
		this.isRunadPlayLogTransformer = isRunadPlayLogTransformer;
	}

}
