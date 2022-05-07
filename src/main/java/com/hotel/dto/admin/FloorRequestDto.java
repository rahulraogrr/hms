package com.hotel.dto.admin;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.hotel.dto.BasicAdminRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Floor Request DTO
 *
 * @author rgonda
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder(value = {"floor"})
public class FloorRequestDto extends BasicAdminRequest {
    private FloorRequestDto floor;
}
