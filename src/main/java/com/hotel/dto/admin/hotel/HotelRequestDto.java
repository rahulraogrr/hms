package com.hotel.dto.admin.hotel;

import com.hotel.dto.admin.BasicAdminRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HotelRequestDto extends BasicAdminRequest {
    @NotNull(message = "Hotel object is required")
    @Valid
    private HotelObjectDto hotel;
}
