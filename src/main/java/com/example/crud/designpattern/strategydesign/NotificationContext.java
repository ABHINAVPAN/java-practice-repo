package com.example.crud.designpattern.strategydesign;

import java.util.Objects;

public class NotificationContext {
    private NotificationStrategy strategy;

    public NotificationContext(NotificationStrategy strategy) {
        setStrategy(strategy);
    }

    public void setStrategy(NotificationStrategy strategy) {
        this.strategy = Objects.requireNonNull(strategy, "strategy must not be null");
    }

    public void send(String recipient, String message) {
        strategy.send(recipient, message);
    }
}