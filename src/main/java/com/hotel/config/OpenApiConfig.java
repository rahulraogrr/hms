package com.hotel.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .info(
                        new Info()
                                .title("HMS API")
                                .version("1.0")
                                .description("Hotel Management System")
                                .termsOfService("")
                                .contact(
                                        new Contact()
                                                .name("Rahul Rao Gonda")
                                                .url("")
                                                .email("rahulrao.grr@gmail.com")
                                )
                );
    }

}