package com.example.crud.designpattern.strategydesign;

public interface NotificationStrategy {
    void send(String recipient, String message);
}