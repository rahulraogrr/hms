package com.hotel.dto.admin.group;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.hotel.dto.portal.AddressDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@JsonPropertyOrder(value = {
        "name", "status", "address"
})
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
    @NotBlank(message = "Group name is required")
    @Size(max = 20, message = "Group name must not exceed 20 characters")
    private String name;

    @Min(value = 1, message = "Status must be a positive value")
    @Schema(
            title = "status",
            name = "status",
            description = "Status of the Group. Ex : 1 - Active",
            example = "1",
            required = true
    )
    private int status;

    @NotNull(message = "Address is required")
    @Valid
    @Schema(
            title = "address",
            name = "address",
            required = true
    )
    private AddressDto address;
}