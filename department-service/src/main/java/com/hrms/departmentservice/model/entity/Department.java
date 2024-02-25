package com.hrms.departmentservice.model.entity;

import lombok.*;

import jakarta.persistence.*;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id = UUID.randomUUID().toString();

    @Column(name = "department_id")
    private Integer departmentId;

    @Column(name = "department_name")
    private String departmentName;

    public Department(final Department department) {
        this.setId(UUID.randomUUID().toString());
        this.setDepartmentId(department.getDepartmentId());
        this.setDepartmentName(department.getDepartmentName());
    }

}
