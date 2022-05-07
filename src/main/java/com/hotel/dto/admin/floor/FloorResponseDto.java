package com.hotel.dto.admin.floor;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.hotel.dto.admin.BasicAdminResponse;
import lombok.*;

/**
 * Floor Response DTO
 *
 * @author rgonda
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder(value = {"floor"})
public class FloorResponseDto extends BasicAdminResponse {
    private FloorObjectDto floor;
}