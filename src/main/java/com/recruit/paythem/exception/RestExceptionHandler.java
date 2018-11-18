package com.recruit.paythem.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.recruit.paythem.dto.ResponseDto;
import com.recruit.paythem.enums.ResponseMessage;

/**
 * 
 * @author Hasitha Maduranga
 *
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		ResponseDto errorResponse = new ResponseDto.Builder()
				.withMessage(ResponseMessage.BAD_REQUEST.getCode())
				.withMessage(ResponseMessage.BAD_REQUEST.getMessage())
				.build();
		
		return new ResponseEntity<Object>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EntityNotFoundException.class)
	protected ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex) {
		ResponseDto errorResponse = new ResponseDto.Builder()
				.withMessageCode(ResponseMessage.ENTITY_NOT_FOUND.getCode())
				.withMessage(ResponseMessage.ENTITY_NOT_FOUND.getMessage())
				.build();
		
		if (ex.getFieldName() != null) {
			errorResponse.setResponse(ex.getFieldName() + ":" + ex.getResourceId());
		} else {
			errorResponse.setResponse(ex.getMessage());
		}

		return new ResponseEntity<Object>(errorResponse, HttpStatus.NOT_FOUND);

	}

}
