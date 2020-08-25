package com.training.sportsbetting.view.events.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventsController {

    @GetMapping("/events")
    public String events () {
        return "events";
    }
}
