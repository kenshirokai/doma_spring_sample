package com.example.demo.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties("my.datasource.abstract")
@Data
public class DataSourceBase {
	private String driverClassName;
}
