package com.hotel.services.admin;

import com.hotel.dto.admin.floor.FloorRequestDto;
import com.hotel.dto.admin.floor.FloorResponseDto;
import com.hotel.services.CrudService;

/**
 * Floor Service
 *
 * @author rgonda
 */
public interface FloorService extends CrudService<FloorRequestDto, FloorResponseDto, Integer> {

}
