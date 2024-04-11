package com.kisaragiLab.demo.springboot.webApp.contollers.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private static String PREFIX = "/login";
    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, ModelMap model) {
        logger.debug("username: {}", username);
        model.put("username", username);
        model.put("password", password);
        return PREFIX + "/Login";
    }

}
