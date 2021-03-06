package com.voole.hobbit2.camus.api.transform;

import org.apache.avro.Schema;
import org.apache.avro.io.BinaryDecoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificRecordBase;

import com.google.common.base.Optional;

public class V3aAvroKafkaTransformer implements
		ITransformer<byte[], SpecificRecordBase> {

	private final SpecificDatumReader<?> reader;

	@SuppressWarnings("rawtypes")
	public V3aAvroKafkaTransformer(Schema schema) {
		reader = new SpecificDatumReader(schema);
	}

	@Override
	public Optional<SpecificRecordBase> transform(byte[] bytes)
			throws TransformException {
		BinaryDecoder binaryDecoder = DecoderFactory.get().binaryDecoder(bytes,
				null);
		try {
			binaryDecoder.readLong();
			SpecificRecordBase record = (SpecificRecordBase) reader.read(null,
					binaryDecoder);
			if (record != null) {
				return Optional.of(record);
			} else {
				return Optional.absent();
			}
		} catch (Exception e) {
			throw new TransformException(e);
		}

	}
}
