package com.hotel.services.admin;

import com.hotel.dto.admin.employee.EmployeeRequestDto;
import com.hotel.dto.admin.employee.EmployeeResponseDto;
import com.hotel.services.CrudService;

/**
 * Employee Service
 *
 * @author rgonda
 */
public interface EmployeeService extends CrudService<EmployeeRequestDto, EmployeeResponseDto,Long> {
}