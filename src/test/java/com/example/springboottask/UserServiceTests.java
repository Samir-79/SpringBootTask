package com.example.springboottask;

import com.example.springboottask.entity.UserInfo;
import com.example.springboottask.repository.UserRepository;
import com.example.springboottask.service.UserInfoService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import static org.assertj.core.api.ClassBasedNavigableIterableAssert.assertThat;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class UserServiceTests {

    @Mock
    private UserRepository userRepository;

    private UserInfoService userInfoServiceTest;

    @BeforeEach
    void setUp() {
        userInfoServiceTest= new UserInfoService(userRepository);
    }
    @Test
    void canGetAllUsers(){
        userInfoServiceTest.getAllUsers();
        verify(userRepository).findAll();

    }

    @Test
    void canAddUser(){
        UserInfo userInfo = new UserInfo("123456789121","John","Smith","j.smith@email.com", LocalDate.parse("1975-06-04"));
        userInfoServiceTest.addUser(userInfo);

        ArgumentCaptor<UserInfo> userArgumentCaptor=ArgumentCaptor.forClass(UserInfo.class);
        verify(userRepository).save(userArgumentCaptor.capture());

        UserInfo capturedUser= userArgumentCaptor.getValue();

        assertThat(capturedUser).isEqualTo(userInfo);

    }


}
