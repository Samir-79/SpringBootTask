package com.example.springboottask.validator;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class EmailValidator {

    public static boolean isValidEmail(String email){

        String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

        Pattern p = Pattern.compile(regex);


        Matcher m = p.matcher(email);

        return m.matches();
    }

}
