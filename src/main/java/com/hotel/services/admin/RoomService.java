package com.hotel.services.admin;

import com.hotel.dto.admin.room.RoomRequestDto;
import com.hotel.dto.admin.room.RoomResponseDto;
import com.hotel.services.CrudService;

/**
 * Room Service
 *
 * @author rgonda
 */
public interface RoomService extends CrudService<RoomRequestDto, RoomResponseDto, Integer> {
}
