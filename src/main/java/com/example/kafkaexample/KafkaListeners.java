package com.example.kafkaexample;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

  @KafkaListener(topics="szau", groupId = "groupId", containerFactory = "messageFactory")
  void listener(Message data){
    System.out.println("Listener received: " + data + " !!!");
  }


}
