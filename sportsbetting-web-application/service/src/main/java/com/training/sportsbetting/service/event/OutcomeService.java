package com.training.sportsbetting.service.event;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.sportsbetting.domain.Outcome;
import com.training.sportsbetting.domain.Wager;
import com.training.sportsbetting.service.event.repository.OutcomeRepository;
import com.training.sportsbetting.service.wager.WagerService;

@Service
public class OutcomeService {

    @Autowired
    private OutcomeRepository outcomeRepository;
    @Autowired
    private WagerService wagerService;

    public List<Outcome> findAll() {
        return outcomeRepository.findAll();
    }

    public List<Outcome> findMostPopularOutcomes(int topN) {
        Map<Outcome, Integer> outcomeOccurrences = countAndGetOutcomeOccurences(collectActiveWagerOutcomes());
        outcomeOccurrences = sortByValueDescend(outcomeOccurrences);
        return getFirstNthElement(outcomeOccurrences, topN);
    }

    private LinkedHashMap<Outcome, Integer> sortByValueDescend(Map<Outcome, Integer> outcomeOccurrences) {
        return outcomeOccurrences.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    private List<Outcome> collectActiveWagerOutcomes() {
        return wagerService.findAll().stream().filter(wager -> !wager.isProcessed()).map(Wager::getOutcome).collect(Collectors.toList());
    }

    private Map<Outcome, Integer> countAndGetOutcomeOccurences(List<Outcome> outcomes) {
        Map<Outcome, Integer> numberOfOutcomes = new HashMap<>();
        for (Outcome outcome : outcomes) {
            if (numberOfOutcomes.containsKey(outcome)) {
                numberOfOutcomes.replace(outcome, numberOfOutcomes.get(outcome) + 1);
            } else {
                numberOfOutcomes.put(outcome, 1);
            }
        }
        return numberOfOutcomes;
    }

    private List<Outcome> getFirstNthElement(Map<Outcome, Integer> outcomeOccurrences, int topN) {
        return outcomeOccurrences.entrySet().stream().map(Map.Entry::getKey).limit(topN).collect(Collectors.toList());
    }

}
