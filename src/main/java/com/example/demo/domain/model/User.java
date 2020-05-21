package com.example.demo.domain.model;

import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {
	
	@Id
	private Integer id;
	private String name;
	private String email;
}
