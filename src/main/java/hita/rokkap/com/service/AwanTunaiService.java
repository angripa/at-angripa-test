package hita.rokkap.com.service;

import hita.rokkap.com.dto.CustomResponse;
import hita.rokkap.com.dto.transaction.TransactionDTO;
import hita.rokkap.com.dto.transfer.TransferDTO;

/**
* @Author  : angripa
* @Date    : May 23, 2018
* 
**/
public interface AwanTunaiService {
	public CustomResponse withdrawal(TransactionDTO dto);
	
	public CustomResponse topup(TransactionDTO dto);
	
	public CustomResponse transfer(TransferDTO dto);
}


