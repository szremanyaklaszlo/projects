package com.training.sportsbetting.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "football_sport_event")
public class FootballSportEvent extends SportEvent {

    public FootballSportEvent() {
        super();
    }

    public FootballSportEvent(String title, LocalDateTime startDate) {
        super(title, startDate);
    }

}
