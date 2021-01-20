package com.training.sportsbetting.view.event.model;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import com.training.sportsbetting.domain.Bet;
import com.training.sportsbetting.domain.BetType;
import com.training.sportsbetting.domain.Outcome;
import com.training.sportsbetting.domain.SportEvent;

@Service
@Scope(scopeName = "prototype", proxyMode = ScopedProxyMode.DEFAULT)
public class SportEventModelConverter {

    @Autowired
    private SportEventModelBuilder sportEventModelBuilder;

    public List<SportEventModel> toModel(List<SportEvent> sportEvents) {
        List<SportEventModel> sportEventModels = new LinkedList<>();
        for (SportEvent sportEvent : sportEvents) {
            sportEventModels.add(toModel(sportEvent));
        }
        return sportEventModels;
    }

    public SportEventModel toModel(SportEvent sportEvent) {
        List<Outcome> outcomes = findWinnerBetOutcomes(sportEvent);
        return convertToModel(sportEvent, outcomes);
    }

    private List<Outcome> findWinnerBetOutcomes(SportEvent sportEvent) {
        return sportEvent.getBets().stream()
                .filter(bet -> bet.getBetType() == BetType.WINNER)
                .findAny()
                .get()
                .getOutcomes();
    }

    private SportEventModel convertToModel(SportEvent sportEvent, List<Outcome> outcomes) {
        return sportEventModelBuilder
                .setId(sportEvent.getId())
                .setTitle(sportEvent.getTitle())
                .setTime(sportEvent.getStartTime(), sportEvent.getEndTime())
                .setFirstWinOdd(getWinnerOdd(sportEvent, outcomes, sportEvent.getHomeTeam()))
                .setDrawOdd(getWinnerOdd(sportEvent, outcomes, "Draw"))
                .setSecondWinOdd(getWinnerOdd(sportEvent, outcomes, sportEvent.getHomeTeam()))
                .setNumberOfOutcomes(countOutcomes(sportEvent))
                .build();
    }

    private BigDecimal getWinnerOdd(SportEvent sportEvent, List<Outcome> outcomes, String winner) {
        return outcomes.stream()
                .filter(outcome -> outcome.getDescription().equals(winner))
                .findAny()
                .orElse(new Outcome("Blank", null, null))
                .getValue();
    }

    private long countOutcomes(SportEvent sportEvent) {
        return sportEvent.getBets().stream()
                .map(Bet::getOutcomes)
                .flatMap(List::stream)
                .count();
    }
}
