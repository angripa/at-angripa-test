package hita.rokkap.com.service.impl;

import java.math.BigDecimal;
import java.util.Arrays;

import hita.rokkap.com.repository.AccountBalanceRepository;
import hita.rokkap.com.repository.AccountRepository;
import hita.rokkap.com.service.AwanTunaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hita.rokkap.com.domain.Account;
import hita.rokkap.com.domain.AccountBalance;
import hita.rokkap.com.dto.CustomResponse;
import hita.rokkap.com.dto.transaction.TransactionDTO;
import hita.rokkap.com.dto.transfer.TransferDTO;
import hita.rokkap.com.enums.ServiceStatus;

/**
 * @Author : angripa
 * @Date : May 23, 2018
 * 
 **/
@Service("Transfer")
public class Transfer extends InitTransfer implements AwanTunaiService {
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
		return null;
	}

	@Override
	public CustomResponse transfer(TransferDTO dto) {
		try {
			Account sender = accountRepository.findByUsernameUsername(dto.getUsername());
			if(null == sender){
				return CustomResponse.build(ServiceStatus.ACCOUNT_NOT_FOUND);
			}
			Account recipient = accountRepository.findByUsernameUsername(dto.getAcRecipient());
			if(null == recipient){
				return CustomResponse.build(ServiceStatus.ACCOUNT_NOT_FOUND);
			}
			AccountBalance abSender= accountBalanceRepository.findByAccountUsernameUsername(dto.getUsername());
			if(null == abSender){
				return CustomResponse.build(ServiceStatus.NOT_FOUND);
			}
			AccountBalance abRecipient= accountBalanceRepository.findByAccountUsernameUsername(dto.getAcRecipient());
			if(null == abRecipient){
				abRecipient = new AccountBalance();
				abRecipient.setAccount(recipient);
				abRecipient.setBalance(BigDecimal.ZERO);
			}
			if(abSender.getBalance().compareTo(dto.getAmount())<0)
				return CustomResponse.build(ServiceStatus.INSUFFICIENT_BALANCE);
			//update balance
			abSender.setBalance(abSender.getBalance().subtract(dto.getAmount()));
			abRecipient.setBalance(abRecipient.getBalance().add(dto.getAmount()));
			accountBalanceRepository.save(Arrays.asList(abSender,abRecipient));
			//create history transfer
			dto.setRecipient(recipient);
			dto.setSender(sender);			
			createTransfer(dto);
			return CustomResponse.buildSuccess();
		} catch (Exception e) {
			e.printStackTrace();
			return CustomResponse.buildUnexpectedErorr();
		}
	}

}
