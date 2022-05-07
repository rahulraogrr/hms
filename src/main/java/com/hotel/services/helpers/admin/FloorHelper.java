package com.hotel.services.helpers.admin;

import com.hotel.dto.admin.floor.FloorObjectDto;
import com.hotel.dto.admin.floor.FloorRequestDto;
import com.hotel.dto.admin.floor.FloorResponseDto;
import com.hotel.entites.admin.Floor;
import com.hotel.repositories.admin.FloorRepository;
import com.hotel.repositories.admin.HotelRepository;
import com.hotel.services.helpers.CrudServiceHelperGeneric;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Floor Helper
 *
 * @author rgonda
 */
@Slf4j
@Component
public class FloorHelper implements CrudServiceHelperGeneric<FloorRequestDto, FloorResponseDto, Integer> {

    private final HotelRepository hotelRepository;
    private final FloorRepository floorRepository;

    FloorHelper(HotelRepository hotelRepository, FloorRepository floorRepository){
        this.hotelRepository = hotelRepository;
        this.floorRepository = floorRepository;
    }

    @Override
    public FloorResponseDto create(FloorRequestDto floorRequestDto) {
        return getFloorResponse(floorRepository.save(getFloor(floorRequestDto)));
    }

    @Override
    public List<FloorResponseDto> findAll() {
        return floorRepository.findAll().stream()
                .map(FloorHelper::getFloorResponse)
                .collect(Collectors.toList());
    }

    @Override
    public FloorResponseDto findById(Integer id) {
        return getFloorResponse(floorRepository.findById(id).get());
    }

    @Override
    public boolean deleteById(Integer id) {
        floorRepository.deleteById(id);
        return true;
    }

    @Override
    public FloorResponseDto modify(Integer id, FloorRequestDto floorRequestDto) {
        return null;
    }

    private static FloorResponseDto getFloorResponse(Floor floor){
        return FloorResponseDto.builder()
                .floor(
                        FloorObjectDto.builder()
                                .id(floor.getId())
                                .status(floor.getStatus())
                                .noOfRooms(floor.getNoOfRooms())
                                .hotelId(floor.getHotel().getId())
                                .build()
                )
                .build();
    }

    private Floor getFloor(FloorRequestDto floorRequestDto){
        return Floor.builder()
                .noOfRooms(floorRequestDto.getFloor().getNoOfRooms())
                .status(floorRequestDto.getFloor().getStatus())
                .hotel(hotelRepository.getById(floorRequestDto.getFloor().getHotelId()))
                .build();
    }
}