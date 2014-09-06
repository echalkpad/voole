/*
 * Copyright (C) 2014 BEIJING UNION VOOLE TECHNOLOGY CO., LTD
 */
package com.voole.hobbit2.hive.order.mapreduce;

import java.io.IOException;

import org.apache.avro.mapred.AvroValue;
import org.apache.avro.mapreduce.AvroMultipleOutputs;
import org.apache.avro.specific.SpecificRecordBase;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.voole.dungbeetle.api.DumgBeetleResult;
import com.voole.dungbeetle.api.DumgBeetleResultReader;
import com.voole.dungbeetle.api.DumgBeetleTransformException;
import com.voole.dungbeetle.order.record.OrderDetailDumgBeetleTransformer;
import com.voole.hobbit2.camus.order.OrderPlayAliveReqV2;
import com.voole.hobbit2.camus.order.OrderPlayAliveReqV3;
import com.voole.hobbit2.camus.order.OrderPlayBgnReqV2;
import com.voole.hobbit2.camus.order.OrderPlayBgnReqV3;
import com.voole.hobbit2.camus.order.OrderPlayEndReqV2;
import com.voole.hobbit2.camus.order.OrderPlayEndReqV3;
import com.voole.hobbit2.hive.order.HiveOrderDryRecordGenerator;
import com.voole.hobbit2.hive.order.OrderSessionInfo;
import com.voole.hobbit2.hive.order.avro.HiveOrderDryRecord;
import com.voole.hobbit2.hive.order.exception.OrderSessionInfoBgnNullException;
import com.voole.hobbit2.hive.order.exception.OrderSessionInfoException;

/**
 * @author XuehuiHe
 * @date 2014年7月29日
 */
public class HiveOrderInputReducer
		extends
		Reducer<Text, AvroValue<SpecificRecordBase>, HiveOrderDryRecord, NullWritable> {
	private Logger log = LoggerFactory.getLogger(HiveOrderInputReducer.class);
	private OrderSessionInfo sessionInfo;
	private NullWritable outValue;
	private AvroMultipleOutputs ass;
	private OrderDetailDumgBeetleTransformer orderDetailDumgBeetleTransformer;
	private DumgBeetleResultReader resultReader;

	@Override
	protected void setup(Context context) throws IOException,
			InterruptedException {
		sessionInfo = new OrderSessionInfo();
		outValue = NullWritable.get();
		ass = new AvroMultipleOutputs(context);

		resultReader = new DumgBeetleResultReader();
		orderDetailDumgBeetleTransformer = new OrderDetailDumgBeetleTransformer();
		orderDetailDumgBeetleTransformer.setup(context);
	}

	@Override
	protected void cleanup(Context context) throws IOException,
			InterruptedException {
		ass.close();
		ass = null;
		sessionInfo = null;
		outValue = null;
		if (orderDetailDumgBeetleTransformer != null) {
			orderDetailDumgBeetleTransformer.cleanup(context);
		}
	}

	@Override
	protected void reduce(Text sessionId,
			Iterable<AvroValue<SpecificRecordBase>> iterable, Context context)
			throws IOException, InterruptedException {
		sessionInfo.clear();
		sessionInfo.setSessionId(sessionId.toString());

		try {
			for (AvroValue<SpecificRecordBase> avroValue : iterable) {
				SpecificRecordBase record = avroValue.datum();
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
					.generate(sessionId.toString(), sessionInfo);
			if (!isEnd(orderRecord, context)) {
				writeNoEnd(iterable, context);
				return;
			}

			Iterable<DumgBeetleResult> results = orderDetailDumgBeetleTransformer
					.transform(orderRecord);
			if (results != null) {
				for (DumgBeetleResult dumgBeetleResult : results) {
					resultReader.setDumgBeetleResult(dumgBeetleResult);
					if (!resultReader.isEmpty()) {

					}
				}
			}
			// TODO
		} catch (OrderSessionInfoBgnNullException e) {
			if (isDelayBgn()) {
				writeNoEnd(iterable, context);
			} else {
				writeError(e, iterable, context);
			}
		} catch (OrderSessionInfoException e) {
			writeError(e, iterable, context);
		} catch (DumgBeetleTransformException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void writeNoEnd(Iterable<AvroValue<SpecificRecordBase>> iterable,
			Context context) {
		// TODO
	}

	public void writeError(OrderSessionInfoException e,
			Iterable<AvroValue<SpecificRecordBase>> iterable, Context context) {
		// TODO
	}

	private boolean isDelayBgn() {
		return true;
		// TODO
	}

	private boolean isEnd(HiveOrderDryRecord orderRecord, Context context) {
		Long last = null;
		long startTime = 0l;
		// TODO
		// long startTime = HiveOrderConfigs.getCurrCamusStartTime(context);
		if (orderRecord.getPlayEndTime() != null) {
			last = orderRecord.getPlayEndTime();
		} else if (orderRecord.getPlayAliveTime() != null) {
			last = orderRecord.getPlayAliveTime();
		} else {
			last = orderRecord.getPlayBgnTime();
		}
		if (last != null) {
			return last < startTime - 10 * 60;
		}
		return true;
	}

}