package com.cognizant.student.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket myInfo() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("public-api")
				.apiInfo(apiInfo()).select()	
		        .apis(RequestHandlerSelectors.basePackage("com.cognizant.student.controller"))
		        .paths(PathSelectors.any())		
		        .build();		
	}

	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("User Rest API")
				.description("Neosoft API Reference for Developers")
				.termsOfServiceUrl("https://www.neosofttech.com")
				//.contact(new Contact()).license("Neosoft License")
				//.contact("sabyasachi.rajkumar@neosoftmail.com").license("Neosoft Tech License")
				.licenseUrl("sabyasachi.rajkumar@neosoftmail.com")
				.version("1.0")
				.build();
	}
}