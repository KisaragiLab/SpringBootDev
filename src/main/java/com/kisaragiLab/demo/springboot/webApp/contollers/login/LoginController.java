package com.kisaragiLab.demo.springboot.webApp.contollers.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kisaragiLab.demo.springboot.webApp.services.AuthenticationService;

@Controller
@SessionAttributes("username")
public class LoginController {

    private static String PREFIX = "/webApp/login";
    private Logger logger = LoggerFactory.getLogger(getClass());

    private AuthenticationService authService;

    public LoginController(AuthenticationService authService) {
        super();
        this.authService = authService;
    }

    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String login() {
        logger.debug("Login page GET");

        return PREFIX + "/Login";
    }

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String gotoWelcome(@RequestParam String username, @RequestParam String password, ModelMap model) {
        logger.debug("Login page POST");

        if(!authService.authenticate(username, password)) {
            logger.debug("Login failed");
            model.put("errorMessage", "Invalid credentials. ");
            return PREFIX + "/Login";
        }

        model.put("username", username);
        model.put("password", password);

        return "webApp/welcome/Welcome";
    }

}
