package com.hotel.services.validators.admin;

import com.hotel.dto.admin.FloorRequestDto;
import com.hotel.services.validators.ServiceValidatorGeneric;
import org.springframework.stereotype.Component;

/**
 * Floor Validation Class
 */
@Component
public class FloorValidator implements ServiceValidatorGeneric<FloorRequestDto> {

    @Override
    public void validateRequest(FloorRequestDto floorRequestDto) {

    }
}
