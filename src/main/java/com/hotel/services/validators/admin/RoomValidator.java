package com.hotel.services.validators.admin;

import com.hotel.dto.admin.room.RoomRequestDto;
import com.hotel.services.validators.ServiceValidatorGeneric;
import org.springframework.stereotype.Component;

/**
 * Room Validator
 * @author rgonda
 */
@Component
public class RoomValidator implements ServiceValidatorGeneric<RoomRequestDto> {

    @Override
    public void validateRequest(RoomRequestDto roomRequestDto) {

    }
}
