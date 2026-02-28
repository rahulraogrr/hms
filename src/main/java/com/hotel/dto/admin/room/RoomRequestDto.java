package com.hotel.dto.admin.room;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.hotel.dto.admin.BasicAdminRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "Room object is required")
    @Valid
    private RoomObjectDto room;
}