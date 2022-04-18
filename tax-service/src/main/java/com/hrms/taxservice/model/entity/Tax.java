package com.hrms.taxservice.model.entity;

import com.hrms.taxservice.constants.ErrorMessageConstants;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tax")
@EqualsAndHashCode
public class Tax {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tax_id")
    private Integer taxId;

    @Column(name = "tax_slab_range")
    private Double taxSlabRange;

    @Column(name = "taxable_percentage")
    private Double taxablePercentage;

    @Column(name = "state_tax")
    private Double stateTax;

    @Column(name = "professional_tax")
    private Double professionalTax;

    @Column(name = "employee_id")
    @NotNull(message = ErrorMessageConstants.EMPLOYEE_ID_NOT_BLANK)
    private Integer employeeId;

    public Tax(final Tax tax) {
        this.setTaxId(tax.getTaxId());
        this.setTaxSlabRange(tax.getTaxSlabRange());
        this.setTaxablePercentage(tax.getTaxablePercentage());
        this.setStateTax(tax.getStateTax());
        this.setProfessionalTax(tax.getProfessionalTax());
        this.setEmployeeId(tax.getEmployeeId());
    }

}
