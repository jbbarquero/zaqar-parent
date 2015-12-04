package com.malsolo.zaqar.alert.generator.domain;

public enum EventStatus {
	
	IGNORED(0), INACTIVE(1), MULTI_PROCESSED(2), PROCESSED(3);
	
	private Integer status;
	
	private EventStatus(Integer status) {
		this.status = status;
	}
	
	public Integer status() {
		return status;
	}

}
