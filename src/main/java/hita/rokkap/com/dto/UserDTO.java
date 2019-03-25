package hita.rokkap.com.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

/**
* @Author  : angripa
* @Date    : Apr 24, 2018
* 
**/
@JsonInclude(Include.NON_NULL)
@Getter
@Setter
public class UserDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull(message=" may not null")
	@NotBlank(message=" may not empty")
	private String username;
	@NotNull(message=" may not null")
	@NotBlank(message=" may not empty")
	private String email;
	@NotNull(message=" may not null")
	@NotBlank(message=" may not empty")
	private String password;
	@NotNull(message=" may not null")
	@NotBlank(message=" may not empty")
	private String address;
}


