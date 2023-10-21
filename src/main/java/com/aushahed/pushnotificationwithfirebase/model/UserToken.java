package com.aushahed.pushnotificationwithfirebase.model;

import lombok.Data;

@Data
public class UserToken {
    private Long userId;
    private String token;
}
