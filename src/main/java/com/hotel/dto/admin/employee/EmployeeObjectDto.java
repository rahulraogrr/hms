package com.hotel.dto.admin.employee;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.hotel.constants.Gender;
import com.hotel.dto.portal.AddressDto;
import lombok.*;

import java.util.Date;

/**
 * Employee Object DTO
 * @author rgonda
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder(value = {"id","firstName","middleName","lastName","gender","mobile","dateOfBirth",
        "eduType", "hireDate","idType","idNo","empDeptId","reportsTo","designation","grade","status",
        "curAddress","currAddSameAsPermAdd","permAddress"})
public class EmployeeObjectDto {
    private long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private Gender gender;
    private String mobile;
    private Date dateOfBirth;
    private int eduType;
    private Date hireDate;
    private int idType;
    private String idNo;
    private int empDeptId;
    private long reportsTo;
    private int designation;
    private int grade;
    private int status;
    private AddressDto curAddress;
    private boolean currAddSameAsPermAdd;
    private AddressDto permAddress;
}