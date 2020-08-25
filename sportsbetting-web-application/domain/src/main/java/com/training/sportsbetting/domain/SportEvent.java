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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.training.sportsbetting.domain.converter.LocalDateTimeAttributeConverter;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "sport_event")
public class SportEvent {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String title;
    @Column(name = "start_time", nullable = false)
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime startTime;
    @Column(name = "end_time", nullable = false)
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime endTime;
    @JsonManagedReference
    @OneToMany(mappedBy = "sportEvent", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Bet> bets;

    public SportEvent() {
    }

    public SportEvent(String title, LocalDateTime startTime, LocalDateTime endTime, List<Bet> bets) {
        super();
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.bets = bets;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public List<Bet> getBets() {
        return bets;
    }

}
