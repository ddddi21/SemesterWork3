package ru.itis.demo.services.interfaces;

public interface EmailSenderServiceInterface {
    void sendMessage(String subject, String email, String html);
}
