package com.hotel.dto.portal;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

/**
 * An Address DTO
 */
@EqualsAndHashCode(callSuper = false)
@JsonPropertyOrder(
        value = {
                "id", "type", "address1", "address2", "city", "state", "country", "pinCode"
        }
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDto {
    @Schema(
            title = "id",
            name = "id",
            example = "1",
            description = "ID of the Address Entity. Required when we send browse request"
    )
    private long id;

    @Schema(
            title = "type",
            name = "type",
            example = "1",
            description = "Type of address",
            required = true
    )
    private int type;

    @Schema(
            title = "address1",
            name = "address1",
            example = "Churchgate",
            description = "address description",
            required = true
    )
    private String address1;

    @Schema(
            title = "address2",
            name = "address2",
            example = "Colaba",
            description = "address description 2"
    )
    private String address2;

    @Schema(
            title = "city",
            name = "city",
            example = "Mumbai",
            description = "City",
            required = true
    )
    private String city;

    @Schema(
            title = "state",
            name = "state",
            example = "Maharashtra",
            description = "State",
            required = true
    )
    private String state;

    @Schema(
            title = "country",
            name = "country",
            example = "India",
            description = "Country",
            required = true
    )
    private String country;

    @Schema(
            title = "pinCode",
            name = "pinCode",
            example = "400005",
            description = "Pin Code",
            required = true
    )
    private String pinCode;
}