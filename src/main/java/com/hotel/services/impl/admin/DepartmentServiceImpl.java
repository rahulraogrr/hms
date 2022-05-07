package com.hotel.services.impl.admin;

import com.hotel.dto.admin.department.DepartmentRequestDto;
import com.hotel.dto.admin.department.DepartmentResponseDto;
import com.hotel.services.admin.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Department Service Implementation
 *
 * @author rgonda
 */
@Slf4j
@Service("DepartmentServiceImpl")
public class DepartmentServiceImpl implements DepartmentService {

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
    public void deleteById(Integer id) {

    }

    @Override
    public DepartmentResponseDto modify(Integer id, DepartmentRequestDto departmentRequestDto) {
        return null;
    }
}
