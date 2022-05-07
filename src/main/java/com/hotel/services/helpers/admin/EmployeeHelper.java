package com.hotel.services.helpers.admin;

import com.hotel.dto.admin.employee.EmployeeRequestDto;
import com.hotel.dto.admin.employee.EmployeeResponseDto;
import com.hotel.services.helpers.CrudServiceHelperGeneric;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Employee Helper
 *
 * @author rgonda
 */
@Slf4j
@Component
public class EmployeeHelper implements CrudServiceHelperGeneric<EmployeeRequestDto, EmployeeResponseDto, Long> {

    @Override
    public EmployeeResponseDto create(EmployeeRequestDto employeeRequestDto) {
        return null;
    }

    @Override
    public List<EmployeeResponseDto> findAll() {
        return null;
    }

    @Override
    public EmployeeResponseDto findById(Long id) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return true;
    }

    @Override
    public EmployeeResponseDto modify(Long id, EmployeeRequestDto employeeRequestDto) {
        return null;
    }
}
