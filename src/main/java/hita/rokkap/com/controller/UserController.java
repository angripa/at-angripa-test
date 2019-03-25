package hita.rokkap.com.controller;

import hita.rokkap.com.dto.RegisterDTO;
import hita.rokkap.com.repository.AccountRepository;
import hita.rokkap.com.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hita.rokkap.com.domain.Account;
import hita.rokkap.com.domain.User;
import hita.rokkap.com.dto.CustomResponse;
import hita.rokkap.com.dto.UserDTO;
import hita.rokkap.com.enums.ServiceStatus;
import hita.rokkap.com.mapper.UserMapper;

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
	public Object signUp(@RequestBody RegisterDTO registerDTO) {
		LOG.debug("Incoming request for sign-up");
		try {
			if (null != userRepository.findByUsername(registerDTO.getUsername())) {
				return CustomResponse.build(ServiceStatus.USER_EXIST);
			}
			User user = new User();
			user.setUsername(registerDTO.getUsername());
			user.setPassword(bCryptPasswordEncoder.encode(registerDTO.getPassword()));
			user.setEnabled(true);
			user.setAccountNonLocked(true);
			user.setAccountNonExpired(true);
			user.setCredentialsNonExpired(true);
			userRepository.save(user);
			//save account
			Account acc = new Account();
			BeanUtils.copyProperties(registerDTO,acc);
			acc.setUsername(user);
			accountRepository.save(acc);

			return CustomResponse.buildSuccess();
		} catch (Exception e) {
			e.printStackTrace();
			return CustomResponse.buildUnexpectedErorr();
		}

	}
}
