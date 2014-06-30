/*
 * Copyright (C) 2013 BEIJING UNION VOOLE TECHNOLOGY CO., LTD
 */
package com.voole.hobbit.cachestate.entity;

import java.io.Serializable;

/**
 * 介质信息
 * 
 * @author XuehuiHe
 * @date 2013年12月4日
 */
public class ResourceInfo implements Serializable {
	private static final long serialVersionUID = 6540647247488252639L;
	private Integer bitrate;
	private Integer duration;

	public ResourceInfo() {
	}

	public Integer getBitrate() {
		return bitrate;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setBitrate(Integer bitrate) {
		this.bitrate = bitrate;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

}
