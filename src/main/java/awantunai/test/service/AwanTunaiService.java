package awantunai.test.service;

import awantunai.test.dto.CustomResponse;
import awantunai.test.dto.transaction.TransactionDTO;
import awantunai.test.dto.transfer.TransferDTO;

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


