package com.training.sportsbetting.view.bet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.training.sportsbetting.domain.Outcome;
import com.training.sportsbetting.domain.SportEvent;
import com.training.sportsbetting.service.event.SportEventService;
import com.training.sportsbetting.view.event.model.SportEventModel;

@Controller
public class BetController {
    
    @Autowired
    private SportEventService sportEventService;
    
    @GetMapping("/bet")
    public String getBettingPage(@RequestParam("id") String eventId, Model model) {
        SportEvent sportevent = sportEventService.findById(eventId);
        model.addAttribute("outcomes", model);
        return "bet-user";
    }

    @ModelAttribute("outcomes")
    public List<Outcome> outcomes() {
        
    }
}
