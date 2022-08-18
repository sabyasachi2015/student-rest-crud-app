package com.cognizant.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.cognizant.student.auditor.AuditorAwareImpl;

import springfox.documentation.swagger2.mappers.ModelMapper;

@SpringBootApplication
//@EnableJpaRepositories
@EnableDiscoveryClient
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class StudentsRegistrationServiceApplication {
	
	@Bean
	public AuditorAware<String>auditorAware(){
		return new AuditorAwareImpl(); 		
	}
	

	public static void main(String[] args) {
		SpringApplication.run(StudentsRegistrationServiceApplication.class, args);
	}

}
