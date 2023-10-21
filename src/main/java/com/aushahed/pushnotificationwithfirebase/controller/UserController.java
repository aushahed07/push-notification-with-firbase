package com.aushahed.pushnotificationwithfirebase.controller;

import com.aushahed.pushnotificationwithfirebase.model.UserModel;
import com.aushahed.pushnotificationwithfirebase.model.UserToken;
import com.aushahed.pushnotificationwithfirebase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserModel> getUserById(@PathVariable Long id) {
        UserModel userModel = userService.getUserModelById(id);

        if(userModel == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(userModel);
    }

    @PostMapping()
    public ResponseEntity<Long> createUser(@RequestBody UserModel userModel) {

        Long userId = userService.saveOrUpdateUserModel(userModel);

        if(userId == null){
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().body(userId);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Long> updateUser(@RequestBody UserModel userModel, @PathVariable Long id) {
        userModel.setUserId(id);
        Long userId = userService.saveOrUpdateUserModel(userModel);

        if(userId == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.accepted().body(userId);
    }

    @PatchMapping("app-token")
    public ResponseEntity<Long> saveAppToken(@RequestBody UserToken userToken) {
        Long userId = userService.saveAppToken(userToken);

        if(userId == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.accepted().body(userId);
    }
}
