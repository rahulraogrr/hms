package com.hotel.dto.admin.department;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder(value = {"type", "name", "status", "deptHotelId"})
public class DepartmentObjectDto {

    private int id;

    @Min(value = 1, message = "Department type must be a positive value")
    private int type;

    @NotBlank(message = "Department name is required")
    @Size(max = 100, message = "Department name must not exceed 100 characters")
    private String name;

    @Min(value = 1, message = "Status must be a positive value")
    private int status;

    /** Nullable — a department may belong to a resort instead of a hotel */
    private Integer deptHotelId;
}
