package com.example.sbmdb.resources.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long timestamp;
	private Integer startus;
	private String error;
	private String massage;
	private String path;

	public StandardError() {
	}

	public StandardError(Long timestamp, Integer startus, String error, String massage, String path) {
		super();
		this.timestamp = timestamp;
		this.startus = startus;
		this.error = error;
		this.massage = massage;
		this.path = path;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStartus() {
		return startus;
	}

	public void setStartus(Integer startus) {
		this.startus = startus;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMassage() {
		return massage;
	}

	public void setMassage(String massage) {
		this.massage = massage;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
