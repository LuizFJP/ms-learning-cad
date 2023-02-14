package com.br.learningcad.enitity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import dto.StudentDTO;

@Document("students")
public class StudentEntity {
  @Id
  private String id;
  private UUID studentId;
  private String firstName;
  private String lastName;
  private String document;
  private LocalDate birthDate;
  private UUID courseId;
  private boolean status;
  private LocalDateTime createdOn;

  public StudentEntity(StudentDTO studentDTO) {
    studentId = UUID.randomUUID();
    firstName = studentDTO.getFirstName();
    lastName = studentDTO.getLastName();
    document = studentDTO.getDocument();
    birthDate = studentDTO.getBirthDate();
    courseId = studentDTO.getCourseId();
    status = true;
    createdOn = LocalDateTime.of(LocalDate.now(), LocalTime.now());
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public UUID getStudentId() {
    return studentId;
  }

  public void setStudentId(UUID studentId) {
    this.studentId = studentId;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getDocument() {
    return document;
  }

  public void setDocument(String document) {
    this.document = document;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public UUID getCourseId() {
    return courseId;
  }

  public void setCourseId(UUID courseId) {
    this.courseId = courseId;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public LocalDateTime getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(LocalDateTime createdOn) {
    this.createdOn = createdOn;
  }

}
