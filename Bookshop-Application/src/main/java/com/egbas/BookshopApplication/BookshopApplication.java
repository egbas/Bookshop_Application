package com.egbas.BookshopApplication;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(

		info = @Info(
				title = "Book shop Application",
				description = "Application for book organisation",
				version = "2.1.0",
				contact = @Contact(
						name = "Emmanuel Onaivi",
						email = "emmanuelonaivi@gmail.com",
						url = "https://github.com/egbas"
				),
				license = @License(
						name = "Book Shop Application",
						url = "https://github.com/egbas"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Back REST Application for Book shop application",
				url = "https://github.com/egbas"
		)
)
public class BookshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookshopApplication.class, args);
	}

}
