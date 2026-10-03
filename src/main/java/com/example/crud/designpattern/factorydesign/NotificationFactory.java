package com.example.crud.designpattern.factorydesign;

public final class NotificationFactory {
    private NotificationFactory() {
    }

    public static Notification create(NotificationType type) {
        return switch (type) {
            case SMS -> new SmsNotification();
            case EMAIL -> new EmailNotification();
            case FACEBOOK -> new FacebookNotification();
        };
    }
}