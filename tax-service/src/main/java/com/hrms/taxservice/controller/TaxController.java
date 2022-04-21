package com.hrms.taxservice.controller;

import com.hrms.taxservice.model.entity.Tax;
import com.hrms.taxservice.request.CreateTaxRequest;
import com.hrms.taxservice.request.UpdateTaxRequest;
import com.hrms.taxservice.service.TaxService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/hrms/api/v1/tax")
@Slf4j
public class TaxController {

	@Autowired
	TaxService taxService;

	@GetMapping(path = "/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Tax> findTaxRecordByTaxId(@PathVariable("employeeId") final Integer employeeId) {
		log.info("*** Inside findTaxRecordByTaxId(employeeId) in TaxController ***");
		return new ResponseEntity<Tax>(taxService.findTaxRecordByTaxId(employeeId), HttpStatus.OK);
	}

	@PostMapping(path = "/createTaxInfo", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Tax> createTaxInfoRecord(
			@RequestBody @NotNull(message = "Input request must not be NULL!!!") @Valid final CreateTaxRequest taxRequest) {
		log.info("*** Inside createTaxInfoRecord(taxRequest) in TaxController ***");
		return new ResponseEntity<Tax>(taxService.createTaxInfoRecord(taxRequest), HttpStatus.CREATED);
	}

	@PutMapping(path = "/updateTaxInfo/{employeeId}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Tax> updateTaxInfoRecord(@PathVariable("employeeId") final Integer employeeId,
			@RequestBody @NotNull(message = "Input request must not be NULL!!!") @Valid final UpdateTaxRequest taxRequest) {
		log.info("*** Inside updateTaxInfoRecord(employeeId, taxRequest) in TaxController ***");
		return new ResponseEntity<Tax>(taxService.updateTaxInfoRecord(employeeId, taxRequest), HttpStatus.OK);
	}

	@DeleteMapping(path = "/{taxId}")
	public ResponseEntity<Boolean> deleteTaxRecordByTaxId(@PathVariable("taxId") final Integer taxId) {
		log.info("*** Inside deleteTaxRecordByTaxId(taxId) in TaxController ***");
		taxService.deleteTaxRecordByTaxId(taxId);
		return ResponseEntity.ok(true);
	}

	@GetMapping(path = "tax-calculation/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Double> calculateTaxOfEmployee(@PathVariable("employeeId") final Integer employeeId) {
		log.info("*** Inside calculateTaxOfEmployee(employeeId) in TaxController ***");
		return new ResponseEntity<>(taxService.calculateTaxOfEmployee(employeeId), HttpStatus.OK);
	}

}
