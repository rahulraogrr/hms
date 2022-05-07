package com.hotel.services.validators.admin;

import com.hotel.dto.admin.department.DepartmentRequestDto;
import com.hotel.services.validators.ServiceValidatorGeneric;
import org.springframework.stereotype.Component;

/**
 * Department Validator
 * @author rgonda
 */
@Component
public class DepartmentValidator implements ServiceValidatorGeneric<DepartmentRequestDto> {

    @Override
    public void validateRequest(DepartmentRequestDto departmentRequestDto) {

    }
}
