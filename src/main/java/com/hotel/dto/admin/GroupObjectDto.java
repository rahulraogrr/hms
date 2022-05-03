package com.hotel.dto.admin;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.hotel.dto.portal.AddressDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@JsonPropertyOrder(value = {
        "name", "status", "address"
})
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GroupObjectDto {

    @Schema(
            title = "id",
            name = "id",
            example = "1",
            description = "ID of the Group Entity. Required when we send browse request"
    )
    private int id;

    @Schema(
            title = "name",
            name = "name",
            description = "Group Name",
            example = "Taj Group Of Hotels",
            required = true
    )
    private String name;

    @Schema(
            title = "status",
            name = "status",
            description = "Status of the Group. Ex : 1 - Active",
            example = "1",
            required = true
    )
    private int status;

    @Schema(
            title = "address",
            name = "address",
            required = true
    )
    private AddressDto address;
}