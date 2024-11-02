package com.demo.security;

import com.demo.security.auth.AuthenticationService;
import com.demo.security.auth.RegisterRequest;
import com.demo.security.user.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.demo.security.user.Role.ADMIN;
import static com.demo.security.user.Role.MANAGER;

@SpringBootApplication
public class SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

		@Bean
        public CommandLineRunner commandLineRunner(
		AuthenticationService service
		) {

			return args -> {
				var admin = RegisterRequest.builder()
						.firstname("Admin")
						.lastname("Admin")
						.email("admin5@admin.com")
						.password("admin")
						.role(ADMIN)
						.build();
				System.out.println("ADMIN token " + service.register(admin).getToken());

				var manager = RegisterRequest.builder()
						.firstname("Manager")
						.lastname("Manager")
						.email("manager5 @manager.com")
						.password("manager")
						.role(MANAGER)
						.build();
				System.out.println("MANAGER token " + service.register(manager).getToken());
			};


		}

	}


