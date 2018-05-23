package awantunai.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import awantunai.test.domain.Transactions;

/**
* @Author  : angripa
* @Date    : May 23, 2018
* 
**/
public interface TransactionsRepository extends JpaRepository<Transactions, Long>{

}


