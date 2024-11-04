package com.example.notificationservice.entity;

import com.example.notificationservice.modele.User;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Document(collection = "notifications")
public class Notificaction {
    @Id
    private String _id;
    private String userId;
    private String type; // peut être "rappel" ou "disponibilité"
    private String message;
    private String dateEnvoi;
    private String status; // "non_lue", "envoyée", "lue"
    private String bookId;
    @Transient
    private User user;

}
