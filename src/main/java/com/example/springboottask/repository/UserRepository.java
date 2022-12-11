package com.example.springboottask.repository;

import com.example.springboottask.entity.UserInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserInfo,Long> {

    Optional<UserInfo> findUserInfoByPersNum(String persNum);

    @Query("" +
            "SELECT CASE WHEN COUNT(user) > 0 THEN " +
            "TRUE ELSE FALSE END " +
            "FROM UserInfo user " +
            "WHERE user.email = ?1"
    )
    Boolean selectExistingEmail(String email);

}
