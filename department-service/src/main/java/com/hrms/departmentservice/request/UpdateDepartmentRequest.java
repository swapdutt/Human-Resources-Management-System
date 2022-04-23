package com.hrms.departmentservice.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateDepartmentRequest {

    private Integer departmentId;
    private String departmentName;

}
