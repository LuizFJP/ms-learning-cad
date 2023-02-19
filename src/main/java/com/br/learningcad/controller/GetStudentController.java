package com.br.learningcad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.br.learningcad.service.GetStudentService;

import com.br.learningcad.dto.GetStudentDTO;

@RestController
@RequestMapping("/api/v1")
public class GetStudentController {
  @Autowired
  GetStudentService getStudentService;

  @GetMapping("/student/{studentId}")
  public ResponseEntity<GetStudentDTO> getStudent(@PathVariable("studentId") String studentId) {
    return new ResponseEntity<GetStudentDTO>(getStudentService.getStudent(studentId), HttpStatus.OK);
  }

}
