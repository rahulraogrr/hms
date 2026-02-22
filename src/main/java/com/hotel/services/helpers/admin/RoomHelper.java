package com.hotel.services.helpers.admin;

import com.hotel.dto.admin.room.RoomObjectDto;
import com.hotel.dto.admin.room.RoomRequestDto;
import com.hotel.dto.admin.room.RoomResponseDto;
import com.hotel.entites.admin.Room;
import com.hotel.exceptions.ResourceNotFoundException;
import com.hotel.repositories.admin.FloorRepository;
import com.hotel.repositories.admin.RoomRepository;
import com.hotel.services.helpers.CrudServiceHelperGeneric;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Room Helper Class
 *
 * @author rgonda
 */
@Slf4j
@Component
public class RoomHelper implements CrudServiceHelperGeneric<RoomRequestDto, RoomResponseDto, Integer> {
    private final RoomRepository roomRepository;
    private final FloorRepository floorRepository;

    RoomHelper(RoomRepository roomRepository, FloorRepository floorRepository){
        this.roomRepository = roomRepository;
        this.floorRepository = floorRepository;
    }

    @Override
    public RoomResponseDto create(RoomRequestDto roomRequestDto) {
        return getRoomResponseDto(roomRepository.save(getRoom(roomRequestDto)));
    }

    @Override
    public List<RoomResponseDto> findAll() {
        return roomRepository.findAll().stream()
                .map(RoomHelper::getRoomResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public RoomResponseDto findById(Integer id) {
        return getRoomResponseDto(roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room", id)));
    }

    @Override
    public boolean deleteById(Integer id) {
        roomRepository.deleteById(id);
        return true;
    }

    @Override
    public RoomResponseDto modify(Integer id, RoomRequestDto roomRequestDto) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room", id));

        room.setType(roomRequestDto.getRoom().getType());
        room.setArea(roomRequestDto.getRoom().getArea());
        room.setStatus(roomRequestDto.getRoom().getStatus());

        if (roomRequestDto.getRoom().getRoomFloorId() != room.getFloor().getId()) {
            room.setFloor(floorRepository.findById(roomRequestDto.getRoom().getRoomFloorId())
                    .orElseThrow(() -> new ResourceNotFoundException("Floor", roomRequestDto.getRoom().getRoomFloorId())));
        }

        return getRoomResponseDto(roomRepository.save(room));
    }

    private static RoomResponseDto getRoomResponseDto(Room room){
        return RoomResponseDto.builder()
                .room(
                        RoomObjectDto.builder()
                                .id(room.getId())
                                .area(room.getArea())
                                .type(room.getType())
                                .status(room.getStatus())
                                .roomFloorId(room.getFloor().getId())
                                .build()
                )
                .build();
    }

    private Room getRoom(RoomRequestDto roomRequestDto){
        return Room.builder()
                .type(roomRequestDto.getRoom().getType())
                .area(roomRequestDto.getRoom().getArea())
                .status(roomRequestDto.getRoom().getStatus())
                .floor(floorRepository.findById(roomRequestDto.getRoom().getRoomFloorId())
                        .orElseThrow(() -> new ResourceNotFoundException("Floor", roomRequestDto.getRoom().getRoomFloorId())))
                .build();
    }
}