package com.hotel.util;

import com.hotel.dto.portal.AddressDto;
import com.hotel.entites.Address;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CommonCode {

    /**
     * Returns AddressDto Object
     *
     * @param savedAddress Saved Address
     * @return {@link AddressDto} Object
     */
    public AddressDto getAddressDto(Address savedAddress) {
        AddressDto addressDto = new AddressDto();
        addressDto.setAddress1(savedAddress.getAddress1());
        addressDto.setAddress2(savedAddress.getAddress2());
        addressDto.setType(savedAddress.getType());
        addressDto.setCity(savedAddress.getCity());
        addressDto.setState(savedAddress.getState());
        addressDto.setCountry(savedAddress.getCountry());
        addressDto.setPinCode(savedAddress.getPinCode());
        addressDto.setId(savedAddress.getId());
        return addressDto;
    }

    /**
     * Returns Address Object
     *
     * @param addressDto Address DTO
     * @return {@link Address} Object
     */
    public Address getAddress(AddressDto addressDto) {
        Address address = new Address();
        address.setAddress1(addressDto.getAddress1());
        address.setAddress2(addressDto.getAddress2());
        address.setType(addressDto.getType());
        address.setCity(addressDto.getCity());
        address.setState(addressDto.getState());
        address.setCountry(addressDto.getCountry());
        address.setPinCode(addressDto.getPinCode());
        return address;
    }

}
