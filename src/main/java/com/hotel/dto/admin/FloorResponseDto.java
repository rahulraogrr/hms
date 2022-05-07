package com.hotel.dto.admin;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.hotel.dto.BasicAdminResponse;
import lombok.*;

/**
 * Floor Response DTO
 *
 * @author rgonda
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder(value = {"floor"})
public class FloorResponseDto extends BasicAdminResponse {
    private FloorRequestDto floor;
}