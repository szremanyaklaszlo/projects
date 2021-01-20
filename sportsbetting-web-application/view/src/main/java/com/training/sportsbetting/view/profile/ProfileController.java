package com.training.sportsbetting.view.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.training.sportsbetting.service.user.security.AuthenticationChecker;

@Controller
public class ProfileController {

    @Autowired
    private AuthenticationChecker authenticationChecker;
    
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String getProfile() {
        return authenticationChecker.isAuthenticated() ? "profile-user" : HttpStatus.FORBIDDEN.toString();
    }
}
