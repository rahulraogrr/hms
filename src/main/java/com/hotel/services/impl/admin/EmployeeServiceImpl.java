package com.hotel.services.impl.admin;

import com.hotel.dto.admin.employee.EmployeeRequestDto;
import com.hotel.dto.admin.employee.EmployeeResponseDto;
import com.hotel.services.admin.EmployeeService;
import com.hotel.services.helpers.admin.EmployeeHelper;
import com.hotel.services.validators.admin.EmployeeValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Employee Service Implementation
 *
 * @author rgonda
 */
@Slf4j
@Service("EmployeeServiceImpl")
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeValidator employeeValidator;
    private final EmployeeHelper employeeHelper;

    EmployeeServiceImpl(EmployeeValidator employeeValidator, EmployeeHelper employeeHelper){
        this.employeeValidator = employeeValidator;
        this.employeeHelper = employeeHelper;
    }

    @Override
    public EmployeeResponseDto create(EmployeeRequestDto employeeRequestDto) {
        employeeValidator.validateRequest(employeeRequestDto);
        return employeeHelper.create(employeeRequestDto);
    }

    @Override
    public List<EmployeeResponseDto> findAll() {
        return employeeHelper.findAll();
    }

    @Override
    public EmployeeResponseDto findById(Long id) {
        return employeeHelper.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        employeeHelper.deleteById(id);
    }

    @Override
    public EmployeeResponseDto modify(Long id, EmployeeRequestDto employeeRequestDto) {
        employeeValidator.validateRequest(employeeRequestDto);
        return employeeHelper.modify(id,employeeRequestDto);
    }
}