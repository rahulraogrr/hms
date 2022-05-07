package com.hotel.services.helpers.admin;

import com.hotel.dto.admin.FloorRequestDto;
import com.hotel.dto.admin.FloorResponseDto;
import com.hotel.services.helpers.CrudServiceHelperGeneric;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Floor Helper
 *
 * @author rgonda
 */
@Component
@Slf4j
public class FloorHelper implements CrudServiceHelperGeneric<FloorRequestDto, FloorResponseDto, Integer> {

    @Override
    public FloorResponseDto create(FloorRequestDto floorRequestDto) {
        return null;
    }

    @Override
    public List<FloorResponseDto> findAll() {
        return null;
    }

    @Override
    public FloorResponseDto findById(Integer id) {
        return null;
    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }

    @Override
    public FloorResponseDto modify(Integer id, FloorRequestDto floorRequestDto) {
        return null;
    }
}
