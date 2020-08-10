package com.training.sportsbetting.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.training.sportsbetting.converter.LocalDateTimeAttributeConverter;

@Entity
@Table(name = "outcome_odd")
public class OutcomeOdd {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    @Column(name = "valid_from", nullable = false)
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime validFrom;
    @Column(name = "valid_until")
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime validUntil;
    @Column(nullable = false)
    private BigDecimal value;
    @ManyToOne(optional = false)
    @JoinColumn(name = "outcome_id", nullable = false)
    private Outcome outcome;

    public OutcomeOdd() {
    }

    public OutcomeOdd(LocalDateTime validFrom, LocalDateTime validUntil, BigDecimal value, Outcome outcome) {
        this.validFrom = validFrom;
        this.validUntil = validUntil;
        this.value = value;
        this.outcome = outcome;
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getValidFrom() {
        return validFrom;
    }

    public LocalDateTime getValidUntil() {
        return validUntil;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Outcome getOutcome() {
        return outcome;
    }

}
