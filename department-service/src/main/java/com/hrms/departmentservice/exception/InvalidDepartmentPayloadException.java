package com.hrms.departmentservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidDepartmentPayloadException extends ServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidDepartmentPayloadException(String errorMessage) {
		super(errorMessage);
	}

	public InvalidDepartmentPayloadException(String errorMessage, Throwable errorObject) {
		super(errorMessage, errorObject);
	}
}
