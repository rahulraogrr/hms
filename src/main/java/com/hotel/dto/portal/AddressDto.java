package com.hotel.dto.portal;

import lombok.Data;

/**
 * An Address DTO
 */
@Data
public class AddressDto {
    private int type;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String country;
    private String pinCode;
}