package com.example.crud.designpattern.strategydesign;

public class FacebookNotificationStrategy implements NotificationStrategy {
    @Override
    public void send(String recipient, String message) {
        System.out.printf("Facebook notification to %s: %s%n", recipient, message);
    }
}