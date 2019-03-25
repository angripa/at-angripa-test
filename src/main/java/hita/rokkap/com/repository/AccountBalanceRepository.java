package hita.rokkap.com.repository;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.QueryHints;

import hita.rokkap.com.domain.AccountBalance;

/**
* @Author  : angripa
* @Date    : May 23, 2018
* 
**/
public interface AccountBalanceRepository extends JpaRepository<AccountBalance, Long>{
	@Transactional
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value ="40000")})
	public AccountBalance findByAccountUsernameUsername(String username);
}


