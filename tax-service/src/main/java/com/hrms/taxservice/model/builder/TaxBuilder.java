package com.hrms.taxservice.model.builder;

import com.hrms.taxservice.constants.ErrorMessageConstants;
import com.hrms.taxservice.exception.InvalidTaxPayloadException;
import com.hrms.taxservice.model.entity.Tax;
import com.hrms.taxservice.request.CreateTaxRequest;
import com.hrms.taxservice.request.UpdateTaxRequest;
import org.springframework.stereotype.Component;

@Component
public class TaxBuilder {

	public Tax buildFromRequest(CreateTaxRequest request) {

		Tax tax = new Tax();
		tax.setTaxId(request.getTaxId());
		tax.setTaxSlabRange(request.getTaxSlabRange());
		tax.setTaxablePercentage(request.getTaxablePercentage());
		tax.setStateTax(request.getStateTax());
		tax.setProfessionalTax(request.getProfessionalTax());
		tax.setEmployeeId(request.getEmployeeId());

		return tax;
	}

	public Tax updateFromRequest(Tax taxToBeUpdated, UpdateTaxRequest updateTaxRequest) {

		Tax taxAfterUpdate = new Tax(taxToBeUpdated);

		try {
			if (updateTaxRequest.getTaxSlabRange() != null) {
				taxAfterUpdate.setTaxSlabRange(updateTaxRequest.getTaxSlabRange());
			}
			if (updateTaxRequest.getTaxablePercentage() != null) {
				taxAfterUpdate.setTaxablePercentage(updateTaxRequest.getTaxablePercentage());
			}
			if (updateTaxRequest.getStateTax() != null) {
				taxAfterUpdate.setStateTax(updateTaxRequest.getStateTax());
			}
			if (updateTaxRequest.getProfessionalTax() != null) {
				taxAfterUpdate.setProfessionalTax(updateTaxRequest.getProfessionalTax());
			}

			return taxAfterUpdate;
		} catch (InvalidTaxPayloadException e) {
			throw new InvalidTaxPayloadException(ErrorMessageConstants.INVALID_TAX_PAYLOAD);
		}

	}
}
