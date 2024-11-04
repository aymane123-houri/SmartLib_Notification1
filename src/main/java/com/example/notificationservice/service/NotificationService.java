package com.example.notificationservice.service;

import com.example.notificationservice.entity.Notificaction;
import com.example.notificationservice.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    private  NotificationRepository notificationRepository;


    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public Notificaction createNotification(Notificaction notificaction){
        return notificationRepository.save(notificaction);
    }

    public Notificaction updateNotification(Notificaction notificaction){
        return notificationRepository.save(notificaction);
    }

    public Notificaction getById(String id){
        return notificationRepository.findById(id).orElse(null);
    }

    public List<Notificaction> getAll(){
        return notificationRepository.findAll();
    }

    public void deleteNotification(String id){
         notificationRepository.deleteById(id);
    }



}
