package com.drug.core.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerController {

	private static final Logger LOG = LoggerFactory.getLogger(ExceptionHandlerController.class);

	@ExceptionHandler(CustomException.class)
	@ResponseBody
	public BasicResultBean handleCustomException(CustomException ex) {
		LOG.error("Custom exception handler executed", ex);
		BasicResultBean result = new BasicResultBean();
		result.setMessage(ex.getCustomMessage());
		result.setSuccess(false);
		result.setType("error");
		return result;
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	@ResponseBody
	public BasicResultBean handleException(Exception ex) {
		LOG.error("Generic Exception handler executed", ex);
		BasicResultBean result = new BasicResultBean();
		result.setMessage("Error:Please Try Again");
		result.setSuccess(false);
		result.setType("error");
		return result;
	}
}
