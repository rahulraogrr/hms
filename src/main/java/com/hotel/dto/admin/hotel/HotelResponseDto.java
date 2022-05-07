package com.hotel.dto.admin.hotel;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.hotel.dto.admin.BasicAdminResponse;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonPropertyOrder(value = {"hotel"})
public class HotelResponseDto extends BasicAdminResponse {
    private HotelObjectDto hotel;
}
