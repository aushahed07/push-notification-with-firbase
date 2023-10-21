package com.aushahed.pushnotificationwithfirebase.impl;

import com.aushahed.pushnotificationwithfirebase.model.MesageRequest;
import com.aushahed.pushnotificationwithfirebase.model.PushNotificationRequest;
import com.aushahed.pushnotificationwithfirebase.repository.UserRepository;
import com.aushahed.pushnotificationwithfirebase.schema.User;
import com.aushahed.pushnotificationwithfirebase.service.FCMService;
import com.aushahed.pushnotificationwithfirebase.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImplementation implements MessageService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FCMService fcmService;

    @Override
    public String sendMessageToUser(MesageRequest mesageRequest) {
        String response = "Failed to send notification";
        User user = userRepository.getByUserId(mesageRequest.getUserId()).orElse(null);
        if(user == null){
            return "Wrong user information.";
        }
        try {
            PushNotificationRequest pushNotificationRequest = new PushNotificationRequest();
            pushNotificationRequest.setTitle(mesageRequest.getTitle());
            pushNotificationRequest.setMessage(mesageRequest.getMessgae());
            pushNotificationRequest.setToken(user.getAppToken());
            fcmService.sendNotification(pushNotificationRequest);
            response = "Notification sent";
        } catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public String sendMessageToUserWithPriorityHigh(MesageRequest mesageRequest) {
        String response = "Failed to send notification";
        User user = userRepository.getByUserId(mesageRequest.getUserId()).orElse(null);
        if(user == null){
            return "Wrong user information.";
        }
        try {
            PushNotificationRequest pushNotificationRequest = new PushNotificationRequest();
            pushNotificationRequest.setTitle(mesageRequest.getTitle());
            pushNotificationRequest.setMessage(mesageRequest.getMessgae());
            pushNotificationRequest.setToken(user.getAppToken());
            fcmService.sendMessageToUserWithPriorityHigh(pushNotificationRequest);
            response = "Notification sent";
        } catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }
}
