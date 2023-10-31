package com.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.Model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User getUserByUserName(String userName);


	
	
}
