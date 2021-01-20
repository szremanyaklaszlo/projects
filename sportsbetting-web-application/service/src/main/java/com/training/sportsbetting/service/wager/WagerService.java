package com.training.sportsbetting.service.wager;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.sportsbetting.domain.Outcome;
import com.training.sportsbetting.domain.Wager;

@Service
public class WagerService {

    @Autowired
    private WagerRepository wagerRepository;

    public List<Wager> findAll() {
        return wagerRepository.findAll();
    }

    public List<Wager> findActiveWagers() {
        return wagerRepository.findActiveWagers();
    }

    public int countOutcomeOccurences(Outcome outcome, List<Wager> wagers) {
        int count = 0;
        for (Wager wager : wagers) {
            if (wager.getOutcome().equals(outcome)) {
                count++;
            }
        }
        return count;
    }

    public List<Outcome> collectWagerOutcomes(List<Wager> wagers) {
        return wagers.stream()
                .map(Wager::getOutcome)
                .collect(Collectors.toList());
    }

}
