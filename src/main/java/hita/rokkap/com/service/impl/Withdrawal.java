package hita.rokkap.com.service.impl;

import java.math.BigDecimal;

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
@Service("Withdrawal")
public class Withdrawal extends InitTransaction implements AwanTunaiService {
	@Autowired
    AccountRepository accountRepository;

	@Autowired
    AccountBalanceRepository accountBalanceRepository;
	@Override
	public CustomResponse withdrawal(TransactionDTO dto) {
		try {
			Account account = accountRepository.findByUsernameUsername(dto.getUsername());
			if (null == account) {
				CustomResponse.buildNotFound();
			}
			AccountBalance ab= accountBalanceRepository.findByAccountUsernameUsername(dto.getUsername());
			if(null == ab){
				ab=new AccountBalance();
				ab.setAccount(account);
				ab.setBalance(BigDecimal.ZERO);
			}
			if (ab.getBalance().compareTo(dto.getAmount()) < 0)
				return CustomResponse.build(ServiceStatus.WITHDRAWAL_EXCEED_BALANCE);

			ab.setBalance(ab.getBalance().subtract(dto.getAmount()));
			accountBalanceRepository.save(ab);
			return CustomResponse.buildSuccess();
		} catch (Exception e) {
			return CustomResponse.buildUnexpectedErorr();
		}
	}

	@Override
	public CustomResponse topup(TransactionDTO dto) {
		return null;
	}

	@Override
	public CustomResponse transfer(TransferDTO dto) {
		return null;
	}

}
