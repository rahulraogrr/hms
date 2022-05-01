package com.hotel.dto.admin;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.hotel.dto.BasicAdminRequest;
import com.hotel.dto.portal.AddressDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Group API Request
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class GroupRequestDto extends BasicAdminRequest {
    private GroupObjectDto group;
}