package com.hrms.taxservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TaxEntityNotFoundException extends ServiceException {

    public TaxEntityNotFoundException(String errorMessage) {
        super(errorMessage);
    }

    public TaxEntityNotFoundException(String errorMessage, Throwable errorObject) {
        super(errorMessage, errorObject);
    }
}
