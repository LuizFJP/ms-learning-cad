package dto;

import java.time.LocalDate;

import com.br.learningcad.enitity.StudentEntity;

public class GetStudentDTO {
  private String fullName;
  private String document;
  private LocalDate birthDate;
  private String courseName;
  private boolean status;

  public GetStudentDTO(StudentEntity studentEntity, CourseDTO courseDTO) {
    fullName = studentEntity.getFirstName() + " " + studentEntity.getLastName();
    document = studentEntity.getDocument();
    birthDate = studentEntity.getBirthdate();
    courseName = courseDTO.getCourseName();
    status = studentEntity.isStatus();
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getDocument() {
    return document;
  }

  public void setDocument(String document) {
    this.document = document;
  }

  public LocalDate getBirthdate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

}
