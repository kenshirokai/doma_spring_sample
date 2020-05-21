package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.interceptor.DataSourceInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
	@Autowired
	DataSourceInterceptor dsInterceptor;
	@Override
	public void addInterceptors(InterceptorRegistry resistory) {
		resistory.addInterceptor(dsInterceptor);
	}
}
