package com.itsallbinary.ai.facade;

public class AIException extends Exception {

	private static final long serialVersionUID = 6658707198312945547L;

	public AIException(Exception e) {
		super(e);
	}

	public AIException(String message) {
		super(message);
	}
}
