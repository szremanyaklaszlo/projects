package com.training.sportsbetting.view.events;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.training.sportsbetting.domain.SportEvent;
import com.training.sportsbetting.service.event.SportEventService;
import com.training.sportsbetting.view.event.model.SportEventModel;
import com.training.sportsbetting.view.event.model.SportEventModelConverter;

@Controller
public class EventsController {

    @Autowired
    private SportEventService sportEventService;
    @Autowired
    private SportEventModelConverter modelConverter;

    @GetMapping("/events")
    public String getEvents() {
        return "events";
    }

    @ModelAttribute("events")
    public List<SportEventModel> bestFiveEvents() {
        List<SportEvent> activeEvents = sportEventService.findActiveSportEvents();
        List<SportEvent> sortedEvents = sportEventService.sortByPopularityAndStartDate(activeEvents);
        List<SportEventModel> sportEventModels = modelConverter.toModel(sortedEvents);
        return sportEventModels;
    }
}
