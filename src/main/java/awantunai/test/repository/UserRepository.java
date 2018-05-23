package awantunai.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import awantunai.test.domain.User;


/**
* @Author  : angripa
* @Date    : Apr 20, 2018
* 
**/

public interface UserRepository extends JpaRepository<User,String>{
	User findByUsername(String username);
}


