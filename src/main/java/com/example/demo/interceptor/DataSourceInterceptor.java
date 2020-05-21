package com.example.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.example.demo.config.SchemaContextHolder;
import com.example.demo.config.SchemaType;


public class DataSourceInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(
			HttpServletRequest request,
			HttpServletResponse response,
			Object object
			) throws Exception {
		
		String datasource = request.getHeader("datasource");
		if(datasource.equals("ds1")) {
			SchemaContextHolder.setSchemaType(SchemaType.DATA1);
		}else {
			SchemaContextHolder.setSchemaType(SchemaType.DATA2);
		}
		System.out.print(datasource);
		return true;
	}
}
