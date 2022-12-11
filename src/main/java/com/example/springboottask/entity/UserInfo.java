package com.example.springboottask.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "perNum field can not be empty")
    @Size(min = 12, max = 12,message = "Provide persNum with 12 digits")
    private String persNum;

    @NotNull
    @Size(min=2, message = "First name should have at least 2 characters")
    private String firstName;

    @NotNull
    @Size(min=2, message = "Last name should have at least 2 characters")
    private String lastName;
    @NotBlank
    @Email(message = "Email not valid!")
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    public UserInfo() {
    }

    public UserInfo(String persNum, String firstName, String lastName, String email, LocalDate dateOfBirth) {
        this.persNum = persNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPersNum() {
        return persNum;
    }

    public void setPersNum(String persNum) {
        this.persNum = persNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
