package com.hrms.departmentservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DepartmentEntityAlreadyExistsException extends ServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DepartmentEntityAlreadyExistsException(String errorMessage) {
		super(errorMessage);
	}

	public DepartmentEntityAlreadyExistsException(String errorMessage, Throwable errorObject) {
		super(errorMessage, errorObject);
	}
}
