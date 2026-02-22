package com.hotel.services.impl.admin;

import com.hotel.dto.admin.room.RoomRequestDto;
import com.hotel.dto.admin.room.RoomResponseDto;
import com.hotel.services.admin.RoomService;
import com.hotel.services.helpers.admin.RoomHelper;
import com.hotel.services.validators.admin.RoomValidator;
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

    private final RoomHelper roomHelper;
    private final RoomValidator roomValidator;

    RoomServiceImpl(RoomHelper roomHelper,RoomValidator roomValidator){
        this.roomHelper=roomHelper;
        this.roomValidator=roomValidator;
    }

    @Override
    public RoomResponseDto create(RoomRequestDto roomRequestDto) {
        roomValidator.validateRequest(roomRequestDto);
        return roomHelper.create(roomRequestDto);
    }

    @Override
    public List<RoomResponseDto> findAll(int page, int size) {
        return roomHelper.findAll(page, size);
    }

    @Override
    public RoomResponseDto findById(Integer id) {
        return roomHelper.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        roomHelper.deleteById(id);
    }

    @Override
    public RoomResponseDto modify(Integer id, RoomRequestDto roomRequestDto) {
        roomValidator.validateRequest(roomRequestDto);
        return roomHelper.modify(id,roomRequestDto);
    }
}