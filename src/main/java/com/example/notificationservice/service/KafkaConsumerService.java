package com.example.notificationservice.service;

import com.example.notificationservice.entity.Notificaction;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private final EmailService emailService;

    public KafkaConsumerService(EmailService emailService) {
        this.emailService = emailService;
    }

    @KafkaListener(topics = "notification_topic", groupId = "notification-group")
    public void consumeNotification(Notificaction notification) {
        emailService.sendEmail(notification);
    }
}