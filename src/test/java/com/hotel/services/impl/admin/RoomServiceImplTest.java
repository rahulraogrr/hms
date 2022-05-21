package com.hotel.services.impl.admin;

import com.hotel.services.helpers.admin.RoomHelper;
import com.hotel.services.validators.admin.RoomValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
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
    }
}