package awantunai.test.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import awantunai.test.dto.ResponseWrapper;
import awantunai.test.enums.ServiceStatus;
import awantunai.test.exception.FieldValidationException;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
/**
* @Author  : angripa
* @Date    : Mar 5, 2018
* 
**/
@Data
public abstract class BaseController {

	@Setter(value = AccessLevel.PRIVATE)
	@Getter(value = AccessLevel.PRIVATE)
	private ResponseEntity<Object> response = null;

	public ResponseEntity<Object> buildResponseGeneralSuccess() {
		return buildResponseGeneralSuccess(null);
	}
	
	public ResponseEntity<Object> buildResponseGeneralSuccess(Object data) {
		setResponse(new ResponseEntity<Object>(ResponseWrapper.build(data, ServiceStatus.SUCCESS), HttpStatus.OK));
		return this.response;
	}
	
	public ResponseEntity<Object> buildResponse(Object data, ServiceStatus status, HttpStatus httpStatus) {
		setResponse(new ResponseEntity<Object>(ResponseWrapper.build(data, status), httpStatus));
		return this.response;
	}

	public ResponseEntity<Object> buildResponse(Object data, String code, String message, HttpStatus httpStatus) {
		setResponse(new ResponseEntity<Object>(ResponseWrapper.build(data, code, message), httpStatus));
		return this.response;
	}

	public void validate(BindingResult bindingResult) throws FieldValidationException {
		if (bindingResult.hasErrors()) {
			FieldError fieldError = bindingResult.getFieldError();
			throw new FieldValidationException(fieldError.getField() + " " + fieldError.getDefaultMessage());
		}
	}
	
	@ExceptionHandler(InvalidFormatException.class)
	public ResponseEntity<Object> errorHandler() {
		setResponse(
				new ResponseEntity<Object>(ResponseWrapper.build(null, ServiceStatus.INVALID_FORMAT), HttpStatus.OK));
		return this.response;
	  }

}
