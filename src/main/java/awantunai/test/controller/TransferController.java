package awantunai.test.controller;

import java.security.Principal;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import awantunai.test.dto.transfer.TransferCDTO;
import awantunai.test.dto.transfer.TransferDTO;
import awantunai.test.service.AwanTunaiService;

/**
* @Author  : angripa
* @Date    : May 23, 2018
* 
**/
@RestController
public class TransferController extends BaseController{
	@Qualifier("Transfer")
	@Autowired
	private AwanTunaiService awanTunaiService;
	
	@PostMapping("/transfer")
	public Object signUp(Principal principal,@RequestBody TransferCDTO cdto,BindingResult bindingResult) {
		validate(bindingResult);
		TransferDTO dto = new TransferDTO();
		BeanUtils.copyProperties(cdto, dto);
		dto.setUsername(principal.getName());
		return awanTunaiService.transfer(dto);
	}
}


