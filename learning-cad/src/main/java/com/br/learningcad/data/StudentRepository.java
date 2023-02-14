package com.br.learningcad.data;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.br.learningcad.enitity.StudentEntity;

public class StudentRepository {
  public interface CourseRepository extends MongoRepository<StudentEntity, UUID> {
  }
}
