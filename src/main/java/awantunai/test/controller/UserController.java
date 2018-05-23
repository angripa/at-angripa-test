package awantunai.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import awantunai.test.domain.Account;
import awantunai.test.domain.User;
import awantunai.test.dto.CustomResponse;
import awantunai.test.dto.UserDTO;
import awantunai.test.enums.ServiceStatus;
import awantunai.test.mapper.UserMapper;
import awantunai.test.repository.AccountRepository;
import awantunai.test.repository.UserRepository;

/**
 * @Author : angripa
 * @Date : Apr 25, 2018
 * 
 **/

@RestController
@RequestMapping("/user")
public class UserController extends BaseController{
	Logger LOG = LoggerFactory.getLogger(UserController.class);
	
	private UserRepository userRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;	
	private UserMapper userMapper;
	private AccountRepository accountRepository;
		
	@Autowired
	public UserController(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder,UserMapper userMapper,AccountRepository accountRepository) {
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.userMapper=userMapper;
		this.accountRepository=accountRepository;
	}

	@PostMapping("/register")
	public Object signUp(@RequestBody UserDTO userDTO,BindingResult bindingResult) {
		LOG.debug("Incoming request for sign-up");
		validate(bindingResult);
		try {
			if (null != userRepository.findByUsername(userDTO.getUsername())) {
				return CustomResponse.build(ServiceStatus.USER_EXIST);
			}
			User user = userMapper.convertToEntity(userDTO);
			user.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
			user.setEnabled(true);
			user.setAccountNonLocked(true);
			user.setAccountNonExpired(true);
			user.setCredentialsNonExpired(true);
			userRepository.save(user);
			Account acc = new Account();
			acc.setUsername(user);
			acc.setAddress(userDTO.getAddress());
			acc.setEmail(userDTO.getEmail());
			accountRepository.save(acc);
			return CustomResponse.buildSuccess();
		} catch (Exception e) {
			e.printStackTrace();
			return CustomResponse.buildUnexpectedErorr();
		}

	}
}
