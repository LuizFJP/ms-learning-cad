package com.br.learningcad.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.br.learningcad.exception.CourseNotFoundException;

@ControllerAdvice
public class ValidationHandler extends ResponseEntityExceptionHandler {
  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
      HttpHeaders headers, HttpStatus status, WebRequest request) {

    Map<String, String> body = new HashMap<>();
    ex.getBindingResult().getAllErrors().forEach((error) -> {

      String fieldName = ((FieldError) error).getField();
      String message = error.getDefaultMessage();
      body.put(fieldName, message);
    });
    return new ResponseEntity<Object>(body, HttpStatus.BAD_REQUEST);
  }
  
  @ExceptionHandler(CourseNotFoundException.class)
  public ResponseEntity<Object> handlecourseNotFoundException(
      CourseNotFoundException ex, WebRequest request) {

    Map<String, Object> body = new HashMap<>();
    body.put("message", ex.getMessage());

    return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
  }
}
