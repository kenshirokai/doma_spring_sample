package com.example.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import com.example.demo.config.DBConn;
import com.example.demo.config.SchemaContextHolder;
import com.example.demo.config.SchemaType;
import com.example.demo.interceptor.service.DataSourceInterceptorService;


public class DataSourceInterceptor implements HandlerInterceptor {
	
	@Autowired
	private DataSourceInterceptorService servie;
	
	@Override
	public boolean preHandle(
			HttpServletRequest request,
			HttpServletResponse response,
			Object object
			) throws Exception {
		String controllerName = this.servie.getControllerName(request.getRequestURI());
		Class<?> controllerClass = Class.forName("com.example.demo.controller." + controllerName);
		DBConn dbConn = controllerClass.getAnnotation(DBConn.class);
		SchemaContextHolder.setSchemaType(dbConn.value());
//		System.out.print(controllerName);
//		try {
//			String datasource = request.getHeader("datasource");
//			if(datasource.equals("ds1")) {
//				SchemaContextHolder.setSchemaType(SchemaType.DATA1);
//			}else {
//				SchemaContextHolder.setSchemaType(SchemaType.DATA2);
//			}
//			System.out.print(datasource);
//		} catch (NullPointerException e) {
//			
//		} finally {
//			SchemaContextHolder.setSchemaType(SchemaType.DATA1);
//		}
//		
		return true;
	}
}
