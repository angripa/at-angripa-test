/**
 * Alipay.com Inc.
 * Copyright (c) 2004‐2019 All Rights Reserved.
 */
package hita.rokkap.com.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author angripa.nadapdap
 * @version $Id: RegisterDTO.java, v 0.1 2019‐03‐26 01:50 angripa.nadapdap Exp $$
 */
@Getter
@Setter
public class RegisterDTO implements Serializable {
    @NotNull(message = " may not null")
    @NotBlank(message = " may not empty")
    private String username;
    @NotNull(message = " may not null")
    @NotBlank(message = " may not empty")
    private String email;
    @NotNull(message = " may not null")
    @NotBlank(message = " may not empty")
    private String password;
    private String address;
    private UserDTO user;
    private String bio;
    private Integer age;
    private Integer distance;
    private String name;
    private String interest;
    private String fullname;
    private String profileImageUrl;
}