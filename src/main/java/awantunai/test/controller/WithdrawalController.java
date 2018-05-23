package awantunai.test.controller;

import java.security.Principal;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import awantunai.test.dto.transaction.TransactionCDTO;
import awantunai.test.dto.transaction.TransactionDTO;
import awantunai.test.enums.TransactionType;
import awantunai.test.service.AwanTunaiService;

/**
* @Author  : angripa
* @Date    : May 23, 2018
* 
**/
@RestController
public class WithdrawalController extends BaseController{
	@Qualifier("Withdrawal")
	@Autowired
	private AwanTunaiService awanTunaiService;
	
	@PostMapping("/withdraw")
	public Object signUp(Principal principal,@RequestBody TransactionCDTO cdto,BindingResult bindingResult) {
		validate(bindingResult);
		TransactionDTO dto = new TransactionDTO();
		BeanUtils.copyProperties(cdto, dto);
		dto.setUsername(principal.getName());
		dto.setType(TransactionType.WITHDRAW.name());
		return awanTunaiService.withdrawal(dto);
	}
}


