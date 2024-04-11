package com.kisaragiLab.demo.springboot.webApp.contollers.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    private static String PREFIX = "/login";

    @RequestMapping("/login")
    public String login() {
        return PREFIX + "/Login";
    }

}
