package com.example.demo.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties("datasource.data1")
public class Data1 {
	private String url;
	private String username;
	private String password;
}
