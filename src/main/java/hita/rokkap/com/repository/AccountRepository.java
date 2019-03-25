package hita.rokkap.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hita.rokkap.com.domain.Account;

/**
* @Author  : angripa
* @Date    : May 23, 2018
* 
**/
public interface AccountRepository extends JpaRepository<Account, Long>{	
	public Account findByUsernameUsername(String username);

}


