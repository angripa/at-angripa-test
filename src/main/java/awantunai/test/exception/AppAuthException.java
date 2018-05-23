package awantunai.test.exception;

import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import awantunai.test.serializer.AppAuthExceptionSerializer;

@JsonSerialize(using = AppAuthExceptionSerializer.class)
public class AppAuthException extends OAuth2Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6968484965784804465L;
	
	public AppAuthException(String msg) {
		super(msg);
	}

}
