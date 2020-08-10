package com.training.sportsbetting.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.training.sportsbetting.converter.LocalDateTimeAttributeConverter;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "sport_event")
public class SportEvent {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    @Column(nullable = false)
    private String title;
    @Column(name = "start_time", nullable = false)
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime startTime;
    @OneToMany(mappedBy = "sportEvent", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Bet> bets;

    public SportEvent() {
    }

    public SportEvent(String title, LocalDateTime startDate) {
        this.title = title;
        this.startTime = startDate;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getStartDate() {
        return startTime;
    }

    public List<Bet> getBets() {
        return bets;
    }

}
