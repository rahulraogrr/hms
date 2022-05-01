package com.hotel.dto.admin;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.hotel.dto.portal.AddressDto;
import lombok.Data;

@Data
@JsonPropertyOrder(value = {
        "name", "status", "address"
})
public class GroupObjectDto {
    private String name;
    private int status;
    private AddressDto address;
}
