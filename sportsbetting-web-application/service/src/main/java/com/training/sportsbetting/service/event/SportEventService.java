package com.training.sportsbetting.service.event;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.training.sportsbetting.domain.Bet;
import com.training.sportsbetting.domain.Outcome;
import com.training.sportsbetting.domain.SportEvent;
import com.training.sportsbetting.domain.Wager;
import com.training.sportsbetting.service.wager.WagerService;

public class SportEventService {
    
    private SportEventBaseRepository sportEventRepository;
    @Autowired
    private WagerService wagerService;
    @Autowired
    private SportEventComparator comparator;

    public void setSportEventRepository(SportEventBaseRepository sportEventRepository) {
        this.sportEventRepository = sportEventRepository;
    }

    public void saveAll(List<? extends SportEvent> sportEvent) {
        sportEventRepository.saveAll(sportEvent);
    }
    
    public List<SportEvent> findAll() {
        return sportEventRepository.findAll();
    }
    
    public SportEvent findById(long id) {
        return sportEventRepository.findById(id).orElseThrow( () -> SportEventNotFoundException("Sport event not found with id " + id + "."));
    }
    
    public List<SportEvent> findActiveSportEvents() {
        return sportEventRepository.findActiveSportEvents();
    }
    
    public void deleteAll() {
        sportEventRepository.deleteAll();
    }
    public void deleteById(Long id) {
        sportEventRepository.deleteById(id);
    }

    public List<Outcome> collectOutcomes(List<? extends SportEvent> sportEvents) {
        return sportEvents.stream()
                .map(SportEvent::getBets).flatMap(List::stream)
                .map(Bet::getOutcomes).flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public List<Outcome> collectOutcomes(SportEvent sportEvent) {
        return sportEvent.getBets().stream()
                .map(Bet::getOutcomes)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public List<SportEvent> sortByPopularityAndStartDate(List<? extends SportEvent> sportEvents) {
        Map<SportEvent, Integer> sportEventPopularity = countPolularity(sportEvents, wagerService.findActiveWagers());
        sportEventPopularity = sort(sportEventPopularity, comparator.sortByPopularityDescend().thenComparing(comparator.sortByStartDateAscend()));
        return collect(sportEventPopularity);
    }

    private Map<SportEvent, Integer> countPolularity(List<? extends SportEvent> sportEvents, List<Wager> wagers) {
        Map<SportEvent, Integer> sportEventPopularity = new HashMap<>();
        for (SportEvent sportEvent : sportEvents) {
            sportEventPopularity.put(sportEvent, countPopularity(sportEvent, wagers));
        }
        return sportEventPopularity;
    }

    private Integer countPopularity(SportEvent sportEvent, List<Wager> wagers) {
        List<Outcome> outcomes = collectOutcomes(sportEvent);
        int count = 0;
        for (Outcome outcome : outcomes) {
            count += wagerService.countOutcomeOccurences(outcome, wagers);
        }
        return count;
    }

    private Map<SportEvent, Integer> sort(Map<? extends SportEvent, Integer> sportEventPopularity, Comparator<Entry<? extends SportEvent, Integer>> comparator) {
        return sportEventPopularity.entrySet().stream()
                .sorted(comparator)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    private List<SportEvent> collect(Map<? extends SportEvent, Integer> sportEventPopularity) {
        return sportEventPopularity.entrySet().stream()
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

}
