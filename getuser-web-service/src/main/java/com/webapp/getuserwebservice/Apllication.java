package com.webapp.getuserwebservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.webapp.getuserwebservice.repository.UtentiRepository;

@SpringBootApplication
@ComponentScan("com.webapp.getuserwebservice")
@EnableMongoRepositories(basePackageClasses = UtentiRepository.class)
  
public class Apllication {

	public static void main(String[] args) {
		SpringApplication.run(Apllication.class, args);
	}

}
