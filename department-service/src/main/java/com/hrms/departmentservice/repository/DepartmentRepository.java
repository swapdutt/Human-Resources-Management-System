package com.hrms.departmentservice.repository;

import com.hrms.departmentservice.model.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {

    Optional<Department> findDepartmentRecordByDepartmentId (Integer departmentId);

    List<Department> findDepartmentRecordsByDepartmentId (Integer departmentId);

}
