package com.techgatha.web;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.techgatha.web.model.User;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
@SecurityScheme(name="userapi",
scheme="basic",
type = SecuritySchemeType.HTTP,
in = SecuritySchemeIn.HEADER)
public class SwaggerOpenApiDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerOpenApiDemoApplication.class, args);
	}


	@Bean
	public OpenAPI configure()
	{
		return new OpenAPI()
				.info(new Info()
						.contact(new Contact()
								.email("contact@techgatha.com")
								.name("Shalini - TechGatha")
								.url("http://www.techgatha.com"))
						.title("Users Details")
						.description("User management Service description goes here")
						.license(new License().url("http://license.org"))
						.termsOfService("Look Here"));
	}

	@Bean
	public  ApplicationRunner run(UserRepository repository) throws Exception {
		return args->{
			Stream.of(new User("U1", "Priya","priya@yahoo.com"),
					new User("U2", "Shalini","shalini@yahoo.com"),
					new User("U3", "Pallavi","pallavi@yahoo.com")
					)
			.forEach(user-> repository.save(user));
			repository.findAll().forEach(System.out::println);

		};
	}
}
