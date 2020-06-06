package com.uspartan.assessmenttask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages= {"com"})
@EnableJpaRepositories("com.uspartan.assessmenttask.repository")
@EntityScan("com.uspartan.assessmenttask.entity")
public class AssessmentTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssessmentTaskApplication.class, args);
	}

}
