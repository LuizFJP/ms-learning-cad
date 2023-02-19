package com.br.learningcad.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.learningcad.service.CreateStudentService;

import lombok.AllArgsConstructor;

import com.br.learningcad.dto.StudentDTO;
import com.br.learningcad.interfaces.IEventService;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class CreateStudentController {

  @Autowired
  CreateStudentService createStudentService;

  private final IEventService eventService;

  @PostMapping(value="/student")
  public ResponseEntity<UUID> postMethodName(@Valid @RequestBody StudentDTO studentDTO) {
      var studentEntity = createStudentService.create(studentDTO);
      eventService.send(studentEntity);
      return new ResponseEntity<UUID>(studentEntity.getStudentId(), HttpStatus.CREATED);
  }
  
}
