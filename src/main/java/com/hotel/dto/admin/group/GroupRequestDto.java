package com.hotel.dto.admin.group;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.hotel.dto.admin.BasicAdminRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
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
@Builder
public class GroupRequestDto extends BasicAdminRequest {
    @NotNull(message = "Group object is required")
    @Valid
    private GroupObjectDto group;
}