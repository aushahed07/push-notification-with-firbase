package com.aushahed.pushnotificationwithfirebase.impl;

import com.aushahed.pushnotificationwithfirebase.mapper.UserMapper;
import com.aushahed.pushnotificationwithfirebase.model.UserModel;
import com.aushahed.pushnotificationwithfirebase.model.UserToken;
import com.aushahed.pushnotificationwithfirebase.repository.UserRepository;
import com.aushahed.pushnotificationwithfirebase.schema.User;
import com.aushahed.pushnotificationwithfirebase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserModel getUserModelById(Long userId) {

        User user = userRepository.getByUserId(userId).orElse(null);
        if (!ObjectUtils.isEmpty(user)) {
            return UserMapper.entityToModel(user);
        } else {
            return null;
        }
    }

    @Override
    public Long saveOrUpdateUserModel(UserModel userModel) {

        Long userId = null;
        if (ObjectUtils.isEmpty(userModel.getUserId()) || userRepository.existsById(userModel.getUserId())) {
            User user = UserMapper.modelToEntity(userModel);
            try {
                user = userRepository.save(user);
                userId = user.getUserId();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return userId;
    }

    @Override
    public Long saveAppToken(UserToken userToken) {

        User user = userRepository.getByUserId(userToken.getUserId()).orElse(null);
        if(user != null){
            user.setAppToken(userToken.getToken());
            user = userRepository.save(user);
            return user.getUserId();
        }
        return null;
    }
}
