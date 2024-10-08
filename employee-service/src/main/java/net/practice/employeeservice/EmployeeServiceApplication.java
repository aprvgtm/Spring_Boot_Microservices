package net.practice.employeeservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
// swagger general api description to create documentation ...
@OpenAPIDefinition(
		info = @Info(
				title = "Employee Service Rest APIs",
				description = "Employee Service Rest APIs Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Apoorv",
						email = "apoorv.gautam3@gmail.com",
						url = ""
				),
				license = @License(
						name = "Apache 2.0",
						url = "Microservice-Employee"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Employee Service Doc.",
				url = ""
		)
)
@SpringBootApplication
@EnableFeignClients
public class EmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
