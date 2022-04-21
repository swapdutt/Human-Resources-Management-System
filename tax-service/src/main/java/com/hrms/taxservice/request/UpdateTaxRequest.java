package com.hrms.taxservice.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateTaxRequest {

	private Double taxSlabRange;
	private Double taxablePercentage;
	private Double stateTax;
	private Double professionalTax;

}
