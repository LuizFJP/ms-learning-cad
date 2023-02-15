package com.br.learningcad.service;

import org.springframework.stereotype.Service;

import com.br.learningcad.interfaces.IEventService;
import com.br.learningcad.dto.CreatedStudentEventDTO;

@Service
public class EventService implements IEventService {
  @Override
  public void send(CreatedStudentEventDTO createdStudentEventDTO) {}
}
