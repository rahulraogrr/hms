package com.hotel.dto.admin.hotel;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.hotel.dto.portal.AddressDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@JsonPropertyOrder(
        value = {
                "id", "name", "status", "noOfFloors", "openDate", "groupId", "address"
        })
public class HotelObjectDto {
    @Schema(
            title = "id",
            name = "id",
            example = "1",
            description = "ID of the Hotel Entity. Required when we send browse request"
    )
    private int id;

    @Schema(
            title = "name",
            name = "name",
            description = "Hotel Name",
            example = "Taj Krishna",
            required = true
    )
    private String name;

    @Schema(
            title = "status",
            name = "status",
            description = "Status of the hotel. Ex : 1 - Active",
            example = "1",
            required = true
    )
    private int status;

    @Schema(
            title = "noOfFloors",
            name = "noOfFloors",
            description = "No of floors",
            example = "4",
            required = true
    )
    private int noOfFloors;

    @Schema(
            title = "openDate",
            name = "openDate",
            description = "Hotel Opening Date",
            example = "25-03-1989",
            required = true
    )
    private Date openDate;

    @Schema(
            title = "groupId",
            name = "groupId",
            description = "Hotel Group ID",
            example = "1",
            required = true
    )
    private int groupId;

    @Schema(
            title = "address",
            name = "address",
            description = "Hotel Address",
            required = true
    )
    private AddressDto address;
}