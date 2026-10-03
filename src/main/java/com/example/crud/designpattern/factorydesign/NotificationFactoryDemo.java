package com.example.crud.designpattern.factorydesign;

public class NotificationFactoryDemo {
    public static void main(String[] args) {
        send(NotificationType.SMS, "+1-555-0100", "Your order has shipped.");
        send(NotificationType.EMAIL, "customer@example.com", "Your order has shipped.");
        send(NotificationType.FACEBOOK, "customer123", "Your order has shipped.");
    }

    private static void send(NotificationType type, String recipient, String message) {
        Notification notification = NotificationFactory.create(type);
        notification.send(recipient, message);
    }
}