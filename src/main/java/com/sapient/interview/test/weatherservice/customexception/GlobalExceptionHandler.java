package com.sapient.interview.test.weatherservice.customexception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(ServiceException.class)
	public String handleSQLException(ServiceException ex) {
		logger.info("ServiceException" + ex.getLocalizedMessage());
		return ex.getLocalizedMessage();
	}
}