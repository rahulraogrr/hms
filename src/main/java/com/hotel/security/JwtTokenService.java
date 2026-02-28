package com.hotel.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;

import java.time.Instant;

/**
 * Encodes and decodes JWT access and refresh tokens using Spring Security's
 * Nimbus-backed {@link JwtEncoder} / {@link JwtDecoder}.
 *
 * <p>Claims layout:
 * <pre>
 *   sub          – username
 *   role         – single role name (e.g. "SUPER_ADMIN")
 *   token_type   – "access" | "refresh"
 *   iss          – "hms-api"
 *   iat / exp    – standard timestamps
 * </pre>
 */
@Service
@RequiredArgsConstructor
public class JwtTokenService {

    private final JwtEncoder jwtEncoder;
    private final JwtDecoder jwtDecoder;

    @Value("${app.jwt.access-token-expiry:1800}")
    private long accessTokenExpiry;   // seconds, default 30 min

    @Value("${app.jwt.refresh-token-expiry:604800}")
    private long refreshTokenExpiry;  // seconds, default 7 days

    // ── Encoding ─────────────────────────────────────────────────────────────

    public String generateAccessToken(UserDetails user) {
        return buildToken(user, "access", accessTokenExpiry);
    }

    public String generateRefreshToken(UserDetails user) {
        return buildToken(user, "refresh", refreshTokenExpiry);
    }

    private String buildToken(UserDetails user, String tokenType, long expirySeconds) {
        Instant now  = Instant.now();
        String role  = user.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .map(a -> a.replace("ROLE_", ""))
                .findFirst()
                .orElse("");

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("hms-api")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expirySeconds))
                .subject(user.getUsername())
                .claim("role", role)
                .claim("token_type", tokenType)
                .build();

        JwsHeader header = JwsHeader.with(MacAlgorithm.HS256).build();
        return jwtEncoder.encode(JwtEncoderParameters.from(header, claims)).getTokenValue();
    }

    // ── Decoding ─────────────────────────────────────────────────────────────

    /**
     * Decodes and validates a token, then returns the embedded username.
     * Throws {@link JwtException} if the token is expired or tampered.
     */
    public String extractUsername(String token) {
        return jwtDecoder.decode(token).getSubject();
    }

    /**
     * Returns the {@code token_type} claim value ("access" or "refresh").
     */
    public String extractTokenType(String token) {
        return jwtDecoder.decode(token).getClaimAsString("token_type");
    }

    public long getAccessTokenExpiry() {
        return accessTokenExpiry;
    }
}
