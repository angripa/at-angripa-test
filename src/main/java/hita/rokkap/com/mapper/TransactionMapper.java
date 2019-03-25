package hita.rokkap.com.mapper;

import java.util.ArrayList;
import java.util.List;

import hita.rokkap.com.domain.Transactions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hita.rokkap.com.dto.transaction.TransactionDTO;

/**
* @Author  : angripa
* @Date    : May 23, 2018
* 
**/
@Component
public class TransactionMapper implements EntityToDTOMapper<Transactions, TransactionDTO>{
	@Autowired
	ModelMapper mapper;
	@Override
	public Transactions createEntity(TransactionDTO dto) {
		// TODO Auto-generated method stub
		return mapper.map(dto, Transactions.class);
	}

	@Override
	public Transactions updateEntity(TransactionDTO dto) {
		// TODO Auto-generated method stub
		return mapper.map(dto, Transactions.class);
	}

	@Override
	public TransactionDTO convertToDto(Transactions entity) {
		// TODO Auto-generated method stub
		return mapper.map(entity, TransactionDTO.class);
	}

	@Override
	public List<TransactionDTO> convertToDto(Iterable<Transactions> entities) {
		ArrayList<TransactionDTO> result = new ArrayList<>();
		for (Transactions transactions : entities) {
			result.add(convertToDto(transactions));
		}
		
		return result;
	}

	@Override
	public Transactions convertToEntity(TransactionDTO dto) {		 
		return mapper.map(dto, Transactions.class);
	}

	@Override
	public List<Transactions> convertToEntity(Iterable<TransactionDTO> dtos) {
		ArrayList<Transactions> result = new ArrayList<>();
		for (TransactionDTO dto  : dtos) {
			result.add(convertToEntity(dto));
		}
		
		return result;
	}

}


