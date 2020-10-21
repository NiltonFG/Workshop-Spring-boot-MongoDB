package com.example.sbmdb.service.exception;

public class ObjectNotFoundExcepition extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundExcepition(String msg) {
		super(msg);
	}

}
