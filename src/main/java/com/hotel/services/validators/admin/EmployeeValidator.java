package com.hotel.services.validators.admin;

import com.hotel.dto.admin.employee.EmployeeRequestDto;
import com.hotel.dto.admin.employee.EmployeeResponseDto;
import com.hotel.services.validators.ServiceValidatorGeneric;
import org.springframework.stereotype.Component;

/**
 * Employee Validator
 * @author rgonda
 */
@Component
public class EmployeeValidator implements ServiceValidatorGeneric<EmployeeRequestDto> {

    @Override
    public void validateRequest(EmployeeRequestDto employeeRequestDto) {

    }
}
