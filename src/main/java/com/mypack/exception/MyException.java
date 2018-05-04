package com.mypack.exception;

public class MyException extends Throwable {
	private static final long serialVersionUID = 1L;
	
	private int statusCode = 404;

	public MyException() {
		super("Default MyException");
	}
	
	public MyException(String customErrorMessage) {
		super(customErrorMessage);
	}
	
	public MyException(String customErrorMessage, Throwable throwable) {
		super(customErrorMessage, throwable);
	}
	
	public MyException(Exception exception) {
		super(exception);
	}
	
	public MyException(int statusCode, String errorMessage, Exception exception) {
		super(errorMessage, exception);
		this.statusCode = statusCode;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
}
