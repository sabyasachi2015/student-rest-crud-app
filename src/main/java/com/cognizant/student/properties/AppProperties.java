package com.cognizant.student.properties;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix ="student")
@EnableConfigurationProperties
@Data
public class AppProperties {
	
	private Map<String,String> properties=new HashMap<>();

}
