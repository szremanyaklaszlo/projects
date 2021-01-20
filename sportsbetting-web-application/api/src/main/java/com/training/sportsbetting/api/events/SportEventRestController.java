package com.training.sportsbetting.api.events;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.sportsbetting.domain.SportEvent;
import com.training.sportsbetting.service.event.SportEventService;

@RestController
@RequestMapping("/api/event")
public class SportEventRestController {

    @Autowired
    private SportEventService sportEventService;

    @GetMapping(value = "get/all", produces = "application/json")
    public List<SportEvent> getAllEvent() {
        return sportEventService.findAll();
    }

    @DeleteMapping(value = "delete/{id}")
    public HttpStatus deleteSportEvent(@PathVariable Long id) {
        sportEventService.deleteById(id);
        return HttpStatus.OK;
    }
    
    @DeleteMapping(value = "delete/all")
    public HttpStatus deleteAllEvent() {
        sportEventService.deleteAll();
        return HttpStatus.OK;
    }
}
