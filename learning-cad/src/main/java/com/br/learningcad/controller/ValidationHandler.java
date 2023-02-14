package com.br.learningcad.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.br.learningcad.exception.CourseNotFoundException;

public class ValidationHandler extends ResponseEntityExceptionHandler {
  @ExceptionHandler(CourseNotFoundException.class)
  public ResponseEntity<Object> handlecourseNotFoundException(
      CourseNotFoundException ex, WebRequest request) {

    Map<String, Object> body = new HashMap<>();
    body.put("message", ex.getMessage());

    return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
  }
}
