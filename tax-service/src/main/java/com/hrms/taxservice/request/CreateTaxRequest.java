package com.hrms.taxservice.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTaxRequest {

    private Integer taxId;
    private Double taxSlabRange;
    private Double taxablePercentage;
    private Double stateTax;
    private Double professionalTax;
    private Integer employeeId;

}
