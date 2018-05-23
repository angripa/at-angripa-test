package awantunai.test.service.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;

import awantunai.test.domain.Transfer;
import awantunai.test.dto.transfer.TransferDTO;
import awantunai.test.enums.TransactionType;
import awantunai.test.mapper.TransferMapper;
import awantunai.test.repository.TransferRepository;

/**
 * @Author : angripa
 * @Date : May 23, 2018
 * 
 **/
public class InitTransfer {
	@Autowired
	TransferMapper transferMapper;
	@Autowired
	TransferRepository transferRepository;

	public void createTransfer(TransferDTO dto) {
		Transfer tIn = transferMapper.convertToEntity(dto);
		Transfer tOut = tIn;
		tOut.setType(TransactionType.CREDIT.name());
		tIn.setType(TransactionType.DEBIT.name());
		transferRepository.save(Arrays.asList(tOut, tIn));
	}
}
