package com.cojar.whats_hot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class WhatsHotApplication {

	public static void main(String[] args) {
		SpringApplication.run(WhatsHotApplication.class, args);
	}

}
