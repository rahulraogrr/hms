package com.hotel.services.validators.admin;

import com.hotel.dto.admin.room.RoomRequestDto;
import com.hotel.exceptions.ResourceNotFoundException;
import com.hotel.repositories.admin.FloorRepository;
import com.hotel.services.validators.ServiceValidatorGeneric;
import org.springframework.stereotype.Component;

/**
 * Room Validator
 * @author rgonda
 */
@Component
public class RoomValidator implements ServiceValidatorGeneric<RoomRequestDto> {

    private final FloorRepository floorRepository;

    RoomValidator(FloorRepository floorRepository){
        this.floorRepository = floorRepository;
    }

    @Override
    public void validateRequest(RoomRequestDto roomRequestDto) {
        int floorId = roomRequestDto.getRoom().getRoomFloorId();
        if(floorRepository.findById(floorId).isEmpty())
            throw new ResourceNotFoundException("Floor", floorId);
    }
}