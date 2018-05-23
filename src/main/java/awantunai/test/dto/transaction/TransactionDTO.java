package awantunai.test.dto.transaction;

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
public class TransactionDTO extends TransactionCDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4431317963022988056L;

	private String username;
	private String type;
}


