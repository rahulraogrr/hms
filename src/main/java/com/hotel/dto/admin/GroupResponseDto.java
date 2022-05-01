package com.hotel.dto.admin;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.hotel.dto.BasicAdminResponse;
import com.hotel.dto.portal.AddressDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * A Group Response
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class GroupResponseDto extends BasicAdminResponse {
    private GroupObjectDto group;
}