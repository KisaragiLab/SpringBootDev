package com.kisaragiLab.demo.springboot.webApp.contollers.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.security.core.Authentication;

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

    @RequestMapping(value="/", method=RequestMethod.GET)
    public String login(ModelMap model) {
        logger.debug("Login page GET");

        model.put("username", getLoggedInUsername());

        return "/webApp/welcome/Welcome";
    }

    @RequestMapping(value="/", method=RequestMethod.POST)
    public String gotoWelcome(@RequestParam String username, @RequestParam String password, ModelMap model) {
        logger.debug("Login page POST");

        if(!authService.authenticate(username, password)) {
            logger.debug("Login failed");
            model.put("errorMessage", "Invalid credentials. ");
            return PREFIX + "/Login";
        }

        model.put("username", username);

        return "/webApp/welcome/Welcome";
    }

    private String getLoggedInUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

}
