package com.aushahed.pushnotificationwithfirebase.service;

import com.aushahed.pushnotificationwithfirebase.model.UserModel;
import com.aushahed.pushnotificationwithfirebase.model.UserToken;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UserModel getUserModelById(Long userId);

    Long saveOrUpdateUserModel(UserModel userModel);

    Long saveAppToken(UserToken userToken);
}
