package com.hotel.mappers;

import com.hotel.dto.portal.AddressDto;
import com.hotel.entites.admin.Address;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class AddressDTOMapper implements Function<Address, AddressDto> {

    @Override
    public AddressDto apply(Address address) {
        return new AddressDto(
                address.getId(),
                address.getType(),
                address.getAddress1(),
                address.getAddress2(),
                address.getCity(),
                address.getState(),
                address.getCountry(),
                address.getPinCode()
        );
    }
}
