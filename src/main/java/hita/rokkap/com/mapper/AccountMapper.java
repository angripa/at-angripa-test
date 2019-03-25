/**
 * Alipay.com Inc.
 * Copyright (c) 2004‐2019 All Rights Reserved.
 */
package hita.rokkap.com.mapper;

import hita.rokkap.com.domain.Account;
import hita.rokkap.com.domain.User;
import hita.rokkap.com.dto.AccountDTO;
import hita.rokkap.com.dto.AccountDTO;
import hita.rokkap.com.dto.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author angripa.nadapdap
 * @version $Id: AccountMapper.java, v 0.1 2019‐03‐26 01:22 angripa.nadapdap Exp $$
 */
@Component
public class AccountMapper implements EntityToDTOMapper<Account, AccountDTO> {

    @Autowired
    ModelMapper mapper;

    @Override
    public Account createEntity(AccountDTO AccountDTO) {
        return null;
    }

    @Override
    public Account updateEntity(AccountDTO AccountDTO) {
        return null;
    }

    @Override
    public AccountDTO convertToDto(Account account) {
        return mapper.map(account, AccountDTO.class);
    }

    @Override
    public List<AccountDTO> convertToDto(Iterable<Account> accounts) {
        List<AccountDTO> ls = new ArrayList<>();
        for (Account account : accounts) {
            AccountDTO accountDTO = convertToDto(account);
            accountDTO.setUser(null);
            accountDTO.setUserId(account.getUsername().getUsername());
            ls.add(accountDTO);
        }

        return ls;
    }

    @Override
    public Account convertToEntity(AccountDTO AccountDTO) {
        return null;
    }

    @Override
    public List<Account> convertToEntity(Iterable<AccountDTO> AccountDTOS) {
        return null;
    }
}