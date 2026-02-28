package com.hotel.dto.auth;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"tokenType", "accessToken", "refreshToken", "expiresIn"})
public class LoginResponse {

    /** Always "Bearer" — defaulted by the builder, never needs to be set by callers */
    @Builder.Default
    private String tokenType = "Bearer";

    private String accessToken;
    private String refreshToken;

    /** Access token lifetime in seconds */
    private long expiresIn;
}
