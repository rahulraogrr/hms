package com.hotel.dto.admin;

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
    private int noOfRooms;
    private int status;
    private int hotelId;
}
