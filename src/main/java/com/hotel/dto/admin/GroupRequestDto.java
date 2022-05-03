package com.hotel.dto.admin;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.hotel.dto.BasicAdminRequest;
import lombok.*;

/**
 * Group API Request
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonPropertyOrder(
        value = {"group"}
)
public class GroupRequestDto extends BasicAdminRequest {
    private GroupObjectDto group;
}