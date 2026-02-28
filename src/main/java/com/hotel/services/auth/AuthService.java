package com.hotel.services.auth;

import com.hotel.dto.auth.LoginRequest;
import com.hotel.dto.auth.LoginResponse;
import com.hotel.dto.auth.RefreshTokenRequest;
import com.hotel.exceptions.ResourceNotFoundException;
import com.hotel.security.JwtTokenService;
import com.hotel.security.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

/**
 * Handles login and token refresh business logic.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager    authenticationManager;
    private final JwtTokenService          jwtTokenService;
    private final UserDetailsServiceImpl   userDetailsService;

    /**
     * Validates credentials and returns a fresh token pair.
     */
    public LoginResponse login(LoginRequest request) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(), request.getPassword()));

        UserDetails user = (UserDetails) auth.getPrincipal();
        log.info("Login successful for user '{}'", user.getUsername());

        return LoginResponse.builder()
                .accessToken(jwtTokenService.generateAccessToken(user))
                .refreshToken(jwtTokenService.generateRefreshToken(user))
                .expiresIn(jwtTokenService.getAccessTokenExpiry())
                .build();
    }

    /**
     * Validates a refresh token and issues a new access token.
     * The refresh token itself is returned unchanged.
     */
    public LoginResponse refresh(RefreshTokenRequest request) {
        String token = request.getRefreshToken();

        try {
            String tokenType = jwtTokenService.extractTokenType(token);
            if (!"refresh".equals(tokenType)) {
                throw new ResponseStatusException(UNAUTHORIZED, "Not a refresh token");
            }

            String username    = jwtTokenService.extractUsername(token);
            UserDetails user   = userDetailsService.loadUserByUsername(username);

            if (!user.isEnabled() || !user.isAccountNonLocked()) {
                throw new ResponseStatusException(UNAUTHORIZED, "Account is disabled or locked");
            }

            log.info("Token refresh successful for user '{}'", username);

            return LoginResponse.builder()
                    .accessToken(jwtTokenService.generateAccessToken(user))
                    .refreshToken(token)   // rotate if desired; keep as-is for now
                    .expiresIn(jwtTokenService.getAccessTokenExpiry())
                    .build();

        } catch (JwtException ex) {
            log.warn("Invalid refresh token: {}", ex.getMessage());
            throw new ResponseStatusException(UNAUTHORIZED, "Invalid or expired refresh token");
        }
    }
}
