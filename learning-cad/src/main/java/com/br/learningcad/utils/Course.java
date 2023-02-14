package com.br.learningcad.utils;

import org.springframework.web.client.RestTemplate;

import com.br.learningcad.exception.CourseNotFoundException;
import java.util.UUID;

import dto.CourseDTO;

public abstract class Course {
  public static CourseDTO fetchCourse(UUID courseId) {
    String uri = "http://localhost:8081/api/v1/courses/?courseId=" + courseId;
    RestTemplate restTemplate = new RestTemplate();
    CourseDTO[] response = restTemplate.getForObject(uri, CourseDTO[].class);
    if (response == null)
      return null;
    else
      return response[0];
  }

  public static void checkCourseExists(CourseDTO courseDTO) {
    if (courseDTO == null)
      throw new CourseNotFoundException();
  }
}
