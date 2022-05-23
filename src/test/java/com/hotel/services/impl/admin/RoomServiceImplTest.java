package com.hotel.services.impl.admin;

import com.hotel.dto.admin.room.RoomObjectDto;
import com.hotel.dto.admin.room.RoomRequestDto;
import com.hotel.dto.admin.room.RoomResponseDto;
import com.hotel.services.helpers.admin.RoomHelper;
import com.hotel.services.validators.admin.RoomValidator;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class RoomServiceImplTest {

    @Mock
    private RoomHelper roomHelper;

    @Mock
    private RoomValidator roomValidator;

    private RoomServiceImpl roomService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        roomService = new RoomServiceImpl(roomHelper,roomValidator);
    }

    @Test
    void create() {
        roomValidator.validateRequest(Mockito.any());
        Mockito.when(roomHelper.create(Mockito.any())).thenReturn(getValidRoomResponseDTO());

        RoomResponseDto response = roomHelper.create(getValidRoomRequestDTO());

        assertNotNull(response);
        assertEquals(response.getRoom().getRoomFloorId(), getValidRoomRequestDTO().getRoom().getRoomFloorId());
        assertEquals(response.getRoom().getArea(), getValidRoomRequestDTO().getRoom().getArea());
        assertEquals(response.getRoom().getStatus(), getValidRoomRequestDTO().getRoom().getStatus());
        assertEquals(response.getRoom().getType(), getValidRoomRequestDTO().getRoom().getType());
        assertTrue(response.getRoom().getId() > 0);
    }

    private RoomResponseDto getValidRoomResponseDTO() {
        return RoomResponseDto.builder()
                .room(RoomObjectDto.builder()
                        .id(RandomUtils.nextInt())
                        .type(1)
                        .status(1)
                        .roomFloorId(4)
                        .area(300)
                        .build())
                .build();
    }

    private RoomRequestDto getValidRoomRequestDTO() {
        return RoomRequestDto.builder()
                .room(RoomObjectDto.builder()
                        .type(1)
                        .status(1)
                        .roomFloorId(4)
                        .area(300)
                        .build())
                .build();
    }

    @Test
    void findAll() {

    }

    @Test
    void findById() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void modify() {
        //TODO: Modify development is pending
    }
}