package com.br.learningcad.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.br.learningcad.data.StudentRepository;
import com.br.learningcad.utils.Course;

import java.util.UUID;

import dto.GetStudentDTO;

public class GetStudentService {
  @Autowired
  StudentRepository studentRepository;
  public GetStudentDTO getStudent(UUID studentId) {
    var studentEntity = studentRepository.findStudentById(studentId);
    var courseDTO = Course.fetchCourse(studentEntity.getCourseId());
    return new GetStudentDTO(studentEntity, courseDTO);
  }
}