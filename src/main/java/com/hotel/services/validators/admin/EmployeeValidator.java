package com.hotel.services.validators.admin;

import com.hotel.dto.admin.employee.EmployeeRequestDto;
import com.hotel.repositories.admin.DepartmentRepository;
import com.hotel.services.validators.ServiceValidatorGeneric;
import org.springframework.stereotype.Component;

/**
 * Employee Validator
 * @author rgonda
 */
@Component
public class EmployeeValidator implements ServiceValidatorGeneric<EmployeeRequestDto> {

    private final DepartmentRepository departmentRepository;

    EmployeeValidator(DepartmentRepository departmentRepository){
        this.departmentRepository=departmentRepository;
    }
    @Override
    public void validateRequest(EmployeeRequestDto employeeRequestDto) {
        if(departmentRepository.findById(employeeRequestDto.getEmployee().getEmpDeptId()).isEmpty())
            throw new RuntimeException();
    }
}