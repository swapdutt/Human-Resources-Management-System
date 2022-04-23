package com.hrms.departmentservice.model.builder;

import com.hrms.departmentservice.constants.ErrorMessageConstants;
import com.hrms.departmentservice.exception.InvalidDepartmentPayloadException;
import com.hrms.departmentservice.model.entity.Department;
import com.hrms.departmentservice.request.CreateDepartmentRequest;
import com.hrms.departmentservice.request.UpdateDepartmentRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DepartmentBuilder {

    public Department buildFromRequest (CreateDepartmentRequest request) {

        Department department = new Department();
        department.setId(UUID.randomUUID().toString());
        department.setDepartmentId(department.getDepartmentId());
        department.setDepartmentName(department.getDepartmentName());

        return department;
    }

    public Department updateFromRequest (Department deptToBeUpdated, UpdateDepartmentRequest request) {

        Department deptAfterUpdate = new Department(deptToBeUpdated);

        try {
            if (request.getDepartmentId() != null) {
                deptAfterUpdate.setDepartmentId(request.getDepartmentId());
            }
            if (request.getDepartmentName() != null) {
                deptAfterUpdate.setDepartmentName(request.getDepartmentName());
            }

            return deptAfterUpdate;
        } catch (InvalidDepartmentPayloadException e) {
            throw new InvalidDepartmentPayloadException(ErrorMessageConstants.INVALID_DEPARTMENT_PAYLOAD);
        }
    }
}
