package com.practice.organization_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(OrganizationNotFoundException.class)
    public ResponseEntity<String> organizationNotFound(OrganizationNotFoundException ex, WebRequest webRequest){
        return new ResponseEntity<>("Organization Not Found" , HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> organizationNotAvailable(Exception e, WebRequest webRequest){
        return new ResponseEntity<>("This is not organization", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
