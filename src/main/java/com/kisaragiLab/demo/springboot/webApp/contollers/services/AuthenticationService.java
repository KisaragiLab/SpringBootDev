package com.kisaragiLab.demo.springboot.webApp.contollers.services;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private static String USERNAME = "username";
    private static String PASSWORD = "Pa$$w0rD";
    
    public boolean authenticate(String username, String password) {
        boolean isValidUsername = username.equals(USERNAME) ;
        boolean isValidPassword = password.equals(PASSWORD);

        return isValidUsername && isValidPassword;
    }

}
