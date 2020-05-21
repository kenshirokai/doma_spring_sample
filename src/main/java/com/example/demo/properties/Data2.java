package com.example.demo.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@ConfigurationProperties("datasource.data2")
@Component
public class Data2 {
	private String url;
	private String username;
	private String password;
}
