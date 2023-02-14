package com.br.learningcad.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.learningcad.data.StudentRepository;
import com.br.learningcad.domain.Student;
import com.br.learningcad.mappers.StudentToStudentEntity;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CreateStudentService {
  @Autowired
  StudentRepository studentRepository;
  private final StudentToStudentEntity studentToStudentEntity;
  

  public UUID save(Student student) {
    var studentEntity = studentToStudentEntity.mapper(student);

  }
}
