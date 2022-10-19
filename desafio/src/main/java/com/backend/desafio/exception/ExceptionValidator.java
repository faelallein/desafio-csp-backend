package com.backend.desafio.exception;

import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
public class ExceptionValidator extends RuntimeException
{
	private String error;
	private HttpStatus httpStatus;
	
	public ExceptionValidator()
	{
		
	}
	
	public ExceptionValidator(String error)
	{
		this.error = error;
		
		switch(error) {
			case "invalid_name":
			case "invalid_cpf":
				this.httpStatus = HttpStatus.BAD_REQUEST;
				break;
			case "missing":
				this.httpStatus = HttpStatus.NOT_FOUND;
		}
	}

	public String getError()
	{
		return error;
	}

	public HttpStatus getHttpStatus()
	{
		return httpStatus;
	}
}
