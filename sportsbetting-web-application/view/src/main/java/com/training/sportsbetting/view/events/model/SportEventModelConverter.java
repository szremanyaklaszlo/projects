package com.training.sportsbetting.view.events.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.sportsbetting.domain.Outcome;
import com.training.sportsbetting.domain.SportEvent;
import com.training.sportsbetting.service.event.SportEventService;

@Service
public class SportEventModelConverter {

    @Autowired
    private SportEventService sportEventService;

    public List<SportEventModel> toModel(List<SportEvent> sportEvents) {
        List<SportEventModel> result = new ArrayList<>();
        List<Outcome> outcomes = sportEventService.collectOutcomes(sportEvents);
        for (Outcome outcome : outcomes) {
            result.add(mapToModel(outcome));
        }
        return result;
    }

    private SportEventModel mapToModel(Outcome outcome) {
        return new SportEventModel(outcome.getId(),
                outcome.getBet().getSportEvent().getTitle(),
                outcome.getBet().getSportEvent().getStartTime().toString() + "-" + outcome.getBet().getSportEvent().getEndTime().toString(),
                outcome.getBet().getBetType().toString(),
                outcome.getDescription(),
                outcome.getValue().toString());
    }
}
