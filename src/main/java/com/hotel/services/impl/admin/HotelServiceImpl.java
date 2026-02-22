package com.hotel.services.impl.admin;

import com.hotel.dto.admin.hotel.HotelRequestDto;
import com.hotel.dto.admin.hotel.HotelResponseDto;
import com.hotel.services.admin.HotelService;
import com.hotel.services.helpers.admin.HotelHelper;
import com.hotel.services.validators.admin.HotelValidator;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Hotel Service Implementation
 */
@Service("HotelServiceImpl")
public class HotelServiceImpl implements HotelService {

    private final HotelHelper hotelHelper;
    private final HotelValidator hotelValidator;

    HotelServiceImpl(HotelHelper hotelHelper, HotelValidator hotelValidator){
        this.hotelHelper=hotelHelper;
        this.hotelValidator=hotelValidator;
    }

    @Override
    public HotelResponseDto create(HotelRequestDto hotelRequestDto) {
        hotelValidator.validateRequest(hotelRequestDto);
        return hotelHelper.create(hotelRequestDto);
    }

    @Override
    public List<HotelResponseDto> findAll(int page, int size) {
        return hotelHelper.findAll(page, size);
    }

    @Override
    public HotelResponseDto findById(Integer id) {
        return hotelHelper.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        hotelHelper.deleteById(id);
    }

    @Override
    public HotelResponseDto modify(Integer id, HotelRequestDto hotelRequestDto) {
        hotelValidator.validateRequest(hotelRequestDto);
        return hotelHelper.modify(id,hotelRequestDto);
    }
}