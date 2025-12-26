package com.example.demo.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Complaint Duplicate Detector API",
                version = "1.0",
                description = "API documentation for Complaint Duplicate Detector"
        )
)
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title("Complaint Duplicate Detector API")
                        .version("1.0")
                        .description("API documentation")
                        .contact(new Contact().name("Support"))
                        .license(new License().name("Apache 2.0"))
                );
    }
}
