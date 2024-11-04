package com.example.notificationservice.repository;

import com.example.notificationservice.entity.Notificaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository<Notificaction,String> {

}
