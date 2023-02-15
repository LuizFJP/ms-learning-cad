package com.br.learningcad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class LearningCadApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningCadApplication.class, args);
	}

}
