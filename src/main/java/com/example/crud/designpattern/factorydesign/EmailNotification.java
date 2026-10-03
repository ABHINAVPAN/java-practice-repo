package com.example.crud.designpattern.factorydesign;

public class EmailNotification implements Notification {
    @Override
    public void send(String recipient, String message) {
        System.out.printf("Email to %s: %s%n", recipient, message);
    }
}