package com.example.demo.config;

import java.sql.Driver;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Component;

import com.example.demo.interceptor.DataSourceInterceptor;
import com.example.demo.properties.Data1;
import com.example.demo.properties.Data2;
import com.example.demo.properties.DataSourceBase;

@Component
@Configuration
public class DataSourceConfig {
	
	@Autowired
	private DataSourceBase base;
	@Autowired
	private Data1 data1;
	@Autowired
	private Data2 data2;
	//@Bean
	public DataSource datasource1() throws ClassNotFoundException {
		SimpleDriverDataSource ds = new SimpleDriverDataSource();
		ds.setDriverClass((Class<? extends Driver>) Class.forName(this.base.getDriverClassName()));
		ds.setUrl(this.data1.getUrl());
		ds.setUsername(this.data1.getUsername());
		ds.setPassword(this.data1.getPassword());
		return ds;
	}
	
	//@Bean
	public DataSource datasource2() throws ClassNotFoundException {
		SimpleDriverDataSource ds = new SimpleDriverDataSource();
		ds.setDriverClass((Class<? extends Driver>)Class.forName(this.base.getDriverClassName()));
		ds.setUrl(this.data2.getUrl());
		ds.setUsername(this.data2.getUsername());
		ds.setPassword(this.data2.getPassword());
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
	
	@Bean
	public DataSourceInterceptor dataSourceInterceptor() throws Exception {
		return new DataSourceInterceptor();
	}
	
}
