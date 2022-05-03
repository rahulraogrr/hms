package com.hotel.services.validators.admin;

import com.hotel.dto.admin.GroupRequestDto;
import com.hotel.services.validators.ServiceValidatorGeneric;
import org.springframework.stereotype.Component;

@Component
public class GroupValidator implements ServiceValidatorGeneric<GroupRequestDto> {

    @Override
    public void validateRequest(GroupRequestDto requestDto) {

    }
}
