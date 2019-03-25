package hita.rokkap.com.service.impl;

import java.math.BigDecimal;

import hita.rokkap.com.repository.AccountBalanceRepository;
import hita.rokkap.com.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hita.rokkap.com.domain.Account;
import hita.rokkap.com.domain.AccountBalance;
import hita.rokkap.com.dto.CustomResponse;
import hita.rokkap.com.dto.transaction.TransactionDTO;
import hita.rokkap.com.dto.transfer.TransferDTO;
import hita.rokkap.com.service.AwanTunaiService;

/**
* @Author  : angripa
* @Date    : May 23, 2018
* 
**/
@Service("Deposit")
public class Deposit extends InitTransaction implements AwanTunaiService{
	@Autowired
    AccountRepository accountRepository;
	@Autowired
    AccountBalanceRepository accountBalanceRepository;
	@Override
	public CustomResponse withdrawal(TransactionDTO dto) {
		return null;
	}

	@Override
	public CustomResponse topup(TransactionDTO dto) {
		try {
			Account account = accountRepository.findByUsernameUsername(dto.getUsername());
			if (null == account) {
				return CustomResponse.buildNotFound();
			}
			AccountBalance ab= accountBalanceRepository.findByAccountUsernameUsername(dto.getUsername());
			if(null == ab){
				ab=new AccountBalance();
				ab.setAccount(account);
				ab.setBalance(BigDecimal.ZERO);				
			}			
			ab.setBalance(ab.getBalance().add(dto.getAmount()));
			//update account balance
			accountBalanceRepository.save(ab);
			
			//create transactions log
			initTransactions(dto);
			return CustomResponse.buildSuccess();
		} catch (Exception e) {
			e.printStackTrace();
			return CustomResponse.buildUnexpectedErorr();
		}
	}

	@Override
	public CustomResponse transfer(TransferDTO dto) {
		return null;
	}
	

}


