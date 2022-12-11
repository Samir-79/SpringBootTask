package com.example.springboottask;

import com.example.springboottask.entity.UserInfo;
import com.example.springboottask.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class RepositoryTests {

    @Autowired
    UserRepository userRepository;
    @Test
    void checkIfEmailExists() {
        UserInfo userInfo = new UserInfo("123456789121","John","Smith","j.smith@email.com", LocalDate.parse("1975-06-04"));

       userRepository.save(userInfo);

       boolean expected= userRepository.selectExistingEmail("j.smith@email.com");
        assertThat(expected).isTrue();

    }
    @Test
    void checkIfEmailDoesNotExist() {
        String email ="asdfads@email.com";
        boolean expected= userRepository.selectExistingEmail(email);
        assertThat(expected).isFalse();

    }






}
