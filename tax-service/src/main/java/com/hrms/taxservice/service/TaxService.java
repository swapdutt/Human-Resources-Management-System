package com.hrms.taxservice.service;

import com.hrms.taxservice.constants.ErrorMessageConstants;
import com.hrms.taxservice.exception.TaxEntityAlreadyExistsException;
import com.hrms.taxservice.exception.TaxEntityNotFoundException;
import com.hrms.taxservice.exception.TaxEntityWithEmployeeIdNotFoundException;
import com.hrms.taxservice.model.builder.TaxBuilder;
import com.hrms.taxservice.model.entity.Tax;
import com.hrms.taxservice.repository.TaxRepository;
import com.hrms.taxservice.request.CreateTaxRequest;
import com.hrms.taxservice.request.UpdateTaxRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TaxService {

    @Autowired
    TaxRepository taxRepository;

    @Autowired
    TaxBuilder taxBuilder;


    public Tax findTaxRecordByTaxId (Integer employeeId) throws TaxEntityAlreadyExistsException {
        log.info("*** Inside findTaxRecordByTaxId(employeeId) in TaxService ***");

        return taxRepository.findTaxRecordByEmployeeId(employeeId)
                        .orElseThrow(() ->
                                new TaxEntityWithEmployeeIdNotFoundException(ErrorMessageConstants.TAX_WITH_EMPLOYEE_ID_NOT_FOUND));
    }

    public Tax createTaxInfoRecord (CreateTaxRequest taxRequest) throws TaxEntityAlreadyExistsException {
        log.info("*** Inside createTaxInfoRecord(taxRequest) in TaxService ***");

        List<Tax> taxList = taxRepository.findTaxRecordsByEmployeeId(taxRequest.getEmployeeId());
        if (taxList.isEmpty()) {
            Tax taxToCreate = taxBuilder.buildFromRequest(taxRequest);

            return taxRepository.save(taxToCreate);
        } else {
            throw new TaxEntityAlreadyExistsException(ErrorMessageConstants.TAX_ENTITY_ALREADY_PRESENT);
        }
    }

    public Tax updateTaxInfoRecord (Integer employeeId, UpdateTaxRequest taxRequest) throws TaxEntityWithEmployeeIdNotFoundException {
        log.info("*** Inside updateTaxInfoRecord(employeeId, taxRequest) in TaxService ***");

        Tax taxToUpdate = taxRepository.findTaxRecordByEmployeeId(employeeId)
                .orElseThrow(
                        () -> new TaxEntityWithEmployeeIdNotFoundException
                                (ErrorMessageConstants.TAX_WITH_EMPLOYEE_ID_NOT_FOUND));

        Tax updatedTax = taxBuilder.updateFromRequest(taxToUpdate, taxRequest);
        return taxRepository.save(updatedTax);
    }

    public void deleteTaxRecordByTaxId (Integer taxId) throws TaxEntityNotFoundException {
        log.info("*** Inside deleteTaxRecordByTaxId(taxId) in TaxService ***");

        Optional<Tax> taxToBeDeleted = taxRepository.findById(taxId);
        if (taxToBeDeleted.isPresent()) {
            taxRepository.deleteById(taxId);
        } else {
            throw new TaxEntityNotFoundException(ErrorMessageConstants.TAX_ENTITY_WITH_TAX_ID_NOT_FOUND);
        }
    }

    public Double calculateTaxOfEmployee (Integer employeeId) throws TaxEntityWithEmployeeIdNotFoundException, ArithmeticException {
        log.info("*** Inside calculateTaxOfEmployee(employeeId) in TaxService ***");

        Tax tax = taxRepository.findTaxRecordByEmployeeId(employeeId).get();
        Double finalTaxCalculation = 0.00;
        try {
            if (tax.getTaxSlabRange() > 250000 && tax.getTaxSlabRange() <= 350000) {
                tax.setTaxablePercentage(5.00);
            } else if (tax.getTaxSlabRange() > 350000 && tax.getTaxSlabRange() <= 500000) {
                tax.setTaxablePercentage(7.50);
            } else if (tax.getTaxSlabRange() > 500000 && tax.getTaxSlabRange() <= 1000000) {
                tax.setTaxablePercentage(10.00);
            } else if (tax.getTaxSlabRange() > 1000000 && tax.getTaxSlabRange() <= 150000) {
                tax.setTaxablePercentage(15.00);
            } else if (tax.getTaxSlabRange() > 1500000) {
                tax.setTaxablePercentage(20.00);
            } else {
                tax.setTaxablePercentage(0.00);
            }

            Double taxCalculation1 = (tax.getStateTax() - tax.getProfessionalTax());
            Double taxCalculation2 = (tax.getTaxablePercentage() * tax.getTaxSlabRange()) / 100.00;
            finalTaxCalculation = (taxCalculation1 * taxCalculation2) / tax.getStateTax();
        } catch (TaxEntityWithEmployeeIdNotFoundException e) {
            throw new TaxEntityWithEmployeeIdNotFoundException(ErrorMessageConstants.TAX_WITH_EMPLOYEE_ID_NOT_FOUND);
        } catch (ArithmeticException e) {
            throw new ArithmeticException(ErrorMessageConstants.ARITHMETIC_DIVISION_BY_ZERO);
        }
        return finalTaxCalculation;
    }

}
