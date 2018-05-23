package awantunai.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import awantunai.test.domain.Account;

/**
* @Author  : angripa
* @Date    : May 23, 2018
* 
**/
public interface AccountRepository extends JpaRepository<Account, Long>{	
	public Account findByUsernameUsername(String username);
}


