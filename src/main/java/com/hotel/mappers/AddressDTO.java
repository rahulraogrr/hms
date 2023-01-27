package com.hotel.mappers;

import com.hotel.dto.portal.AddressDto;
import com.hotel.entites.admin.Address;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class AddressDTO implements Function<AddressDto, Address> {

    @Override
    public Address apply(AddressDto addressDto) {
        return new Address(
                addressDto.getAddress1(),
                addressDto.getAddress2(),
                addressDto.getType(),
                addressDto.getCity(),
                addressDto.getState(),
                addressDto.getCountry(),
                addressDto.getPinCode()
        );
    }
}