package com.example.crud.designpattern.factorydesign;

public class FacebookNotification implements Notification {
    @Override
    public void send(String recipient, String message) {
        System.out.printf("Facebook notification to %s: %s%n", recipient, message);
    }
}