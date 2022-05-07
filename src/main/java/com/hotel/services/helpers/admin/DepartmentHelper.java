package com.hotel.services.helpers.admin;

import com.hotel.dto.admin.department.DepartmentRequestDto;
import com.hotel.dto.admin.department.DepartmentResponseDto;
import com.hotel.services.helpers.CrudServiceHelperGeneric;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Department Helper
 *
 * @author rgonda
 */
@Slf4j
@Component
public class DepartmentHelper implements CrudServiceHelperGeneric<DepartmentRequestDto, DepartmentResponseDto, Integer> {

    @Override
    public DepartmentResponseDto create(DepartmentRequestDto departmentRequestDto) {
        return null;
    }

    @Override
    public List<DepartmentResponseDto> findAll() {
        return null;
    }

    @Override
    public DepartmentResponseDto findById(Integer id) {
        return null;
    }

    @Override
    public boolean deleteById(Integer id) {
        return true;
    }

    @Override
    public DepartmentResponseDto modify(Integer id, DepartmentRequestDto departmentRequestDto) {
        return null;
    }
}
