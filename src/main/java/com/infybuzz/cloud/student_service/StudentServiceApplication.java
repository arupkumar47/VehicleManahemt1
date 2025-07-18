package com.infybuzz.cloud.student_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.infybuzz.cloud.student_service.controller","com.infybuzz.cloud.student_service.config", "com.infybuzz.cloud.student_service.service"})
@EntityScan("com.infybuzz.cloud.student_service.entity")
@EnableJpaRepositories("com.infybuzz.cloud.student_service.repository")

public class StudentServiceApplication{

	public static void main(String[] args) {
		SpringApplication.run(StudentServiceApplication.class, args);
	}

}
