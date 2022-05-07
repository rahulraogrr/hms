package com.hotel.services.helpers.admin;

import com.hotel.dto.admin.employee.EmployeeObjectDto;
import com.hotel.dto.admin.employee.EmployeeRequestDto;
import com.hotel.dto.admin.employee.EmployeeResponseDto;
import com.hotel.entites.admin.Employee;
import com.hotel.repositories.admin.DepartmentRepository;
import com.hotel.repositories.admin.EmployeeRepository;
import com.hotel.services.helpers.CrudServiceHelperGeneric;
import com.hotel.util.CommonCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Employee Helper
 *
 * @author rgonda
 */
@Slf4j
@Component
public class EmployeeHelper implements CrudServiceHelperGeneric<EmployeeRequestDto, EmployeeResponseDto, Long> {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    EmployeeHelper(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository){
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeResponseDto create(EmployeeRequestDto employeeRequestDto) {
        return getEmployeeResponseDto(employeeRepository.save(getEmployee(employeeRequestDto)));
    }

    @Override
    public List<EmployeeResponseDto> findAll() {
        return employeeRepository.findAll().stream()
                .map(EmployeeHelper::getEmployeeResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeResponseDto findById(Long id) {
        return getEmployeeResponseDto(employeeRepository.findById(id).get());
    }

    @Override
    public boolean deleteById(Long id) {
        employeeRepository.deleteById(id);
        return true;
    }

    @Override
    public EmployeeResponseDto modify(Long id, EmployeeRequestDto employeeRequestDto) {
        return null;
    }

    private static EmployeeResponseDto getEmployeeResponseDto(Employee employee){
        return EmployeeResponseDto.builder()
                .employee(
                        EmployeeObjectDto.builder()
                                .id(employee.getId())
                                .firstName(employee.getFirstName())
                                .middleName(employee.getMiddleName())
                                .lastName(employee.getLastName())
                                .gender(employee.getGender())
                                .mobile(employee.getMobile())
                                .dateOfBirth(employee.getDateOfBirth())
                                .eduType(employee.getEduType())
                                .idType(employee.getIdType())
                                .idNo(employee.getIdNo())
                                .empDeptId(employee.getDepartment().getId())
                                .reportsTo(employee.getReportsTo())
                                .designation(employee.getDesignation())
                                .grade(employee.getGrade())
                                .status(employee.getStatus())
                                .curAddress(CommonCode.getAddressDto(employee.getCurAddress()))
                                .currAddSameAsPermAdd(employee.isCurrAddSameAsPermAdd())
                                .permAddress(CommonCode.getAddressDto(employee.getPermAddress()))
                                .build()
                )
                .build();
    }

    private Employee getEmployee(EmployeeRequestDto employeeRequestDto){
        return Employee.builder()
                .firstName(employeeRequestDto.getEmployee().getFirstName())
                .middleName(employeeRequestDto.getEmployee().getMiddleName())
                .lastName(employeeRequestDto.getEmployee().getLastName())
                .gender(employeeRequestDto.getEmployee().getGender())
                .mobile(employeeRequestDto.getEmployee().getMobile())
                .dateOfBirth(employeeRequestDto.getEmployee().getDateOfBirth())
                .eduType(employeeRequestDto.getEmployee().getEduType())
                .idType(employeeRequestDto.getEmployee().getIdType())
                .idNo(employeeRequestDto.getEmployee().getIdNo())
                .reportsTo(employeeRequestDto.getEmployee().getReportsTo())
                .designation(employeeRequestDto.getEmployee().getDesignation())
                .grade(employeeRequestDto.getEmployee().getGrade())
                .status(employeeRequestDto.getEmployee().getStatus())
                .curAddress(CommonCode.getAddress(employeeRequestDto.getEmployee().getCurAddress()))
                .currAddSameAsPermAdd(employeeRequestDto.getEmployee().isCurrAddSameAsPermAdd())
                .permAddress(CommonCode.getAddress(employeeRequestDto.getEmployee().getPermAddress()))
                .department(departmentRepository.findById(employeeRequestDto.getEmployee().getEmpDeptId()).get())
                .build();
    }
}
