package com.hotel.api.admin;

import com.hotel.services.admin.RoomService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class RoomControllerTest {
    @Mock
    private RoomService roomService;

    private RoomController roomController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        roomController = new RoomController(roomService);
    }

    @Test
    void createRoom() {
    }

    @Test
    void getAllRooms() {
    }

    @Test
    void getRoomById() {
    }

    @Test
    void deleteRoomById() {
    }

    @Test
    void modifyRoomById() {
    }
}