package com.training.sportsbetting.view.events.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.sportsbetting.domain.FootballSportEvent;
import com.training.sportsbetting.domain.SportEvent;
import com.training.sportsbetting.service.event.SportEventService;

@RestController
@RequestMapping("/api/sportevent")
public class SportEventCrudController {

    @Autowired
    private SportEventService sportEventService;
    
    @PostMapping(value = "upload/football", consumes = "application/json")
    public HttpStatus uploadFootballEvents (@RequestBody List<FootballSportEvent> footballEvents) {
        sportEventService.saveAll(footballEvents);
        return HttpStatus.OK;
    }
    
    @GetMapping(value = "get/all", produces = "application/json")
    public List<SportEvent> getAllEvent(){
        return sportEventService.findAll();
    }
    
}
