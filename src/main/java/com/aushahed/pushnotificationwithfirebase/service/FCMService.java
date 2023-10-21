package com.aushahed.pushnotificationwithfirebase.service;

import com.aushahed.pushnotificationwithfirebase.model.PushNotificationRequest;
import com.google.firebase.messaging.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FCMService {

    @Autowired
    private FirebaseMessaging firebaseMessaging;

    public String sendNotification(PushNotificationRequest notificationRequest) throws FirebaseMessagingException {

        Notification notification = Notification.builder()
                .setTitle(notificationRequest.getTitle())
                .setBody(notificationRequest.getMessage())
                .build();

        Message message = Message.builder()
                .setToken(notificationRequest.getToken())
                .setTopic(notificationRequest.getTopic())
                .setNotification(notification)
                .build();

        return firebaseMessaging.send(message);
    }


    public String sendMessageToUserWithPriorityHigh(PushNotificationRequest notificationRequest) throws FirebaseMessagingException {

        Notification notification = Notification.builder()
                .setTitle(notificationRequest.getTitle())
                .setBody(notificationRequest.getMessage())
                .build();

        AndroidConfig androidConfig = AndroidConfig.builder()
                .setPriority(AndroidConfig.Priority.HIGH).build();

        Message message = Message.builder()
                .setToken(notificationRequest.getToken())
                .setNotification(notification)
                .setTopic(notificationRequest.getTopic())
                .setAndroidConfig(androidConfig)
                .build();

        return firebaseMessaging.send(message);
    }
}
