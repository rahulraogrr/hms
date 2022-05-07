package com.hotel.services.impl.admin;

import com.hotel.dto.admin.FloorRequestDto;
import com.hotel.dto.admin.FloorResponseDto;
import com.hotel.services.admin.FloorService;
import com.hotel.services.helpers.admin.FloorHelper;
import com.hotel.services.validators.admin.FloorValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Floor Service Implementation Class
 *
 * @author rgonda
 */
@Slf4j
@Service("FloorServiceImpl")
public class FloorServiceImpl implements FloorService {

    private final FloorHelper floorHelper;
    private final FloorValidator floorValidator;

    FloorServiceImpl(FloorHelper floorHelper, FloorValidator floorValidator){
        this.floorHelper=floorHelper;
        this.floorValidator=floorValidator;
    }

    @Override
    public FloorResponseDto create(FloorRequestDto floorRequestDto) {
        floorValidator.validateRequest(floorRequestDto);
        return floorHelper.create(floorRequestDto);
    }

    @Override
    public List<FloorResponseDto> findAll() {
        return floorHelper.findAll();
    }

    @Override
    public FloorResponseDto findById(Integer id) {
        return floorHelper.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        floorHelper.deleteById(id);
    }

    @Override
    public FloorResponseDto modify(Integer id, FloorRequestDto floorRequestDto) {
        floorValidator.validateRequest(floorRequestDto);
        return floorHelper.modify(id,floorRequestDto);
    }
}