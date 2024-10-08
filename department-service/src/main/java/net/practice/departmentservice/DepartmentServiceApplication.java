package net.practice.departmentservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// swagger general api description to create documentation ...
@OpenAPIDefinition(
		info = @Info(
				title = "Department Service Rest APIs",
				description = "Department Service Rest APIs Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Apoorv",
						email = "apoorv.gautam3@gmail.com",
						url = ""
				),
				license = @License(
						name = "Apache 2.0",
						url = "Microservice-private"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Department Service Doc.",
				url = " "
		)
)
@SpringBootApplication
public class DepartmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

}
