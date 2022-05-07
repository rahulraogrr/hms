package com.hotel.services.helpers.admin;

import com.hotel.dto.admin.room.RoomRequestDto;
import com.hotel.dto.admin.room.RoomResponseDto;
import com.hotel.services.helpers.CrudServiceHelperGeneric;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Room Helper Class
 *
 * @author rgonda
 */
@Slf4j
@Component
public class RoomHelper implements CrudServiceHelperGeneric<RoomRequestDto, RoomResponseDto, Integer> {

    @Override
    public RoomResponseDto create(RoomRequestDto roomRequestDto) {
        return null;
    }

    @Override
    public List<RoomResponseDto> findAll() {
        return null;
    }

    @Override
    public RoomResponseDto findById(Integer id) {
        return null;
    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }

    @Override
    public RoomResponseDto modify(Integer id, RoomRequestDto roomRequestDto) {
        return null;
    }
}
