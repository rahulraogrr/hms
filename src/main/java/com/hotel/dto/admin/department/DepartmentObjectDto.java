package com.hotel.dto.admin.department;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder(value = {"type","name","status","deptHotelId"})
public class DepartmentObjectDto {
    private int id;
    private int type;
    private String name;
    private int status;
    private int deptHotelId;
}