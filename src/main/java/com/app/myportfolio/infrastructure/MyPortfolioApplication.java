package com.app.myportfolio.infrastructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.app.myportfolio")
@EnableJpaRepositories("com.app.myportfolio.domain.repository")
@EntityScan("com.app.myportfolio.domain.entity")
public class MyPortfolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyPortfolioApplication.class, args);
	}

}
