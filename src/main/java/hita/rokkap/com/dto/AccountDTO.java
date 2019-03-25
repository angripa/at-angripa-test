/**
 * Alipay.com Inc.
 * Copyright (c) 2004‐2019 All Rights Reserved.
 */
package hita.rokkap.com.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

/**
 * @author angripa.nadapdap
 * @version $Id: AccountDTO.java, v 0.1 2019‐03‐26 01:25 angripa.nadapdap Exp $$
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountDTO extends AuditableDTO {

    private String address;
    private String email;
    private UserDTO user;
    private String userId;
    private String bio;
    private String interest;
    private Integer age;
    private Integer distance;
    private String name;
    private String fullname;
    private String profileImageUrl;

}