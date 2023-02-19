package com.br.learningcad.data;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.br.learningcad.enitity.StudentEntity;

public interface StudentRepository extends MongoRepository<StudentEntity, UUID> {
  @Query(value = "{'studentId': ?0}")
  StudentEntity findStudentById(UUID id);
}
