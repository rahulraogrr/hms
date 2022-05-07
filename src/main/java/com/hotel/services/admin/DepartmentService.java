package com.hotel.services.admin;

import com.hotel.dto.admin.department.DepartmentRequestDto;
import com.hotel.dto.admin.department.DepartmentResponseDto;
import com.hotel.services.CrudService;

/**
 * Department Service
 *
 * @author rgonda
 */
public interface DepartmentService extends CrudService<DepartmentRequestDto, DepartmentResponseDto, Integer> {
}