package com.br.learningcad.data;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.br.learningcad.enitity.StudentEntity;


  public interface StudentRepository extends MongoRepository<StudentEntity, UUID> {
  }

