package com.hotel.api.auth;

import com.hotel.dto.auth.LoginRequest;
import com.hotel.dto.auth.LoginResponse;
import com.hotel.dto.auth.RefreshTokenRequest;
import com.hotel.services.auth.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Authentication endpoints — publicly accessible, no JWT required.
 */
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication", description = "Login and token refresh")
public class AuthController {

    private final AuthService authService;

    /**
     * Authenticate with username + password; returns access and refresh tokens.
     */
    @PostMapping("/login")
    @Operation(summary = "Login", description = "Returns JWT access and refresh tokens")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    /**
     * Exchange a valid refresh token for a new access token.
     */
    @PostMapping("/refresh")
    @Operation(summary = "Refresh token", description = "Issues a new access token using a refresh token")
    public ResponseEntity<LoginResponse> refresh(@Valid @RequestBody RefreshTokenRequest request) {
        return ResponseEntity.ok(authService.refresh(request));
    }
}
