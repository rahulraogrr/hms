package com.hotel.services.helpers.admin;

import com.hotel.dto.admin.HotelRequestDto;
import com.hotel.dto.admin.HotelResponseDto;
import com.hotel.repositories.HotelRepository;
import com.hotel.services.helpers.ServiceHelperGeneric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HotelHelper implements ServiceHelperGeneric<HotelRequestDto, HotelResponseDto, Integer> {

    @Override
    public HotelResponseDto create(HotelRequestDto hotelRequestDto) {
        return null;
    }

    @Override
    public List<HotelResponseDto> findAll() {
        return null;
    }

    @Override
    public HotelResponseDto findById(Integer id) {
        return null;
    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }

    @Override
    public HotelResponseDto modify(Integer id, HotelRequestDto hotelRequestDto) {
        return null;
    }
}