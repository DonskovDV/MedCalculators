package com.MedCalculator.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "medicalc",
                description = "Medical Calculator", version = "1.0.0",
                contact = @Contact(
                        name = "Donskov Danila",
                        email = "daniladonskov01@gmail.com"
                )
        )
)

public class OpenApiConfig {

}