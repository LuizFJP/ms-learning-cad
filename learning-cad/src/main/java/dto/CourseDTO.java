package dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class CourseDTO {
  private UUID courseId;
  private String courseName;
  private boolean status;
  private LocalDateTime createdOn;

  public UUID getCourseId() {
    return courseId;
  }

  public String getCourseName() {
    return courseName;
  }

  public boolean isStatus() {
    return status;
  }

  public LocalDateTime getCreatedOn() {
    return createdOn;
  }

}
