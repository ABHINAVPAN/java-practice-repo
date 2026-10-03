package com.example.crud.designpattern.factorydesign;

public class SmsNotification implements Notification {
    @Override
    public void send(String recipient, String message) {
        System.out.printf("SMS to %s: %s%n", recipient, message);
    }
}