package com.hotel.dto.admin.room;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.hotel.dto.admin.BasicAdminResponse;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder(value = {"room"})
public class RoomResponseDto extends BasicAdminResponse {
    private RoomObjectDto room;
}
