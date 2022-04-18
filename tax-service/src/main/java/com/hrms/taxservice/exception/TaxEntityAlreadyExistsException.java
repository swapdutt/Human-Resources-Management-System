package com.hrms.taxservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TaxEntityAlreadyExistsException extends ServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TaxEntityAlreadyExistsException(String errorMessage) {
		super(errorMessage);
	}

	public TaxEntityAlreadyExistsException(String errorMessage, Throwable errorObject) {
		super(errorMessage, errorObject);
	}

}
