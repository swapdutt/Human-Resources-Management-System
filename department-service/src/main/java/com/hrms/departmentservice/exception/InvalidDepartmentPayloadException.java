package com.hrms.departmentservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidDepartmentPayloadException extends ServiceException {

    public InvalidDepartmentPayloadException(String errorMessage) {
        super(errorMessage);
    }

    public InvalidDepartmentPayloadException(String errorMessage, Throwable errorObject) {
        super(errorMessage, errorObject);
    }
}
