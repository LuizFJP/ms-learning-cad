package com.br.learningcad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.learningcad.data.StudentRepository;
import com.br.learningcad.utils.Course;

import java.util.UUID;

import com.br.learningcad.dto.GetStudentDTO;

@Service
public class GetStudentService {
  @Autowired
  StudentRepository studentRepository;
  public GetStudentDTO getStudent(String studentId) {
    UUID studentUUID = UUID.fromString(studentId); 
    var studentEntity = studentRepository.findStudentById(studentUUID);
    var courseDTO = Course.fetchCourse(studentEntity.getCourseId());
    return new GetStudentDTO(studentEntity, courseDTO);
  }
}