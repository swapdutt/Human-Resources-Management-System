package com.hrms.departmentservice.exception;

public class ServiceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServiceException(final String errorMessage) {
		super(errorMessage);
	}

	public ServiceException(final String errorMessage, final Throwable errorObject) {
		super(errorMessage, errorObject);
	}

}
