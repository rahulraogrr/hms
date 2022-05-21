package com.hotel.services.helpers.admin;

import com.hotel.repositories.admin.FloorRepository;
import com.hotel.repositories.admin.RoomRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class RoomHelperTest {

    @Mock
    private RoomRepository roomRepository;

    @Mock
    private FloorRepository floorRepository;

    private RoomHelper roomHelper;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        roomHelper = new RoomHelper(roomRepository,floorRepository);
    }

    @Test
    void create() {

    }

    @Test
    void findAll() {

    }

    @Test
    void findById() {
        //Given

        //When

        //Then
    }

    @Test
    void deleteById() {
        //Given

        //When

        //Then
    }

    @Test
    void modify() {
        //Given

        //When

        //Then
    }
}