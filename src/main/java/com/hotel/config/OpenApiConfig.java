package com.hotel.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Open API Configuration
 * @author rgonda
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .info(
                        new Info()
                                .title("HMS API")
                                .version("1.0")
                                .description("Hotel Management System API")
                                .termsOfService("https://github.com/rahulraogrr/hms")
                                .contact(
                                        new Contact()
                                                .name("Rahul Rao Gonda")
                                                .url("https://github.com/rahulraogrr")
                                                .email("rahulrao.grr@gmail.com")
                                )
                );
    }

}