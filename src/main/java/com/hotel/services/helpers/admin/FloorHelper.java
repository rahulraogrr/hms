package com.hotel.services.helpers.admin;

import com.hotel.dto.admin.floor.FloorObjectDto;
import com.hotel.dto.admin.floor.FloorRequestDto;
import com.hotel.dto.admin.floor.FloorResponseDto;
import com.hotel.entites.admin.Floor;
import com.hotel.exceptions.ResourceNotFoundException;
import com.hotel.repositories.admin.FloorRepository;
import com.hotel.repositories.admin.HotelRepository;
import com.hotel.services.helpers.CrudServiceHelperGeneric;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
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
    public List<FloorResponseDto> findAll(int page, int size) {
        return floorRepository.findAll(PageRequest.of(page, size))
                .stream()
                .map(FloorHelper::getFloorResponse)
                .collect(Collectors.toList());
    }

    @Override
    public FloorResponseDto findById(Integer id) {
        return getFloorResponse(floorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Floor", id)));
    }

    @Override
    public boolean deleteById(Integer id) {
        floorRepository.deleteById(id);
        return true;
    }

    @Override
    public FloorResponseDto modify(Integer id, FloorRequestDto floorRequestDto) {
        Floor floor = floorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Floor", id));

        floor.setNoOfRooms(floorRequestDto.getFloor().getNoOfRooms());
        floor.setStatus(floorRequestDto.getFloor().getStatus());

        if (floorRequestDto.getFloor().getHotelId() != floor.getHotel().getId()) {
            floor.setHotel(hotelRepository.findById(floorRequestDto.getFloor().getHotelId())
                    .orElseThrow(() -> new ResourceNotFoundException("Hotel", floorRequestDto.getFloor().getHotelId())));
        }

        return getFloorResponse(floorRepository.save(floor));
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
                .hotel(hotelRepository.findById(floorRequestDto.getFloor().getHotelId())
                        .orElseThrow(() -> new ResourceNotFoundException("Hotel", floorRequestDto.getFloor().getHotelId())))
                .build();
    }
}