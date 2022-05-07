package com.hotel.dto.admin.room;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.hotel.dto.admin.BasicAdminRequest;
import lombok.*;

/**
 * Room Request DTO
 * @author rgonda
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder(value = {"room"})
public class RoomRequestDto extends BasicAdminRequest {
    private RoomObjectDto room;
}