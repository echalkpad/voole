/*
 * Copyright (C) 2014 BEIJING UNION VOOLE TECHNOLOGY CO., LTD
 */
package com.voole.hobbit2.camus.meta.mapreduce;

import java.io.IOException;

import kafka.message.Message;

import org.apache.hadoop.fs.ChecksumException;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;

import com.google.common.base.Throwables;
import com.voole.hobbit2.camus.meta.common.CamusKafkaKey;
import com.voole.hobbit2.camus.meta.common.KafkaReader;
import com.voole.hobbit2.config.props.KafkaConfigKeys;

/**
 * @author XuehuiHe
 * @date 2014年8月26日
 */
public class CamusRecordReader extends
		RecordReader<CamusKafkaKey, BytesWritable> {
	private TaskAttemptContext context;
	private CamusInputSplit split;
	private long total;
	private long readedNum = 0;
	private KafkaReader reader;

	private final BytesWritable msgValue = new BytesWritable();
	private final BytesWritable msgKey = new BytesWritable();

	private CamusKafkaKey key;

	public CamusRecordReader(InputSplit split, TaskAttemptContext context)
			throws IOException, InterruptedException {
		initialize(split, context);
	}

	@Override
	public void initialize(InputSplit split, TaskAttemptContext context)
			throws IOException, InterruptedException {
		this.key = new CamusKafkaKey();
		this.context = context;
		this.split = (CamusInputSplit) split;
		this.total = this.split.getLength();
	}

	private static byte[] getBytes(BytesWritable val) {
		byte[] buffer = val.getBytes();
		long len = val.getLength();
		byte[] bytes = buffer;
		if (len < buffer.length) {
			bytes = new byte[(int) len];
			System.arraycopy(buffer, 0, bytes, 0, (int) len);
		}

		return bytes;
	}

	@Override
	public boolean nextKeyValue() throws IOException, InterruptedException {
		Message message = null;
		try {
			if (reader == null) {
				reader = new KafkaReader(context, split, context
						.getConfiguration().getInt(
								KafkaConfigKeys.KAFKA_TIME_OUT_MS, 40000),
						context.getConfiguration().getInt(
								KafkaConfigKeys.KAFKA_BUFFER_SIZE_BYTES, 10240));
			}
			while (reader.getNext(key, msgValue, msgKey)) {
				if (key.getOffset() > split.getLatestOffset()) {
					return false;
				}
				context.progress();
				byte[] valueBytes = getBytes(msgValue);
				byte[] keyBytes = getBytes(msgKey);
				if (keyBytes.length == 0) {
					message = new Message(valueBytes);
				} else {
					message = new Message(valueBytes, keyBytes);
				}
				long checksum = key.getChecksum();
				if (checksum != message.checksum()) {
					throw new ChecksumException("Invalid message checksum "
							+ message.checksum() + ". Expected "
							+ key.getChecksum(), key.getOffset());
				}
				return true;
			}
			reader = null;
		} catch (Throwable t) {
			Throwables.propagate(t);
		}
		return false;
	}

	@Override
	public CamusKafkaKey getCurrentKey() throws IOException {
		return key;
	}

	@Override
	public BytesWritable getCurrentValue() throws IOException,
			InterruptedException {
		return msgValue;
	}

	private long getPos() throws IOException {
		if (reader != null) {
			return readedNum + reader.getReadedNum();
		} else {
			return readedNum;
		}
	}

	@Override
	public float getProgress() throws IOException, InterruptedException {
		if (getPos() == 0) {
			return 0f;
		}

		if (getPos() >= total) {
			return 1f;
		}
		return (float) ((double) getPos() / total);
	}

	@Override
	public void close() throws IOException {
		closeReader();
	}

	private void closeReader() throws IOException {
		if (reader != null) {
			try {
				readedNum += reader.getReadedNum();
				reader.close();
			} catch (Exception e) {
				// not much to do here but skip the task
			} finally {
				reader = null;
			}
		}
	}

}
