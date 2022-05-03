package com.hotel.services.admin;

import com.hotel.dto.admin.HotelRequestDto;
import com.hotel.dto.admin.HotelResponseDto;
import com.hotel.services.CrudService;

/**
 * Hotel Service
 */
public interface HotelService extends CrudService<HotelRequestDto, HotelResponseDto, Integer> {

}
