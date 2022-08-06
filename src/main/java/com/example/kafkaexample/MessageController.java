package com.example.kafkaexample;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/messages")
@AllArgsConstructor
public class MessageController {

  private KafkaTemplate<String, Message> kafkaTemplate;

  @PostMapping
  public void publish(@RequestBody MessageRequest request){
  Message message = new Message();
  message.setMessage(request.getMessage());
  message.setCreatedAt(LocalDateTime.now());
   kafkaTemplate.send("szau", message);
  }

}
