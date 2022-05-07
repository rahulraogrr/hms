package com.hotel.dto.admin.department;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.hotel.dto.admin.BasicAdminRequest;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder(value = {"department"})
public class DepartmentRequestDto extends BasicAdminRequest {
    private DepartmentObjectDto department;
}