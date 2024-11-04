package com.example.notificationservice.controller;

import com.example.notificationservice.entity.Notificaction;
import com.example.notificationservice.service.KafkaProducerService;
import com.example.notificationservice.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Notifications")
public class NotificationController {

    private final NotificationService notificationService;
    private final KafkaProducerService kafkaProducerService;

    public NotificationController(NotificationService notificationService, KafkaProducerService kafkaProducerService) {
        this.notificationService = notificationService;
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping
    public Notificaction createNotification(@RequestBody Notificaction notificaction){
        return notificationService.createNotification(notificaction);
    }

    @PutMapping("/{id}")
    public Notificaction updateNotification(@PathVariable String id ,@RequestBody Notificaction notificaction){
        notificaction.set_id(id);
        return notificationService.updateNotification(notificaction);
    }

    @GetMapping("/{id}")
    public Notificaction getById(@PathVariable String id){
        return notificationService.getById(id);
    }

    @GetMapping
    public List<Notificaction> getAll(){
        return notificationService.getAll();
    }

    @DeleteMapping("/{id}")
    public void deleteNotification(@PathVariable String id){
        notificationService.deleteNotification(id);
    }

    @PostMapping("/send-notification")
    public ResponseEntity<String> sendNotification(@RequestBody Notificaction notification) {
        kafkaProducerService.sendNotification(notification);
        return ResponseEntity.ok("Notification envoyée avec succès !");
    }


}
