package com.example.demo.config;

import java.sql.Driver;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class DataSourceConfig {
	
	//@Bean
	public DataSource datasource1() throws ClassNotFoundException {
		SimpleDriverDataSource ds = new SimpleDriverDataSource();
		ds.setDriverClass((Class<? extends Driver>) Class.forName("org.postgresql.Driver"));
		ds.setUrl("jdbc:postgresql://localhost:15432/postgres");
		ds.setUsername("postgres");
		ds.setPassword("secret");
		return ds;
	}
	
	//@Bean
	public DataSource datasource2() throws ClassNotFoundException {
		SimpleDriverDataSource ds = new SimpleDriverDataSource();
		ds.setDriverClass((Class<? extends Driver>)Class.forName("org.postgresql.Driver"));
		ds.setUrl("jdbc:postgresql://localhost:15433/postgres");
		ds.setUsername("postgres");
		ds.setPassword("secret");
		return ds;
	}
	
	@Bean
	public DynamicRoutingDataSourceResolver datasource() throws ClassNotFoundException {
		DynamicRoutingDataSourceResolver resolver = new DynamicRoutingDataSourceResolver();
		
		Map<Object, Object>datasource = new HashMap<Object, Object>();
		datasource.put("datasource1", datasource1());
		datasource.put("datasource2", datasource2());
		
		resolver.setTargetDataSources(datasource);
		
		resolver.setDefaultTargetDataSource(datasource2());
		
		return resolver;
	}
	
	
}
