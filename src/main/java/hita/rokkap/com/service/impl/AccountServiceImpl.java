/**
 * Alipay.com Inc.
 * Copyright (c) 2004‐2019 All Rights Reserved.
 */
package hita.rokkap.com.service.impl;

import hita.rokkap.com.domain.Likes;
import hita.rokkap.com.domain.Match;
import hita.rokkap.com.dto.CustomResponse;
import hita.rokkap.com.mapper.AccountMapper;
import hita.rokkap.com.repository.AccountRepository;
import hita.rokkap.com.repository.LikesRepository;
import hita.rokkap.com.repository.MatchRepository;
import hita.rokkap.com.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.security.Principal;

/**
 * @author angripa.nadapdap
 * @version $Id: AccountServiceImpl.java, v 0.1 2019‐03‐25 23:55 angripa.nadapdap Exp $$
 */
@Service
public class AccountServiceImpl implements AccountService {

    Logger LOG = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    public AccountRepository accountRepository;

    @Autowired
    public MatchRepository matchRepository;

    @Autowired
    public LikesRepository likesRepository;

    @Autowired
    public AccountMapper accountMapper;


    @Override
    public CustomResponse match(Principal principal, Long id) {
        try {
            Match match = new Match();
            match.setAgainst(accountRepository.findByUsernameUsername(principal.getName()));
            match.setOpponent(accountRepository.findOne(id));

            matchRepository.save(match);

            return CustomResponse.buildSuccess();
        } catch (Exception e) {
            LOG.error(e.getMessage());
            return CustomResponse.buildUnexpectedErorr();
        }
    }

    @Override
    public CustomResponse like(Principal principal, Long id) {
        try {
            Likes likes = new Likes();
            likes.setAgainst(accountRepository.findByUsernameUsername(principal.getName()));
            likes.setOpponent(accountRepository.findOne(id));

            likesRepository.save(likes);

            return CustomResponse.buildSuccess();
        } catch (Exception e) {
            LOG.error(e.getMessage());
            return CustomResponse.buildUnexpectedErorr();
        }
    }

    @Override
    public CustomResponse list(Integer page, Integer offset) {
        try {
            return CustomResponse.buildSuccess(accountMapper.convertToDto(accountRepository.findAll(new PageRequest(page, offset))));
        } catch (Exception e) {
            LOG.error(e.getMessage());
            return CustomResponse.buildUnexpectedErorr();
        }
    }
}