package com.project1.david;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

//@SpringBootApplication(exclude =  {DataSourceAutoConfiguration.class })

@SpringBootApplication
@ComponentScan("com.project1.david")
@EntityScan(basePackages = "com.project1.david")
@EnableJpaRepositories(basePackages = {"com.project1.david"})
@Component
public class DavidApplication {

	public static void main(String[] args) {
		SpringApplication.run(DavidApplication.class, args);
	}

}
