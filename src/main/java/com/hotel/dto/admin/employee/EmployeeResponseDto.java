package com.hotel.dto.admin.employee;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.hotel.dto.admin.BasicAdminResponse;
import lombok.*;

/**
 * Employee Response DTO
 * @author rgonda
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder(value = {"employee"})
public class EmployeeResponseDto extends BasicAdminResponse {
    private EmployeeObjectDto employee;
}