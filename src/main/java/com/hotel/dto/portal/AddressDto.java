package com.hotel.dto.portal;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

/**
 * Address DTO — shared across all resources that carry an address.
 */
@EqualsAndHashCode(callSuper = false)
@JsonPropertyOrder(value = {"id", "type", "address1", "address2", "city", "state", "country", "pinCode"})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDto {

    @Schema(title = "id", example = "1",
            description = "ID of the Address Entity. Required when we send browse request")
    private long id;

    @Positive(message = "Address type must be a positive value")
    @Schema(title = "type", example = "1", description = "Type of address", required = true)
    private int type;

    @NotBlank(message = "Address line 1 is required")
    @Size(max = 100, message = "Address 1 must not exceed 100 characters")
    @Schema(title = "address1", example = "Churchgate", description = "Primary address line", required = true)
    private String address1;

    @Size(max = 100, message = "Address 2 must not exceed 100 characters")
    @Schema(title = "address2", example = "Colaba", description = "Secondary address line")
    private String address2;

    @NotBlank(message = "City is required")
    @Size(max = 60, message = "City must not exceed 60 characters")
    @Schema(title = "city", example = "Mumbai", description = "City", required = true)
    private String city;

    @NotBlank(message = "State is required")
    @Size(max = 60, message = "State must not exceed 60 characters")
    @Schema(title = "state", example = "Maharashtra", description = "State", required = true)
    private String state;

    @NotBlank(message = "Country is required")
    @Size(max = 60, message = "Country must not exceed 60 characters")
    @Schema(title = "country", example = "India", description = "Country", required = true)
    private String country;

    @NotBlank(message = "Pin code is required")
    @Size(max = 20, message = "Pin code must not exceed 20 characters")
    @Schema(title = "pinCode", example = "400005", description = "Pin / Postal code", required = true)
    private String pinCode;
}
