package com.ps.cc.application.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ps.cc.application.dto.ApplicationConstants;
import com.ps.cc.application.dto.CustomErrorResponse;

@ControllerAdvice
public class CreditCardAppExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value = InvalidCardException.class)
	public ResponseEntity<Object> handleGenericNotFoundException(InvalidCardException ex) {
		CustomErrorResponse error = new CustomErrorResponse();
		error.setErrorMsg(ApplicationConstants.NOT_VALID_CARD_MSG);
		error.setErrorCode(ApplicationConstants.NOT_VALID_CARD_CODE);
		return ResponseEntity.ok(error);
	}
	
	@ExceptionHandler(value = NotFoundException.class)
	public ResponseEntity<Object> handleGenericNotFoundException(NotFoundException ex) {
		CustomErrorResponse error = new CustomErrorResponse();
		error.setErrorMsg(ApplicationConstants.NO_LIST_RETRIEVED_MSG);
		error.setErrorCode(ApplicationConstants.NO_LIST_RETRIEVED_CODE);
		return ResponseEntity.ok(error);
	}
}
