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
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
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
        RoomResponseDto expectedResponse = getValidRoomResponseDTO();

        Mockito.doNothing().when(roomValidator).validateRequest(Mockito.any());
        Mockito.when(roomHelper.create(Mockito.any())).thenReturn(expectedResponse);

        RoomResponseDto response = roomService.create(getValidRoomRequestDTO());

        assertNotNull(response);
        assertEquals(expectedResponse.getRoom().getRoomFloorId(), response.getRoom().getRoomFloorId());
        assertEquals(expectedResponse.getRoom().getArea(), response.getRoom().getArea());
        assertEquals(expectedResponse.getRoom().getStatus(), response.getRoom().getStatus());
        assertEquals(expectedResponse.getRoom().getType(), response.getRoom().getType());
        assertEquals(expectedResponse.getRoom().getId(), response.getRoom().getId());
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