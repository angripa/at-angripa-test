package hita.rokkap.com.dto.transfer;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

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
public class TransferCDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7712496629577997998L;
	@NotNull(message=" may not null")	
	@Digits(fraction = 2, integer = 12, message = "invalid amount")
	private BigDecimal amount;
	@NotNull(message=" may not null")
	@NotBlank(message=" may not blank")
	private String acRecipient;
}


