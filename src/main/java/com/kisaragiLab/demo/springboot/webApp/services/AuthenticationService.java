package com.kisaragiLab.demo.springboot.webApp.services;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private static String USERNAME = "John";
    private static String PASSWORD = "";
    
    public boolean authenticate(String username, String password) {
        boolean isValidUsername = username.equals(USERNAME) ;
        boolean isValidPassword = password.equals(PASSWORD);

        return isValidUsername && isValidPassword;
    }

}
