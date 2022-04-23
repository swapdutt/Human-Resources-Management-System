package com.hrms.departmentservice.service;

import com.hrms.departmentservice.constants.ErrorMessageConstants;
import com.hrms.departmentservice.exception.DepartmentEntityAlreadyExistsException;
import com.hrms.departmentservice.exception.DepartmentEntityNotFoundException;
import com.hrms.departmentservice.model.builder.DepartmentBuilder;
import com.hrms.departmentservice.model.entity.Department;
import com.hrms.departmentservice.repository.DepartmentRepository;
import com.hrms.departmentservice.request.CreateDepartmentRequest;
import com.hrms.departmentservice.request.UpdateDepartmentRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    DepartmentBuilder departmentBuilder;

    public Department findDepartmentRecordByDepartmentId(Integer departmentId) throws DepartmentEntityNotFoundException {
        log.info("*** Inside findDepartmentRecordByDepartmentId(departmentId) in DepartmentService ***");

        return departmentRepository.
                findDepartmentRecordByDepartmentId(departmentId).orElseThrow(() ->
                        new DepartmentEntityNotFoundException(
                                ErrorMessageConstants.DEPARTMENT_ENTITY_WITH_DEPARTMENT_ID_NOT_FOUND));
    }

    public Department createDepartmentInfoRecord(CreateDepartmentRequest request) throws DepartmentEntityAlreadyExistsException {
        log.info("*** Inside createDepartmentInfoRecord(request) in DepartmentService ***");

        List<Department> departmentList = departmentRepository.
                findDepartmentRecordsByDepartmentId(request.getDepartmentId());
        if (departmentList.isEmpty()) {
            Department deptToCreate = departmentBuilder.buildFromRequest(request);

            return departmentRepository.save(deptToCreate);
        } else {
            throw new DepartmentEntityAlreadyExistsException(ErrorMessageConstants.DEPARTMENT_ENTITY_ALREADY_EXISTS);
        }
    }

    public Department updateDepartmentInfoRecord(Integer departmentId, UpdateDepartmentRequest request) throws DepartmentEntityNotFoundException {
        log.info("*** Inside updateDepartmentInfoRecord(request) in DepartmentService ***");

        Department deptToUpdate = departmentRepository.findDepartmentRecordByDepartmentId(departmentId)
                .orElseThrow(() ->
                        new DepartmentEntityNotFoundException(ErrorMessageConstants.DEPARTMENT_ENTITY_WITH_DEPARTMENT_ID_NOT_FOUND));
        Department updatedDept = departmentBuilder.updateFromRequest(deptToUpdate, request);
        return departmentRepository.save(updatedDept);
    }

    public void deleteDepartmentRecordByDepartmentId(Integer departmentId) throws DepartmentEntityNotFoundException {
        log.info("*** Inside deleteDepartmentRecordByDepartmentId(departmentId) in DepartmentService ***");

        Department deptToBeDeleted = departmentRepository.findDepartmentRecordByDepartmentId(departmentId).get();
        if (null != deptToBeDeleted) {
            departmentRepository.delete(deptToBeDeleted);
        } else {
            throw new DepartmentEntityNotFoundException(ErrorMessageConstants.DEPARTMENT_ENTITY_WITH_DEPARTMENT_ID_NOT_FOUND);
        }
    }
}
