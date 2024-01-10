package com.project2.indirizzo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication


@ComponentScan("com.project2.indirizzo")
@EntityScan(basePackages = "com.project2.indirizzo")
@EnableJpaRepositories(basePackages = {"com.project2.indirizzo"})
public class IndirizzoApplication {

	public static void main(String[] args) {
		SpringApplication.run(IndirizzoApplication.class, args);
	}

}
