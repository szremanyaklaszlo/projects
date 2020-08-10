package com.training.sportsbetting.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tennis_sport_event")
public class TennisSportEvent extends SportEvent {

    public TennisSportEvent() {
        super();
    }

    public TennisSportEvent(String title, LocalDateTime startDate) {
        super(title, startDate);
    }

}
