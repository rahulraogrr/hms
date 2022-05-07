package com.hotel.dto.admin.floor;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

/**
 * Floor Object
 *
 * @author rgonda
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonPropertyOrder(value = {"noOfRooms","status","hotelId"})
public class FloorObjectDto {
    private int id;
    private int noOfRooms;
    private int status;
    private int hotelId;
}
