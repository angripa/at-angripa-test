/**
 * Alipay.com Inc.
 * Copyright (c) 2004‐2019 All Rights Reserved.
 */
package hita.rokkap.com.service;

import hita.rokkap.com.dto.CustomResponse;
import org.springframework.stereotype.Service;

import java.security.Principal;

/**
 * @author angripa.nadapdap
 * @version $Id: AccountService.java, v 0.1 2019‐03‐25 23:54 angripa.nadapdap Exp $$
 */
@Service
public interface AccountService {

    public CustomResponse match(Principal principal, Long id);

    public CustomResponse like(Principal principal, Long id);

    public CustomResponse list(Integer page, Integer offset);

}