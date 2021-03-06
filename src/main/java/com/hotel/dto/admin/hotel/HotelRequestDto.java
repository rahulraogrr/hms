package com.hotel.dto.admin.hotel;

import com.hotel.dto.admin.BasicAdminRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HotelRequestDto extends BasicAdminRequest {
    private HotelObjectDto hotel;
}
