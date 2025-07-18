package com.infybuzz.cloud.student_service.config;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration
public class StudentConfig {
@Value("${address.service.url}")	
private String addres_url;
	
@Bean
public WebClient webclient() {
	WebClient webClient = WebClient.builder().baseUrl(addres_url).build();
	return webClient;
}
}


