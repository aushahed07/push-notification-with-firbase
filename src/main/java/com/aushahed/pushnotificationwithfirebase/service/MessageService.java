package com.aushahed.pushnotificationwithfirebase.service;

import com.aushahed.pushnotificationwithfirebase.model.MesageRequest;
import org.springframework.stereotype.Service;

@Service
public interface MessageService {

    String sendMessageToUser(MesageRequest mesageRequest);

    String sendMessageToUserWithPriorityHigh(MesageRequest mesageRequest);
}
