package com.br.learningcad.exception;

public class CourseNotFoundException extends RuntimeException {
  public CourseNotFoundException() {
    super("Course not found.");
  }
}
