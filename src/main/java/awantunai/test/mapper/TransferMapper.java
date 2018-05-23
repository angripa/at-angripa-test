package awantunai.test.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import awantunai.test.domain.Transfer;
import awantunai.test.dto.transfer.TransferDTO;

/**
* @Author  : angripa
* @Date    : May 23, 2018
* 
**/
@Component
public class TransferMapper implements EntityToDTOMapper<Transfer, TransferDTO>{
	@Autowired
	ModelMapper mapper;
	@Override
	public Transfer createEntity(TransferDTO dto) {
		return mapper.map(dto, Transfer.class);
	}

	@Override
	public Transfer updateEntity(TransferDTO dto) {
		return mapper.map(dto, Transfer.class);
	}

	@Override
	public TransferDTO convertToDto(Transfer entity) {
		return mapper.map(entity, TransferDTO.class);
	}

	@Override
	public List<TransferDTO> convertToDto(Iterable<Transfer> entities) {
		List<TransferDTO> list = new ArrayList<>();
		for (Transfer transfer : entities) {
			list.add(convertToDto(transfer));
		}
		
		return list;
	}

	@Override
	public Transfer convertToEntity(TransferDTO dto) {
		return mapper.map(dto, Transfer.class);
	}

	@Override
	public List<Transfer> convertToEntity(Iterable<TransferDTO> dtos) {
		List<Transfer> list = new ArrayList<>();
		for (TransferDTO transfer : dtos) {
			list.add(convertToEntity(transfer));
		}
		
		return list;
	}

}


