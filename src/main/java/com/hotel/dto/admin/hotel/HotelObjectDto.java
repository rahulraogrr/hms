package com.hotel.dto.admin.hotel;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.hotel.dto.portal.AddressDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@JsonPropertyOrder(value = {"id", "name", "status", "noOfFloors", "openDate", "groupId", "address"})
public class HotelObjectDto {

    @Schema(title = "id", example = "1",
            description = "ID of the Hotel Entity. Required when we send browse request")
    private int id;

    @NotBlank(message = "Hotel name is required")
    @Size(max = 100, message = "Hotel name must not exceed 100 characters")
    @Schema(title = "name", example = "Taj Krishna", description = "Hotel Name", required = true)
    private String name;

    @Min(value = 1, message = "Status must be a positive value")
    @Schema(title = "status", example = "1", description = "Status of the hotel (1 = Active)", required = true)
    private int status;

    @Min(value = 1, message = "Number of floors must be at least 1")
    @Schema(title = "noOfFloors", example = "4", description = "Number of floors", required = true)
    private int noOfFloors;

    @Schema(title = "openDate", example = "25-03-1989", description = "Hotel Opening Date", required = true)
    private Date founded;

    @Min(value = 1, message = "Group ID must be a positive number")
    @Schema(title = "groupId", example = "1", description = "Hotel Group ID", required = true)
    private int groupId;

    @NotNull(message = "Hotel address is required")
    @Valid
    @Schema(title = "address", description = "Hotel Address", required = true)
    private AddressDto address;
}
