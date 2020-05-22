package com.example.demo.interceptor.service;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Service;

@Service
public class DataSourceInterceptorService {
	public String getControllerName(String uri) {
		ArrayList<String> requestURI = new ArrayList<String>(Arrays.asList(uri.split("/")));
		requestURI.removeIf(item -> {return item.equals("");});
		String reusourceName = requestURI.get(0);
		String[] Arr = reusourceName.split("");
		Arr[0] = Arr[0].toUpperCase();
		String controllerName = String.join("", Arr) + "Controller";
		return controllerName;
	}
}
