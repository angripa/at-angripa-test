package hita.rokkap.com.exception;

import hita.rokkap.com.serializer.AppAuthExceptionSerializer;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

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
