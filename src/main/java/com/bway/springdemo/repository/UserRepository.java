package com.bway.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bway.springdemo.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUserNameAndPassword(String un,String psw);
	
	//@Query(value="select * from user where user_name=:un and password=:psw", nativeQuery = true)
	//User userLogin(@Param("un")String username, @Param("psw")String password);
}
