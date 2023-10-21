package com.aushahed.pushnotificationwithfirebase.controller;

import com.aushahed.pushnotificationwithfirebase.model.MesageRequest;
import com.aushahed.pushnotificationwithfirebase.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping()
    public String sendMessageToUser(@RequestBody MesageRequest mesageRequest){
        return messageService.sendMessageToUser(mesageRequest);
    }

    @PostMapping("priority-high")
    public String sendMessageToUserWithHighPriority(@RequestBody MesageRequest mesageRequest){
        return messageService.sendMessageToUserWithPriorityHigh(mesageRequest);
    }
}
