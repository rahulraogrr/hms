package com.hotel.dto.admin.room;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder(value = {"type","area","status","roomFloorId"})
public class RoomObjectDto {
    private int id;
    private int type;
    private int area;
    private int status;
    private int roomFloorId;
}