package com.hotel.services.impl.admin;

import com.hotel.dto.admin.employee.EmployeeRequestDto;
import com.hotel.dto.admin.employee.EmployeeResponseDto;
import com.hotel.services.admin.EmployeeService;
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
    public void deleteById(Long id) {

    }

    @Override
    public EmployeeResponseDto modify(Long id, EmployeeRequestDto employeeRequestDto) {
        return null;
    }
}
