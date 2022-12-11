package com.example.springboottask.service;

import com.example.springboottask.entity.UserInfo;
import com.example.springboottask.exception.BadRequestException;
import com.example.springboottask.exception.NotFoundException;
import com.example.springboottask.repository.UserRepository;
import com.example.springboottask.validator.EmailValidator;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserInfoService {


    private final UserRepository userRepository;

    public UserInfoService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public UserInfo addUser(UserInfo userInfo) {

        Optional<UserInfo> foundUser = userRepository.findUserInfoByPersNum(userInfo.getPersNum());
        if (foundUser.isPresent()) {
            throw new BadRequestException("User with perNum " + userInfo.getPersNum() + " already exists");
        }

        Iterable<UserInfo> users = userRepository.findAll();
        for (UserInfo foundUsers : users
        ) {
            if (foundUsers.getEmail().equals(userInfo.getEmail())) {
                throw new BadRequestException("Email address already in use");
            }

        }

        if (!EmailValidator.isValidEmail(userInfo.getEmail())) {
            throw new BadRequestException("Email format is not valid!");
        }




        return userRepository.save(userInfo);

    }

    public Iterable<UserInfo> getAllUsers() {
        return userRepository.findAll();

    }

    public UserInfo findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found with id :" + id));
    }


    public UserInfo findUserByPersNum(String persNum) {
        return userRepository.findUserInfoByPersNum(persNum).orElseThrow(() -> new NotFoundException("User not found with persNum : " + persNum));

    }


    public UserInfo updateUserByPersNum(UserInfo userInfo) {

        UserInfo existingUserInfo = this.userRepository.findUserInfoByPersNum(userInfo.getPersNum())
                .orElseThrow(() -> new NotFoundException("User not found with persNum :" + userInfo.getPersNum()));
        existingUserInfo.setFirstName(userInfo.getFirstName());
        existingUserInfo.setLastName(userInfo.getLastName());
        existingUserInfo.setEmail(userInfo.getEmail());
        existingUserInfo.setDateOfBirth(userInfo.getDateOfBirth());
        return this.userRepository.save(existingUserInfo);
    }

    public void deleteUserByPersNum(String persNum) {
        UserInfo existingUserInfo = this.userRepository.findUserInfoByPersNum(persNum)
                .orElseThrow(() -> new NotFoundException("User not found with persNum :" + persNum));
        userRepository.delete(existingUserInfo);
    }
}

