package hita.rokkap.com.service.impl;

import java.util.Arrays;

import hita.rokkap.com.repository.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;

import hita.rokkap.com.domain.Transfer;
import hita.rokkap.com.dto.transfer.TransferDTO;
import hita.rokkap.com.enums.TransactionType;
import hita.rokkap.com.mapper.TransferMapper;

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
