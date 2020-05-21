package com.example.demo.repository;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import com.example.demo.domain.model.User;


@ConfigAutowireable
@Dao
public interface UserRepository {
	@Select
	List<User> selectAll();
}
