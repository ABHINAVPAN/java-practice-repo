package com.example.crud.designpattern.strategydesign;

public class NotificationStrategyDemo {
    public static void main(String[] args) {
        NotificationContext notifier = new NotificationContext(new SmsNotificationStrategy());
        notifier.send("+1-555-0100", "Your order has shipped.");

        notifier.setStrategy(new EmailNotificationStrategy());
        notifier.send("customer@example.com", "Your order has shipped.");

        notifier.setStrategy(new FacebookNotificationStrategy());
        notifier.send("customer123", "Your order has shipped.");
    }
}