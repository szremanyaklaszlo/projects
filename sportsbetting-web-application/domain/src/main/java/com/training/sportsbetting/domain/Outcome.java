package com.training.sportsbetting.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "outcome")
public class Outcome {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private String description;
    @ManyToOne(optional = false)
    @JoinColumn(name = "bet_id", nullable = false)
    private Bet bet;
    @Column(name = "outcome_odds")
    @OneToMany(mappedBy = "outcome", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OutcomeOdd> outcomeOdds;

    public Outcome() {
    }

    public Outcome(String description, Bet bet) {
        this.description = description;
        this.bet = bet;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Bet getBet() {
        return bet;
    }

    public List<OutcomeOdd> getOutcomeOdds() {
        return outcomeOdds;
    }

}
