package com.hrms.taxservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidTaxPayloadException extends ServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidTaxPayloadException(String errorMessage) {
		super(errorMessage);
	}

	public InvalidTaxPayloadException(String errorMessage, Throwable errorObject) {
		super(errorMessage, errorObject);
	}
}
