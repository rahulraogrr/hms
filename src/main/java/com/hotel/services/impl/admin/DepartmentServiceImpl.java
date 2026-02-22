package com.hotel.services.impl.admin;

import com.hotel.dto.admin.department.DepartmentRequestDto;
import com.hotel.dto.admin.department.DepartmentResponseDto;
import com.hotel.services.admin.DepartmentService;
import com.hotel.services.helpers.admin.DepartmentHelper;
import com.hotel.services.validators.admin.DepartmentValidator;
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

    private final DepartmentValidator departmentValidator;
    private final DepartmentHelper departmentHelper;

    DepartmentServiceImpl(DepartmentValidator departmentValidator, DepartmentHelper departmentHelper){
        this.departmentValidator=departmentValidator;
        this.departmentHelper=departmentHelper;
    }

    @Override
    public DepartmentResponseDto create(DepartmentRequestDto departmentRequestDto) {
        departmentValidator.validateRequest(departmentRequestDto);
        return departmentHelper.create(departmentRequestDto);
    }

    @Override
    public List<DepartmentResponseDto> findAll(int page, int size) {
        return departmentHelper.findAll(page, size);
    }

    @Override
    public DepartmentResponseDto findById(Integer id) {
        return departmentHelper.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        departmentHelper.deleteById(id);
    }

    @Override
    public DepartmentResponseDto modify(Integer id, DepartmentRequestDto departmentRequestDto) {
        departmentValidator.validateRequest(departmentRequestDto);
        return departmentHelper.modify(id,departmentRequestDto);
    }
}