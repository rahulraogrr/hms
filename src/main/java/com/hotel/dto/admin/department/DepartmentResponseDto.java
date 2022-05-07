package com.hotel.dto.admin.department;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.hotel.dto.admin.BasicAdminResponse;
import lombok.*;

/**
 * Department Response Dto
 * @author rgonda
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder(value = {"department"})
public class DepartmentResponseDto extends BasicAdminResponse {
    private DepartmentObjectDto department;
}