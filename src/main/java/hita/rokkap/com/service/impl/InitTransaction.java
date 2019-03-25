package hita.rokkap.com.service.impl;

import hita.rokkap.com.repository.AccountRepository;
import hita.rokkap.com.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import hita.rokkap.com.domain.Account;
import hita.rokkap.com.domain.Transactions;
import hita.rokkap.com.dto.transaction.TransactionDTO;
import hita.rokkap.com.dto.transfer.TransferDTO;
import hita.rokkap.com.mapper.TransactionMapper;

/**
* @Author  : angripa
* @Date    : May 23, 2018
* 
**/
public class InitTransaction {
	@Autowired
    TransactionsRepository transactionsRepository;
	@Autowired
	TransactionMapper mapper;
	@Autowired
    AccountRepository accountRepository;
	public void initTransactions(TransactionDTO dto){
		Account acc = accountRepository.findByUsernameUsername(dto.getUsername());
		Transactions t = mapper.convertToEntity(dto);
		t.setAccount(acc);
		transactionsRepository.save(t);	
	}
	public void initTransfer(TransferDTO dto){
//		Account acc = accountRepository.findByUsernameUsername(dto.getUsername());
//		Transactions t = mapper.convertToEntity(dto);
//		t.setAccount(acc);
//		transactionsRepository.save(t);	
	}
}


