package com.hotel.services.validators.admin;

import com.hotel.dto.admin.department.DepartmentRequestDto;
import com.hotel.exceptions.ResourceNotFoundException;
import com.hotel.repositories.admin.HotelRepository;
import com.hotel.services.validators.ServiceValidatorGeneric;
import org.springframework.stereotype.Component;

/**
 * Department Validator
 * @author rgonda
 */
@Component
public class DepartmentValidator implements ServiceValidatorGeneric<DepartmentRequestDto> {

    private final HotelRepository hotelRepository;

    DepartmentValidator(HotelRepository hotelRepository){
        this.hotelRepository=hotelRepository;
    }

    @Override
    public void validateRequest(DepartmentRequestDto departmentRequestDto) {
        int hotelId = departmentRequestDto.getDepartment().getDeptHotelId();
        if(hotelRepository.findById(hotelId).isEmpty())
            throw new ResourceNotFoundException("Hotel", hotelId);
    }
}
