package com.hotel.dto.admin.floor;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.Min;
import lombok.*;

/**
 * Floor Object DTO
 *
 * @author rgonda
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonPropertyOrder(value = {"noOfRooms", "status", "hotelId"})
public class FloorObjectDto {

    private int id;

    @Min(value = 1, message = "Number of rooms must be at least 1")
    private int noOfRooms;

    @Min(value = 1, message = "Status must be a positive value")
    private int status;

    @Min(value = 1, message = "Hotel ID must be a positive number")
    private int hotelId;
}
