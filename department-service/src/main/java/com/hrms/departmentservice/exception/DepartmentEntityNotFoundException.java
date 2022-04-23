package com.hrms.departmentservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DepartmentEntityNotFoundException extends ServiceException {

    public DepartmentEntityNotFoundException(String errorMessage) {
        super(errorMessage);
    }

    public DepartmentEntityNotFoundException(String errorMessage, Throwable errorObject) {
        super(errorMessage, errorObject);
    }
}
