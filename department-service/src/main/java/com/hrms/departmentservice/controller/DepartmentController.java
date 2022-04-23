package com.hrms.departmentservice.controller;

import com.hrms.departmentservice.model.entity.Department;
import com.hrms.departmentservice.request.CreateDepartmentRequest;
import com.hrms.departmentservice.request.UpdateDepartmentRequest;
import com.hrms.departmentservice.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/hrms/api/v1/department")
@Slf4j
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping(path = "/{departmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Department> findDepartmentRecordByDepartmentId(@PathVariable("departmentId") final Integer departmentId) {
        log.info("*** Inside findDepartmentRecordByDepartmentId(departmentId) in DepartmentController ***");
        return new ResponseEntity<>(departmentService.findDepartmentRecordByDepartmentId(departmentId), HttpStatus.OK);
    }

    @PostMapping(path = "/createDepartmentInfo", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Department> createDepartmentInfoRecord(@RequestBody @NotNull(message = "Input request must not be NULL!!!") @Valid final CreateDepartmentRequest request) {
        log.info("*** Inside createDepartmentInfoRecord(request) in DepartmentController ***");
        return new ResponseEntity<>(departmentService.createDepartmentInfoRecord(request), HttpStatus.CREATED);
    }

    @PutMapping(path = "/updateDepartmentInfo/{departmentId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Department> updateDepartmentInfoRecord(@PathVariable("departmentId") final Integer departmentId, @RequestBody @NotNull(message = "Input request must not be NULL!!!") @Valid final UpdateDepartmentRequest request) {
        log.info("*** Inside updateDepartmentInfoRecord(request) in DepartmentController ***");
        return new ResponseEntity<>(departmentService.updateDepartmentInfoRecord(departmentId, request), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{departmentId}")
    public ResponseEntity<Boolean> deleteDepartmentRecordByDepartmentId(@PathVariable("departmentId") final Integer departmentId) {
        log.info("*** Inside deleteDepartmentRecordByDepartmentId(departmentId) in DepartmentController ***");
        departmentService.deleteDepartmentRecordByDepartmentId(departmentId);
        return ResponseEntity.ok(true);
    }

}
