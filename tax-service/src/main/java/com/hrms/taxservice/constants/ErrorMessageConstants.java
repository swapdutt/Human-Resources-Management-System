package com.hrms.taxservice.constants;

public class ErrorMessageConstants {

    /**
     * Error messages related to tax entity/ service
     */

    public static final String EMPLOYEE_ID_NOT_BLANK = "Employee id cannot be passed as a blank value. Please enter a valid employee id.";

    public static final String TAX_WITH_EMPLOYEE_ID_NOT_FOUND = "Tax entity for requested employee id not found.";

    public static final String TAX_ENTITY_WITH_TAX_ID_NOT_FOUND = "Tax entity for requested tax id not found.";

    public static final String INVALID_TAX_PAYLOAD = "The data set/payload required to create/update new record for tax is empty or not in proper format.";

    public static final String TAX_ENTITY_ALREADY_PRESENT = "Tax entity for the requested employee id is already present.";

    public static final String ARITHMETIC_DIVISION_BY_ZERO = "Arithmetic division by zero is not possible. Please check the value.";

}
