package com.hotel.dto.admin;

import com.hotel.dto.BasicAdminRequest;
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