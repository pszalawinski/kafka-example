package com.example.kafkaexample;

import java.time.LocalDateTime;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaApplication {

  public static void main(String[] args) {
    SpringApplication.run(KafkaApplication.class, args);
  }

    @Bean
    CommandLineRunner commandLineRunner(
     KafkaTemplate<String ,Message> kafkaTemplate){
    return args -> kafkaTemplate.send("szau", new Message("hello", LocalDateTime.now()));
  }

}
