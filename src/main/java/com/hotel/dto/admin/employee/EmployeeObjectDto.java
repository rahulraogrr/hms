package com.hotel.dto.admin.employee;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.hotel.constants.Gender;
import com.hotel.dto.portal.AddressDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Date;

/**
 * Employee Object DTO
 *
 * @author rgonda
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder(value = {"id", "firstName", "middleName", "lastName", "gender", "mobile",
        "dateOfBirth", "eduType", "hireDate", "idType", "idNo", "empDeptId", "reportsTo",
        "designation", "grade", "status", "curAddress", "currAddSameAsPermAdd", "permAddress"})
public class EmployeeObjectDto {

    private long id;

    @NotBlank(message = "First name is required")
    @Size(max = 50, message = "First name must not exceed 50 characters")
    private String firstName;

    @Size(max = 50, message = "Middle name must not exceed 50 characters")
    private String middleName;

    @NotBlank(message = "Last name is required")
    @Size(max = 50, message = "Last name must not exceed 50 characters")
    private String lastName;

    @NotNull(message = "Gender is required")
    private Gender gender;

    @Pattern(regexp = "^[+]?[0-9]{7,15}$", message = "Mobile number must be 7–15 digits, optionally prefixed with '+'")
    private String mobile;

    @Past(message = "Date of birth must be in the past")
    private Date dateOfBirth;

    @Min(value = 1, message = "Education type must be a positive value")
    private int eduType;

    @PastOrPresent(message = "Hire date cannot be in the future")
    private Date hireDate;

    @Min(value = 1, message = "ID type must be a positive value")
    private int idType;

    @Size(max = 50, message = "ID number must not exceed 50 characters")
    private String idNo;

    @Positive(message = "Department ID must be a positive number")
    private int empDeptId;

    /** 0 means no manager */
    private long reportsTo;

    @Min(value = 1, message = "Designation must be a positive value")
    private int designation;

    @Min(value = 1, message = "Grade must be a positive value")
    private int grade;

    @Min(value = 1, message = "Status must be a positive value")
    private int status;

    @NotNull(message = "Current address is required")
    @Valid
    private AddressDto curAddress;

    private boolean currAddSameAsPermAdd;

    @NotNull(message = "Permanent address is required")
    @Valid
    private AddressDto permAddress;
}
