package org.example.j3b3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class J3b3Application {

	public static void main(String[] args) {
		SpringApplication.run(J3b3Application.class, args);
	}

}
