/**
 * Alipay.com Inc.
 * Copyright (c) 2004‐2019 All Rights Reserved.
 */
package hita.rokkap.com.controller;

import hita.rokkap.com.dto.CustomResponse;
import hita.rokkap.com.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author angripa.nadapdap
 * @version $Id: AccountController.java, v 0.1 2019‐03‐25 23:52 angripa.nadapdap Exp $$
 */
@RestController
@RequestMapping(path="/account")
public class AccountController extends BaseController {
    @Autowired
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/match/{id}")
    public CustomResponse match(@PathVariable(name = "id") Long id, Principal principal) {
        return accountService.match(principal, id);
    }

    @PostMapping("/like/{id}")
    public CustomResponse like(@PathVariable(name = "id") Long id, Principal principal) {
        return accountService.like(principal, id);
    }
    @PostMapping("/list/{page}/{offset}")
    public CustomResponse like(Principal principal,@PathVariable(name = "page") Integer page,@PathVariable(name = "offset") Integer offset) {
        return accountService.list(page,offset);
    }
}