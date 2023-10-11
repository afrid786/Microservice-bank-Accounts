package com.afrid.bank;

import com.afrid.bank.dto.AccountsContactInfo;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditaware")
@EnableConfigurationProperties(value = {AccountsContactInfo.class})
@OpenAPIDefinition(info = @Info(
		title = "Account Microservice API Documentation",
		description = "Bank's account microservice swagger api documentation",
		version = "v1",
		contact = @Contact(
				name = "Sekh Afrid"
		),
		license = @License(name = "Apache 2.0")
))
public class BankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}

}
