package com.br.learningcad.dto;

import java.util.UUID;
import java.io.Serializable;
import org.apache.kafka.common.serialization.Serializer;

import com.br.learningcad.enitity.StudentEntity;

public class CreatedStudentEventDTO implements Serializable, Serializer {
  private UUID studentId;
  private String fullName;
  private UUID courseId;

  public CreatedStudentEventDTO(StudentEntity studentEntity) {
    studentId = studentEntity.getStudentId();
    fullName = studentEntity.getFirstName() + " " + studentEntity.getLastName();
    courseId = studentEntity.getCourseId();
  }

  public UUID getStudentId() {
    return studentId;
  }

  public void setStudentId(UUID studentId) {
    this.studentId = studentId;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public UUID getCourseId() {
    return courseId;
  }

  public void setCourseId(UUID courseId) {
    this.courseId = courseId;
  }

  @Override
  public byte[] serialize(String topic, Object data) {
    return new byte[0];
  }

}
