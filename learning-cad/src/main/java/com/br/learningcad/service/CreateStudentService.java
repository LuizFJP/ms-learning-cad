package com.br.learningcad.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.br.learningcad.data.StudentRepository;
import com.br.learningcad.enitity.StudentEntity;
import com.br.learningcad.exception.CourseNotFoundException;

import dto.*;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CreateStudentService {
  @Autowired
  StudentRepository studentRepository;

  public UUID create(StudentDTO studentDTO) {
    var courseDTO = fetchCourse(studentDTO.getCourseId());
    checkCourseExists(courseDTO);
    var studentEntity = new StudentEntity(studentDTO);
    studentRepository.save(studentEntity);
    return studentEntity.getStudentId();
  }

  private CourseDTO fetchCourse(UUID courseId) {
    String uri = "http://localhost:8081/api/v1/courses/?courseId=" + courseId;
    RestTemplate restTemplate = new RestTemplate();
    CourseDTO[] response = restTemplate.getForObject(uri, CourseDTO[].class);
    if (response == null)
      return null;
    else
      return response[0];
  }

  private void checkCourseExists(CourseDTO courseDTO) {
    if (courseDTO == null)
      throw new CourseNotFoundException();
  }

}
