package com.hotel.dto.admin.employee;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.hotel.dto.admin.BasicAdminRequest;
import lombok.*;

/**
 * Employee Request DTO
 * @author rgonda
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder(value = {"employee"})
public class EmployeeRequestDto extends BasicAdminRequest {
    private EmployeeObjectDto employee;
}