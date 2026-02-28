package com.hotel.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OpenAPI / Swagger configuration.
 * Adds a Bearer JWT security scheme so the Swagger UI shows an Authorize button.
 *
 * @author rgonda
 */
@Configuration
public class OpenApiConfig {

    private static final String SECURITY_SCHEME = "bearerAuth";

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("HMS API")
                        .version("1.0")
                        .description("Hotel Management System API")
                        .termsOfService("https://github.com/rahulraogrr/hms")
                        .contact(new Contact()
                                .name("Rahul Rao Gonda")
                                .url("https://github.com/rahulraogrr")
                                .email("rahulrao.grr@gmail.com")
                        ))
                // Require JWT on all endpoints by default
                .addSecurityItem(new SecurityRequirement().addList(SECURITY_SCHEME))
                .components(new Components()
                        .addSecuritySchemes(SECURITY_SCHEME,
                                new SecurityScheme()
                                        .name(SECURITY_SCHEME)
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                                        .description("Paste your access token here (without 'Bearer ' prefix)")
                        )
                );
    }
}
