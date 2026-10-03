package com.example.crud.designpattern.strategydesign;

public class SmsNotificationStrategy implements NotificationStrategy {
    @Override
    public void send(String recipient, String message) {
        System.out.printf("SMS to %s: %s%n", recipient, message);
    }
}