package com.olx.advertise.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdvertiseExceptionController {
	@ExceptionHandler(value = AdvertiseNotFoundException.class)
	   public ResponseEntity<Object> exception(AdvertiseNotFoundException exception) {
	      return new ResponseEntity<>("Advertise not found", HttpStatus.NOT_FOUND);
	   }
}
