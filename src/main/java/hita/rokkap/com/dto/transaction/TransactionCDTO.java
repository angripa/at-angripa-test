package hita.rokkap.com.dto.transaction;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

/**
* @Author  : angripa
* @Date    : May 23, 2018
* 
**/
@JsonInclude(Include.NON_NULL)
@Getter
@Setter
public class TransactionCDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2121392420223735075L;
	@NotNull(message=" may not null")	
	@Digits(fraction = 2, integer = 12, message = "invalid amount")
	private BigDecimal amount;
}


