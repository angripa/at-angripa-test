package awantunai.test.dto.transfer;

import awantunai.test.domain.Account;
import lombok.Getter;
import lombok.Setter;

/**
* @Author  : angripa
* @Date    : May 23, 2018
* 
**/
@Getter
@Setter
public class TransferDTO extends TransferCDTO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6128931013272926109L;
	private String username;
	private Account sender;
	private Account recipient;
}


