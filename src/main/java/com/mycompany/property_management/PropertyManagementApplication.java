package com.mycompany.property_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication
@EnableJpaRepositories
@EntityScan
public class PropertyManagementApplication {

	public static void main(String[] args) {

		SpringApplication.run(PropertyManagementApplication.class, args);
	}

}
