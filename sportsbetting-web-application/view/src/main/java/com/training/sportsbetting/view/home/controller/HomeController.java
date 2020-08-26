package com.training.sportsbetting.view.home.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.training.sportsbetting.domain.SportEvent;
import com.training.sportsbetting.service.event.SportEventService;
import com.training.sportsbetting.service.security.AuthenticationChecker;
import com.training.sportsbetting.view.events.model.SportEventModel;
import com.training.sportsbetting.view.events.model.SportEventModelConverter;

@Controller
public class HomeController {
    
    @Autowired
    private SportEventService sportEventService;
    @Autowired
    private SportEventModelConverter modelConverter;
    @Autowired
    private AuthenticationChecker authenticationChecker;

    @RequestMapping(method = RequestMethod.GET, value = {"/","/home"})
    public String home (Model model) {
        List<SportEvent> sportEvents = sportEventService.findAll();
        List<SportEventModel> sportEventModels = modelConverter.toModel(sportEvents);
        model.addAttribute("events", sportEventModels);
        return authenticationChecker.isAuthenticated() ? "user-home" : "home";
    }
    
}
