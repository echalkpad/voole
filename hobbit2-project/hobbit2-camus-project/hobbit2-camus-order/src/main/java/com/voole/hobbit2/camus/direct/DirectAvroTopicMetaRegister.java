package com.voole.hobbit2.camus.direct;

import java.util.ArrayList;
import java.util.List;

import org.apache.avro.Schema;
import org.apache.avro.specific.SpecificRecordBase;

import com.voole.hobbit2.camus.api.IStampFinder;
import com.voole.hobbit2.camus.api.TopicMeta;
import com.voole.hobbit2.camus.api.TopicMetaRegister;
import com.voole.hobbit2.camus.api.transform.AvroKafkaTransformer;
import com.voole.hobbit2.camus.api.transform.ITransformer;
import com.voole.hobbit2.camus.api.transform.TransformException;

public class DirectAvroTopicMetaRegister implements TopicMetaRegister {

	@Override
	public List<TopicMeta> getTopicMetas() throws TransformException {
		List<TopicMeta> list = new ArrayList<TopicMeta>();
		IStampFinder stampFinder = new DirectAvroStampFinder();
		for (String topic : DirectAvroTopicUtils.topicBiClazz.keySet()) {
			Class<?> clazz = DirectAvroTopicUtils.topicBiClazz.get(topic);
			Schema schema = DirectAvroTopicUtils.topicBiSchema.get(topic);
			ITransformer<byte[], SpecificRecordBase> transformer = new AvroKafkaTransformer(
					schema);
			list.add(new TopicMeta(topic, clazz, stampFinder, transformer,
					schema));
		}

		return list;
	}

}
