package com.hotel.services.helpers.admin;

import com.hotel.dto.admin.department.DepartmentObjectDto;
import com.hotel.dto.admin.department.DepartmentRequestDto;
import com.hotel.dto.admin.department.DepartmentResponseDto;
import com.hotel.entites.admin.Department;
import com.hotel.exceptions.ResourceNotFoundException;
import com.hotel.repositories.admin.DepartmentRepository;
import com.hotel.repositories.admin.HotelRepository;
import com.hotel.services.helpers.CrudServiceHelperGeneric;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Department Helper
 *
 * @author rgonda
 */
@Slf4j
@Component
public class DepartmentHelper implements CrudServiceHelperGeneric<DepartmentRequestDto, DepartmentResponseDto, Integer> {

    private final DepartmentRepository departmentRepository;
    private final HotelRepository hotelRepository;

    DepartmentHelper(HotelRepository hotelRepository, DepartmentRepository departmentRepository ){
        this.hotelRepository = hotelRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DepartmentResponseDto create(DepartmentRequestDto departmentRequestDto) {
        return getDepartmentResponseDto(departmentRepository.save(getDepartment(departmentRequestDto)));
    }

    @Override
    public List<DepartmentResponseDto> findAll() {
        return departmentRepository.findAll().stream()
                .map(DepartmentHelper::getDepartmentResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentResponseDto findById(Integer id) {
        return getDepartmentResponseDto(departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department", id)));
    }

    @Override
    public boolean deleteById(Integer id) {
        departmentRepository.deleteById(id);
        return true;
    }

    @Override
    public DepartmentResponseDto modify(Integer id, DepartmentRequestDto departmentRequestDto) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department", id));

        department.setType(departmentRequestDto.getDepartment().getType());
        department.setName(departmentRequestDto.getDepartment().getName());
        department.setStatus(departmentRequestDto.getDepartment().getStatus());

        if (departmentRequestDto.getDepartment().getDeptHotelId() != department.getHotel().getId()) {
            department.setHotel(hotelRepository.findById(departmentRequestDto.getDepartment().getDeptHotelId())
                    .orElseThrow(() -> new ResourceNotFoundException("Hotel", departmentRequestDto.getDepartment().getDeptHotelId())));
        }

        return getDepartmentResponseDto(departmentRepository.save(department));
    }

    private static DepartmentResponseDto getDepartmentResponseDto(Department department){
        return DepartmentResponseDto.builder()
                .department(
                        DepartmentObjectDto.builder()
                                .id(department.getId())
                                .type(department.getType())
                                .name(department.getName())
                                .status(department.getStatus())
                                .deptHotelId(department.getHotel().getId())
                                .build()
                )
                .build();
    }

    private Department getDepartment(DepartmentRequestDto departmentRequestDto){
        return Department.builder()
                .type(departmentRequestDto.getDepartment().getType())
                .name(departmentRequestDto.getDepartment().getName())
                .status(departmentRequestDto.getDepartment().getStatus())
                .hotel(hotelRepository.findById(departmentRequestDto.getDepartment().getDeptHotelId())
                        .orElseThrow(() -> new ResourceNotFoundException("Hotel", departmentRequestDto.getDepartment().getDeptHotelId())))
                .build();
    }

}