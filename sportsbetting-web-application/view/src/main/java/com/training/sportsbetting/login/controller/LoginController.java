package com.training.sportsbetting.login.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    
    
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login () {
        return "login";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String postLogin (HttpServletRequest request) {
        
        return "login";
    }


}
