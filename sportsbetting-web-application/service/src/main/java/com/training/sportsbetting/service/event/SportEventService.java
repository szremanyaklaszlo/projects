package com.training.sportsbetting.service.event;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.sportsbetting.domain.Bet;
import com.training.sportsbetting.domain.FootballSportEvent;
import com.training.sportsbetting.domain.Outcome;
import com.training.sportsbetting.domain.SportEvent;
import com.training.sportsbetting.service.event.repository.SportEventRepository;

@Service
public class SportEventService {
    
    @Autowired
    private SportEventRepository sportEventRepository;

    public void saveAll(List<FootballSportEvent> footballEvents) {
        sportEventRepository.saveAll(footballEvents);
    }

    public List<SportEvent> findAll() {
        return sportEventRepository.findAll();
    }

    public List<Outcome> collectOutcomes(List<SportEvent> sportEvents){
        return sportEvents.stream().map(SportEvent::getBets).flatMap(List::stream)
                .map(Bet::getOutcomes).flatMap(List::stream)
                .collect(Collectors.toList());
    }
    
}
