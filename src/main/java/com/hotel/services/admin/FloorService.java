package com.hotel.services.admin;

import com.hotel.dto.admin.FloorRequestDto;
import com.hotel.dto.admin.FloorResponseDto;
import com.hotel.services.CrudService;

/**
 * Floor Service
 *
 * @author rgonda
 */
public interface FloorService extends CrudService<FloorRequestDto, FloorResponseDto, Integer> {

}
