package com.pchudzik.spingmock.security.securitytest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class SecurityTestApplication {
	public static void main(String[] args) {
		SpringApplication.run(SecurityTestApplication.class, args);
	}
}
