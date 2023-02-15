package com.br.learningcad.dto;

import java.time.LocalDate;
import java.util.UUID;

public class StudentDTO {
  private String firstName;
  private String lastName;
  private String document;
  private LocalDate birthdate;
  @com.br.learningcad.validator.UUID
  private UUID courseId;

  public StudentDTO() {
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getDocument() {
    return document;
  }

  public LocalDate getBirthdate() {
    return birthdate;
  }

  public UUID getCourseId() {
    return courseId;
  }

}
