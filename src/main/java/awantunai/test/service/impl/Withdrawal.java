package awantunai.test.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import awantunai.test.domain.Account;
import awantunai.test.domain.AccountBalance;
import awantunai.test.dto.CustomResponse;
import awantunai.test.dto.transaction.TransactionDTO;
import awantunai.test.dto.transfer.TransferDTO;
import awantunai.test.enums.ServiceStatus;
import awantunai.test.repository.AccountBalanceRepository;
import awantunai.test.repository.AccountRepository;
import awantunai.test.service.AwanTunaiService;

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
