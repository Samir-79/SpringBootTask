package com.example.springboottask.controller;

import com.example.springboottask.entity.UserInfo;
import com.example.springboottask.service.UserInfoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userinfo/api/users")
public class UserController {

    public final UserInfoService userInfoService;

    public UserController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    // get all users
    @GetMapping
    public ResponseEntity<Iterable<UserInfo>> getAllUsers() {

        Iterable<UserInfo> allUsers = userInfoService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    // get user by id
    @GetMapping("getById/{id}")
    public ResponseEntity<UserInfo> getUserById(@PathVariable(value = "id") long userId) {
        UserInfo foundUser = userInfoService.findUserById(userId);
        return new ResponseEntity<>(foundUser, HttpStatus.OK);

    }

    @GetMapping("getByPerNum/{persNum}")
    public ResponseEntity<UserInfo> getUserByPersNum(@PathVariable(value = "persNum") String persNum) {
        UserInfo foundUser = userInfoService.findUserByPersNum(persNum);
        return new ResponseEntity<>(foundUser, HttpStatus.OK);

    }

    // create user
    @PostMapping
    public ResponseEntity<UserInfo> createUser(@Valid @RequestBody UserInfo userInfo) {
        UserInfo addedUserInfo = userInfoService.addUser(userInfo);
        return new ResponseEntity<>(addedUserInfo, HttpStatus.CREATED);

    }

    // update user
    @PutMapping
    public ResponseEntity<UserInfo> updateUser(@Valid @RequestBody UserInfo userInfo) {
        UserInfo updatedUser = userInfoService.updateUserByPersNum(userInfo);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    // delete user by id
    @DeleteMapping("/{persNum}")
    public ResponseEntity<Void> deleteUser(@PathVariable("persNum") String persNum) {

        userInfoService.deleteUserByPersNum(persNum);
        return new ResponseEntity<>(HttpStatus.OK);


    }


}
