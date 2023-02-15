package com.br.learningcad.interfaces;

import org.springframework.stereotype.Component;

import com.br.learningcad.dto.CreatedStudentEventDTO;

@Component
public interface IEventService {
  public void send(CreatedStudentEventDTO event);
}
