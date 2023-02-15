package com.br.learningcad.interfaces;

import com.br.learningcad.dto.CreatedStudentEventDTO;

public interface IEventService {
  public void send(CreatedStudentEventDTO event);
}
