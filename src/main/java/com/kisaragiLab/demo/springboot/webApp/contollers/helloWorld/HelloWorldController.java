package com.kisaragiLab.demo.springboot.webApp.contollers.helloWorld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {

    private static String PREFIX = "/webApp/helloWorld";

    @RequestMapping("/hello")
    @ResponseBody
    public String helloWorld() {
        return "Hello World!";
    }
    
    @RequestMapping("/hello-html")
    @ResponseBody
    public String helloWorldHTML() {
        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title>My first HTML page</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("<h1>Hello World from HTML</h1>");
        sb.append("</body>");
        sb.append("</html>");
        return sb.toString();
    }

    @RequestMapping("/hello-jsp")
    public String helloWorldJsp() {
        return PREFIX + "/HelloWorld";
    }

}
