package hita.rokkap.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hita.rokkap.com.domain.User;


/**
* @Author  : angripa
* @Date    : Apr 20, 2018
* 
**/

public interface UserRepository extends JpaRepository<User,String>{
	User findByUsername(String username);
}


