var k = {
	"type" : "record",
	"name" : "HiveOrderRecord",
	"namespace" : "com.voole.hobbit.avro.hive",
	"fields" : [ {
		"name" : "sessID",
		"type" : "string"
	}, {
		"name" : "UID",
		"type" : [ "string", "null" ]
	}, {
		"name" : "HID",
		"type" : [ "string", "null" ]
	}, {
		"name" : "OEMID",
		"type" : [ "long", "null" ]
	}, {
		"name" : "natip",
		"type" : [ "long", "null" ]
	}, {
		"name" : "areaid",
		"type" : [ "int", "null" ]
	}, {
		"name" : "FID",
		"type" : [ "string", "null" ]
	}, {
		"name" : "playBgnTime",
		"type" : [ "long", "null" ]
	}, {
		"name" : "playAliveTime",
		"type" : [ "long", "null" ]
	}, {
		"name" : "playEndTime",
		"type" : [ "long", "null" ]
	}, {
		"name" : "playDurationTime",
		"type" : [ "long", "null" ]
	}, {
		"name" : "avgspeed",
		"type" : [ "long", "null" ]
	}, {
		"name" : "isAdMod",
		"type" : "boolean",
		"default" : false
	}, {
		"name" : "isRepeatMod",
		"type" : "boolean",
		"default" : false
	}, {
		"name" : "pid",
		"type" : [ "string", "null" ]
	}, {
		"name" : "epgid",
		"type" : [ "long", "null" ]
	}, {
		"name" : "secid",
		"type" : [ "string", "null" ]
	}, {
		"name" : "bitrate",
		"type" : [ "long", "null" ]
	}, {
		"name" : "mid",
		"type" : [ "long", "null" ]
	}, {
		"name" : "series",
		"type" : [ "long", "null" ]
	} ]
}