package com.hrms.taxservice.repository;

import com.hrms.taxservice.model.entity.Tax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface TaxRepository extends JpaRepository<Tax, Integer> {

    Optional<Tax> findTaxRecordByEmployeeId (Integer employeeId);

    List<Tax> findTaxRecordsByEmployeeId (Integer employeeId);

}
