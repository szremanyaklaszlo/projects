package com.training.sportsbetting.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tennis_sport_event")
public class TennisSportEvent extends SportEvent {

    public TennisSportEvent() {
        super();
    }

    public TennisSportEvent(String title, LocalDateTime startTime, LocalDateTime endTime, List<Bet> bets) {
        super(title, startTime, endTime, bets);
        // TODO Auto-generated constructor stub
    }

}
