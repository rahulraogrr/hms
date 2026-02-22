package com.hotel.services.validators.admin;

import com.hotel.dto.admin.hotel.HotelRequestDto;
import com.hotel.exceptions.ResourceNotFoundException;
import com.hotel.repositories.admin.GroupRepository;
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
        int groupId = hotelRequestDto.getHotel().getGroupId();
        if(groupRepository.findById(groupId).isEmpty())
            throw new ResourceNotFoundException("Group", groupId);
    }
}