package com.loumo;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootExceptionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootExceptionApplication.class, args);
	}

	@Bean
	public OpenAPI openApi() {
		return new OpenAPI()
				.info(new Info()
						.title("Global handler exception")
						.description("Spring boot Global handler exception")
						.version("v1.0")
						.contact(new Contact()
								.name("Backend")
								.url("https://loumo-tech.com")
								.email("support@loumo-tech.com")
						)
						.termsOfService("TOC")
						.license(new License().name("License").url("#")));
	}

}
