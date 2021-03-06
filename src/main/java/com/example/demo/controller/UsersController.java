package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.DBConn;
import com.example.demo.config.SchemaType;
import com.example.demo.domain.model.User;
import com.example.demo.service.UserService;

@DBConn(SchemaType.DATA2)
@RestController
@RequestMapping(value = "users")
public class UsersController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET )
	public Map<String, List<User>> Index() {
		List<User> users = this.userService.getUsers();
		Map<String, List<User>> result = new HashMap();
		result.put("users", users);
		return result;
	}
}
