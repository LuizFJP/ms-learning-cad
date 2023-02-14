package com.br.learningcad.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.learningcad.service.CreateStudentService;

import dto.StudentDTO;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1")
public class CreateStudentController {

  @Autowired
  CreateStudentService createStudentService;
  @PostMapping(value="/student")
  public ResponseEntity<UUID> postMethodName(@RequestBody StudentDTO studentDTO) {
      UUID studentId = createStudentService.create(studentDTO);
      
      return new ResponseEntity<UUID>(studentId, HttpStatus.CREATED);
  }
  
}
