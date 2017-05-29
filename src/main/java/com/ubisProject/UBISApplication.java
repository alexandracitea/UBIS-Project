package com.ubisProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ubisProject"})
@EnableJpaRepositories(basePackages = "com.ubisProject.repositories")
@EnableSwagger2
@EntityScan(basePackages ={ "com.ubisProject"})
@EnableAutoConfiguration
public class UBISApplication {

	public static void main(String[] args) {

		SpringApplication.run(UBISApplication.class, args);
	}
}
