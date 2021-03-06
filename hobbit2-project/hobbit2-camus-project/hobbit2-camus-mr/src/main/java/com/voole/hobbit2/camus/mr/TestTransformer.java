/*
 * Copyright (C) 2014 BEIJING UNION VOOLE TECHNOLOGY CO., LTD
 */
package com.voole.hobbit2.camus.mr;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Text;

import com.voole.hobbit2.camus.OrderTopicsUtils;
import com.voole.hobbit2.camus.api.transform.AvroCtypeKafkaTransformer;
import com.voole.hobbit2.camus.api.transform.AvroKafkaTransformer;
import com.voole.hobbit2.camus.api.transform.TransformException;
import com.voole.hobbit2.camus.bsepg.BsEpgPlayInfo;
import com.voole.hobbit2.camus.mr.common.CamusKey;

/**
 * @author XuehuiHe
 * @date 2014年9月18日
 */
public class TestTransformer {
	public static final Configuration conf = new Configuration();
	public static final Map<String, AvroCtypeKafkaTransformer> topicToTransformer = new HashMap<String, AvroCtypeKafkaTransformer>();
	static {
		conf.addResource("core-site2.xml");
		// conf.setBoolean("order.detail.transformer.is.auto.refresh.cache",
		// true);
	}

	public static void main(String[] args) throws IOException {
		AvroKafkaTransformer transformer = new AvroKafkaTransformer(
				BsEpgPlayInfo.getClassSchema());

		Path path = new Path(
				"/camus/exec/history/2015-01-05-18-01-06/errors-m-00024.error");
		SequenceFile.Reader reader = new SequenceFile.Reader(conf,
				SequenceFile.Reader.file(path));
		CamusKey key = new CamusKey();
		Text msg = new Text();

		while (reader.next(key, msg)) {
			System.out.println(key.getTopic());
//			transformer.transform(msg.getBytes());
			// System.out.println(msg);
			try {
				System.out.println(transformer.transform(msg.getBytes()));
			} catch (Exception e) {
				// System.out.println(e.getMessage());
				if (e.getMessage().indexOf("repeatTimes") != -1) {
					System.out.println(e.getMessage());
					// System.out.println(e.getMessage());
					// writer.append("topic:" + key.getTopic() + "\n");
					// writer.append("msg:" + msg + "\n");
				}
			}

		}
		reader.close();
	}

	// public static void main(String[] args) throws TransformException {
	// AvroCtypeKafkaTransformer transformer = new AvroCtypeKafkaTransformer(
	// OrderTopicsUtils.topicBiSchema.get("t_playalive_v3"));
	// String msg =
	// "13204996857296126078	1416283963	1647	0	0	3796530	0	10	3913316022	1	2128	17482	459788	959	498145	497606	19000	20	134736938	1	2450	17874	377683	948	498109	586464	15000	8151514154	1	2435	18108	328420	935	467329	328420	39000	7	487058474	1	2388	18714	443367	970	458096	547366	16000	16	134736938	1410	17268	459788	904	453439	443810	22000	24	3862984374	1	1995	18030	410525	956	421916	443810	23000	22	3896538806	1	1747	22199	410525	985	418253	410525	25000	21	3879761590	1	1925	20427	410525	958	396084	410525	24000	19	470281258	1	1875	24173	361262	934	362227	410525	25000	13	168291370	1	2228	20566	377683	929	358039	421051	23000	6	0	719843650";
	// transformer.transform(msg.getBytes());
	// }

	public static void main2(String[] args) throws TransformException,
			IOException {
		FileWriter writer = new FileWriter("/tmp/errorRecord.txt");

		test("/camus/exec/history/2014-11-07-15-01-06/errors-m-00004.error",
				writer);
		test("/camus/exec/history/2014-11-07-15-01-06/errors-m-00005.error",
				writer);
		test("/camus/exec/history/2014-11-07-15-01-06/errors-m-00006.error",
				writer);
		test("/camus/exec/history/2014-11-07-15-01-06/errors-m-00007.error",
				writer);
		test("/camus/exec/history/2014-11-07-15-01-06/errors-m-00016.error",
				writer);
		test("/camus/exec/history/2014-11-07-15-01-06/errors-m-00017.error",
				writer);
		test("/camus/exec/history/2014-11-07-15-01-06/errors-m-00018.error",
				writer);
		test("/camus/exec/history/2014-11-07-15-01-06/errors-m-00019.error",
				writer);
		writer.close();
		// String msg =
		// "817	107	A089E46B3CA400000000000000000000	6033561	1932787978	9847941467737988775	D0488748838E73A0CD282D9A173AC6BD	http://cdn.voole.com:3580/uid$6033561/stamp$1415341636/keyid$67141632/auth$7983afc99d4d6e8f8d8322fd66172fde/d0488748838e73a0cd282d9a173ac6bd.m3u8?ext=btime:0,etime:0;oid:817,eid:100895,code:cate__ypOTVsytjwlb_1393847192,pid:101001,po:999999;admt:4,lg:13a44db15542d25d:pln:353:pln:151:pln:149:pln:147:mid:13314641,48f35a041d9494b576adadc9f5f3658d:0:23:3785004&bke=cdnbke.voole.com&type=get_m3u8&host=cdn.voole.com:3580&port=3528&is3d=0&proto=5	1415341645	1	286926717	3528	4	33554432	0	0	1920065090	4294966292	3754108797";
		// AvroCtypeKafkaTransformer transformer = new
		// AvroCtypeKafkaTransformer(
		// OrderPlayBgnReqV2.getClassSchema());
		// try {
		// transformer.transform(msg.getBytes());
		// } catch (Exception e) {
		// e.printStackTrace();
		// System.out.println(Throwables.getRootCause(e).getClass().getName());
		// }
		//
	}

	public static void test(String file, FileWriter writer) throws IOException,
			TransformException {
		Path path = new Path(file);
		SequenceFile.Reader reader = new SequenceFile.Reader(conf,
				SequenceFile.Reader.file(path));
		CamusKey key = new CamusKey();
		Text msg = new Text();

		while (reader.next(key, msg)) {
			// System.out.println(key.getTopic());
			// System.out.println(msg);
			try {
				AvroCtypeKafkaTransformer transformer = getTransform(key
						.getTopic());
				System.out.println(transformer.transform(msg.toString()
						.getBytes()));
			} catch (Exception e) {
				// System.out.println(e.getMessage());
				if (e.getMessage().indexOf("repeatTimes") != -1) {
					System.out.println(e.getMessage());
					// System.out.println(e.getMessage());
					// writer.append("topic:" + key.getTopic() + "\n");
					// writer.append("msg:" + msg + "\n");
				}
			}

		}
		reader.close();
	}

	public static AvroCtypeKafkaTransformer getTransform(String topic)
			throws TransformException {
		// if (!topicToTransformer.containsKey(topic)) {
		// topicToTransformer.put(topic, new AvroCtypeKafkaTransformer(
		// OrderTopicsUtils.topicBiSchema.get(topic)));
		// }
		return topicToTransformer.get(topic);
	}
}
