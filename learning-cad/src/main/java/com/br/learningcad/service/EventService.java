package com.br.learningcad.service;

import org.springframework.stereotype.Service;

import com.br.learningcad.interfaces.IEventService;
import org.springframework.kafka.core.KafkaTemplate;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import com.br.learningcad.dto.CreatedStudentEventDTO;

@Service
@RequiredArgsConstructor
public class EventService implements IEventService {
  @Value("${topic.student.created}")
  private String topicName;

  private final KafkaTemplate<String, CreatedStudentEventDTO> kafkaTemplate;

  @Override
  public void send(CreatedStudentEventDTO createdStudentEventDTO) {
    kafkaTemplate.send(topicName, createdStudentEventDTO);
  }
}
