package awantunai.test.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import awantunai.test.domain.User;
import awantunai.test.dto.UserDTO;

/**
 * @Author : angripa
 * @Date : Apr 4, 2018
 * 
 **/
@Component
public class UserMapper implements EntityToDTOMapper<User, UserDTO> {
	@Autowired
	ModelMapper mapper;

	@Override
	public User createEntity(UserDTO dto) {
		// TODO Auto-generated method stub
		return mapper.map(dto, User.class);
	}

	@Override
	public User updateEntity(UserDTO dto) {
		// TODO Auto-generated method stub
		return createEntity(dto);
	}

	@Override
	public UserDTO convertToDto(User entity) {
		// TODO Auto-generated method stub
		return mapper.map(entity, UserDTO.class);
	}

	@Override
	public List<UserDTO> convertToDto(Iterable<User> entities) {
		// TODO Auto-generated method stub
		List<UserDTO> ls = new ArrayList<>();
		for (User User : entities) {
			ls.add(convertToDto(User));
		}

		return ls;
	}

	@Override
	public User convertToEntity(UserDTO dto) {
		// TODO Auto-generated method stub
		return mapper.map(dto, User.class);
	}

	@Override
	public List<User> convertToEntity(Iterable<UserDTO> dtos) {
		// TODO Auto-generated method stub
		List<User> ls = new ArrayList<>();
		for (UserDTO User : dtos) {
			ls.add(convertToEntity(User));
		}

		return ls;
	}

}
