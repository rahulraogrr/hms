package com.hotel.services.validators.admin;

import com.hotel.dto.admin.HotelRequestDto;
import com.hotel.repositories.GroupRepository;
import com.hotel.services.validators.ServiceValidatorGeneric;
import org.springframework.stereotype.Component;

@Component
public class HotelValidator implements ServiceValidatorGeneric<HotelRequestDto> {

    private final GroupRepository groupRepository;

    HotelValidator(GroupRepository groupRepository){
        this.groupRepository=groupRepository;
    }

    @Override
    public void validateRequest(HotelRequestDto hotelRequestDto) {
        if(groupRepository.findById(hotelRequestDto.getHotel().getGroupId()).isEmpty())
            throw new RuntimeException();
    }
}