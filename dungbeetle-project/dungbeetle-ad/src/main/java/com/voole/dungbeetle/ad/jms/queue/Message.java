package com.voole.dungbeetle.ad.jms.queue;

public class Message implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7587162318785542488L;
	
	private int producer;
	
	private Object message;

	public Object getMessage() {
		return message;
	}
	public void setMessage(Object message) {
		this.message = message;
	}
	public int getProducer() {
		return producer;
	}
	public void setProducer(int producer) {
		this.producer = producer;
	}
}
