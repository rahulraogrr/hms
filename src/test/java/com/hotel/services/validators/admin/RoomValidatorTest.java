package com.hotel.services.validators.admin;

import com.hotel.repositories.admin.FloorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class RoomValidatorTest {

    @Mock
    private FloorRepository floorRepository;

    private RoomValidator roomValidator;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        roomValidator = new RoomValidator(floorRepository);
    }

    @Test
    void validateRequest() {

    }
}