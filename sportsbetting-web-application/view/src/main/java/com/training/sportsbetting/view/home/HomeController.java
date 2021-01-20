package com.training.sportsbetting.view.home;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.training.sportsbetting.domain.SportEvent;
import com.training.sportsbetting.service.event.SportEventService;
import com.training.sportsbetting.view.event.model.SportEventModel;
import com.training.sportsbetting.view.event.model.SportEventModelConverter;

@Controller
public class HomeController {

    private final static int LIST_SIZE = 5;
    @Autowired
    private SportEventService sportEventService;
    @Autowired
    private SportEventModelConverter modelConverter;

    @RequestMapping(method = RequestMethod.GET, value = { "/", "/home" })
    public String getHome() {
        return "home";
    }

    @ModelAttribute("events")
    public List<SportEventModel> bestFiveEvents() {
        List<SportEvent> activeEvents = sportEventService.findActiveSportEvents();
        List<SportEvent> sortedEvents = sportEventService.sortByPopularityAndStartDate(activeEvents);
        sortedEvents = limitSize(sortedEvents, LIST_SIZE);
        List<SportEventModel> sportEventModels = modelConverter.toModel(sortedEvents);
        return sportEventModels;
    }

    private List<SportEvent> limitSize(List<SportEvent> sportEvents, int listSize) {
        return sportEvents.stream().limit(listSize).collect(Collectors.toList());
    }


}
