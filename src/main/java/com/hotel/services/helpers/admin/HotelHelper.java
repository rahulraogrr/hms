package com.hotel.services.helpers.admin;

import com.hotel.dto.admin.HotelObjectDto;
import com.hotel.dto.admin.HotelRequestDto;
import com.hotel.dto.admin.HotelResponseDto;
import com.hotel.entites.admin.Hotel;
import com.hotel.repositories.GroupRepository;
import com.hotel.repositories.HotelRepository;
import com.hotel.services.helpers.CrudServiceHelperGeneric;
import com.hotel.util.CommonCode;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class HotelHelper implements CrudServiceHelperGeneric<HotelRequestDto, HotelResponseDto, Integer> {

    private final GroupRepository groupRepository;
    private final HotelRepository hotelRepository;

    HotelHelper(GroupRepository groupRepository, HotelRepository hotelRepository){
        this.groupRepository = groupRepository;
        this.hotelRepository = hotelRepository;
    }

    @Override
    public HotelResponseDto create(HotelRequestDto hotelRequestDto) {

        return getHotelResponse(hotelRepository.save(Hotel.builder()
                .address(CommonCode.getAddress(hotelRequestDto.getHotel().getAddress()))
                .noOfFloors(hotelRequestDto.getHotel().getNoOfFloors())
                .openDate(hotelRequestDto.getHotel().getOpenDate())
                .name(hotelRequestDto.getHotel().getName())
                .status(hotelRequestDto.getHotel().getStatus())
                .group(groupRepository.getById(hotelRequestDto.getHotel().getGroupId()))
                .build()));
    }

    @Override
    public List<HotelResponseDto> findAll() {
        return hotelRepository.findAll().stream().map(HotelHelper::getHotelResponse).collect(Collectors.toList());
    }

    private static HotelResponseDto getHotelResponse(Hotel hotel) {
        return HotelResponseDto.builder()
                .hotel(HotelObjectDto.builder()
                        .address(CommonCode.getAddressDto(hotel.getAddress()))
                        .id(hotel.getId())
                        .name(hotel.getName())
                        .noOfFloors(hotel.getNoOfFloors())
                        .openDate(hotel.getOpenDate())
                        .status(hotel.getStatus())
                        .groupId(hotel.getGroup().getId())
                        .build())
                .build();
    }

    @Override
    public HotelResponseDto findById(Integer id) {
        return getHotelResponse(hotelRepository.findById(id).get());
    }

    @Override
    public boolean deleteById(Integer id) {
        hotelRepository.deleteById(id);
        return true;
    }

    @Override
    public HotelResponseDto modify(Integer id, HotelRequestDto requestDto) {
        return null;
    }
}