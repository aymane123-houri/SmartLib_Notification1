package com.example.notificationservice.service;

import com.example.notificationservice.entity.Notificaction;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private final KafkaTemplate<String, Notificaction> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, Notificaction> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendNotification(Notificaction notification) {
        kafkaTemplate.send("notification_topic", notification);
    }
}
