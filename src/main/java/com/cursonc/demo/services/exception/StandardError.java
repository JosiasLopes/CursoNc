package com.cursonc.demo.services.exception;

import java.io.Serializable;

public class StandardError implements Serializable{
	
	private int status;
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	private String error;
	private Long timestamp;
	
	public StandardError(int status, String error, Long timestamp) {
		super();
		this.status = status;
		this.error = error;
		this.timestamp = timestamp;
	}

}
