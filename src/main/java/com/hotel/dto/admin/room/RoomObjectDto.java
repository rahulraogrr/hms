package com.hotel.dto.admin.room;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.Min;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder(value = {"type", "area", "status", "roomFloorId"})
public class RoomObjectDto {

    private int id;

    @Min(value = 1, message = "Room type must be a positive value")
    private int type;

    @Min(value = 1, message = "Area must be at least 1 sq ft")
    private int area;

    @Min(value = 1, message = "Status must be a positive value")
    private int status;

    @Min(value = 1, message = "Floor ID must be a positive number")
    private int roomFloorId;
}
