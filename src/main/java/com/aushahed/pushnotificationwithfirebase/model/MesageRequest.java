package com.aushahed.pushnotificationwithfirebase.model;

import lombok.Data;

@Data
public class MesageRequest {

    private String title;
    private String messgae;
    private Long userId;
}
