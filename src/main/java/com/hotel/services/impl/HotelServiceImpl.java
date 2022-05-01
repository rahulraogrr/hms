package com.hotel.services.impl;

import com.hotel.entites.Hotel;
import com.hotel.repositories.HotelRepository;
import com.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("HotelServiceImpl")
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel create(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel findById(Integer id) {
        return hotelRepository.findById(id).get();
    }

    @Override
    public void deleteById(Integer id) {
        hotelRepository.deleteById(id);
    }

    @Override
    public Hotel modify(Integer id, Hotel hotel) {
        //TODO: Hotel Modify Service
        return null;
    }
}