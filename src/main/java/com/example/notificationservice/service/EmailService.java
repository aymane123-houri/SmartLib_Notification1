package com.example.notificationservice.service;

import com.example.notificationservice.entity.Notificaction;
import jakarta.mail.internet.MimeMessage;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(Notificaction notification) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(notification.getUser().getEmail()); // Assure-toi que Notificaction contient l'email de l'utilisateur
            helper.setSubject("Notification de bibliothèque");
            helper.setText(notification.getMessage());
            mailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
