package awantunai.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import awantunai.test.domain.Account;
import awantunai.test.domain.Transactions;
import awantunai.test.dto.transaction.TransactionDTO;
import awantunai.test.dto.transfer.TransferDTO;
import awantunai.test.mapper.TransactionMapper;
import awantunai.test.repository.AccountRepository;
import awantunai.test.repository.TransactionsRepository;

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


