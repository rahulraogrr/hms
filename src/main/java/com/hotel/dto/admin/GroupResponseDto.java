package com.hotel.dto.admin;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.hotel.dto.BasicAdminResponse;
import lombok.*;

/**
 * A Group Response
 */
@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder(value = {"group"})
public class GroupResponseDto extends BasicAdminResponse {
    private GroupObjectDto group;
}