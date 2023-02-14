package com.br.learningcad.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.learningcad.data.StudentRepository;
import com.br.learningcad.enitity.StudentEntity;

import dto.StudentDTO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CreateStudentService {
  @Autowired
  StudentRepository studentRepository;

  public UUID create(StudentDTO studentDTO) {
    var studentEntity = new StudentEntity(studentDTO);
    studentRepository.save(studentEntity);
    return studentEntity.getStudentId();
  }
}
