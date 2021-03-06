/*
 * Copyright (C) 2014 BEIJING UNION VOOLE TECHNOLOGY CO., LTD
 */
package com.voole.hobbit2.order.common.exception;

/**
 * @author XuehuiHe
 * @date 2014年9月6日
 */
public class OrderSessionInfoException extends Exception {
	public static enum OrderSessionInfoExceptionType {
		BGN_IS_NULL, BGN_IS_MULTI, END_IS_MULTI, BGN_TIME_GT_END_TIME, BGN_TIME_GT_ALIVE_TIME, ALIVE_TIME_GT_END_TIME;
	}

	private final CharSequence sessionId;
	private final OrderSessionInfoExceptionType type;
	private Long diff;

	public CharSequence getSessionId() {
		return sessionId;
	}

	public OrderSessionInfoExceptionType getType() {
		return type;
	}

	public String getFileName() {
		return "error_" + type.name() + "_" + sessionId+".avro";
	}

	public Long getDiff() {
		return diff;
	}

	public void setDiff(Long diff) {
		this.diff = diff;
	}

	public OrderSessionInfoException(CharSequence sessionId,
			OrderSessionInfoExceptionType type,Long diff) {
		super();
		this.sessionId = sessionId;
		this.type = type;
		this.diff = diff;
	}

	public OrderSessionInfoException(CharSequence sessionId, String message,
			OrderSessionInfoExceptionType type) {
		super(message);
		this.sessionId = sessionId;
		this.type = type;
	}

	public OrderSessionInfoException(CharSequence sessionId, String message,
			Throwable cause, OrderSessionInfoExceptionType type) {
		super(message, cause);
		this.sessionId = sessionId;
		this.type = type;
	}

	public OrderSessionInfoException(CharSequence sessionId, Throwable cause,
			OrderSessionInfoExceptionType type) {
		super(cause);
		this.sessionId = sessionId;
		this.type = type;
	}
}
