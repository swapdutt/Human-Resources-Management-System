package com.hrms.taxservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TaxEntityWithEmployeeIdNotFoundException extends ServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TaxEntityWithEmployeeIdNotFoundException(String errorMessage) {
		super(errorMessage);
	}

	public TaxEntityWithEmployeeIdNotFoundException(String errorMessage, Throwable errorObject) {
		super(errorMessage, errorObject);
	}
}
