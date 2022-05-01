package com.hotel.dto.admin;

import com.hotel.dto.BasicAdminResponse;
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