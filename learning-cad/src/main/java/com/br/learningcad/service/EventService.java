package com.br.learningcad.service;

import org.springframework.stereotype.Service;

import com.br.learningcad.interfaces.IEventService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.kafka.core.KafkaTemplate;

import lombok.RequiredArgsConstructor;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;
import org.springframework.beans.factory.annotation.Value;

import com.br.learningcad.dto.CreatedStudentEventDTO;

@Service
@RequiredArgsConstructor
public class EventService implements IEventService {
  @Value("${topic.student.created}")
  private String topicName;

  @Override
  public void send(CreatedStudentEventDTO event) {
    Properties props = new Properties();
    props.put("bootstrap.servers", "localhost:9092");
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    props.put("value.serializer", "org.springframework.kafka.support.serializer.JsonSerializer");
    KafkaProducer<String, CreatedStudentEventDTO> kafkaProducer = new KafkaProducer<>(props);

    kafkaProducer.send(new ProducerRecord<String, CreatedStudentEventDTO>(topicName, event));

    kafkaProducer.close();
  }
}

class CustomSerializer implements Serializer<CreatedStudentEventDTO> {
  private final ObjectMapper objectMapper = new ObjectMapper();

  public CustomSerializer(){}
  @Override
  public void configure(Map<String, ?> configs, boolean isKey) {
  }

  @Override
  public byte[] serialize(String topic, CreatedStudentEventDTO data) {
    if (data == null) {
      return null;
  }
    try {
      return objectMapper.writeValueAsBytes(data);
    } catch (Exception e) {
      throw new SerializationException("Error when serializing CreatedStudentEventDto to byte[]");
    }
  }

  @Override
  public void close() {

  }
}
