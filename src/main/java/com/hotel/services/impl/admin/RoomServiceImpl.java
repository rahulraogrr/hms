package com.hotel.services.impl.admin;

import com.hotel.dto.admin.room.RoomRequestDto;
import com.hotel.dto.admin.room.RoomResponseDto;
import com.hotel.services.admin.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Room Service Implementation
 *
 * @author rgonda
 */
@Slf4j
@Service("RoomServiceImpl")
public class RoomServiceImpl implements RoomService {

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
    public void deleteById(Integer id) {

    }

    @Override
    public RoomResponseDto modify(Integer id, RoomRequestDto roomRequestDto) {
        return null;
    }
}
