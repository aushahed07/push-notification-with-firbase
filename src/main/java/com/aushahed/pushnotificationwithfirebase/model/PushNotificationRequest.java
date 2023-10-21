package com.aushahed.pushnotificationwithfirebase.model;

import lombok.Data;

@Data
public class PushNotificationRequest {
    private String title;
    private String message;
    private String token;
    private String topic;
}
