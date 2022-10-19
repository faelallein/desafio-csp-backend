package com.backend.desafio.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHelper
{
	@ExceptionHandler(value = { ExceptionValidator.class })
	public ResponseEntity<Object> handleInvalidInputException(ExceptionValidator exception)
	{
		return new ResponseEntity<Object>(exception.getError(), exception.getHttpStatus());
	}
}
