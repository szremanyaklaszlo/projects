package com.training.sportsbetting.view.event.model;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service
@Scope(scopeName = "prototype", proxyMode = ScopedProxyMode.DEFAULT)
public class SportEventModelBuilder {

    private final static DateTimeFormatter START_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private final static DateTimeFormatter END_FORMAT = DateTimeFormatter.ofPattern("HH:mm");

    private long id;
    private String title;
    private String time;
    private Double firstWinOdd;
    private Double drawOdd;
    private Double secondWinOdd;
    private long numberOfOutcomes;

    public SportEventModelBuilder() {
        super();
    }

    public SportEventModelBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public SportEventModelBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public SportEventModelBuilder setTime(LocalDateTime startTime, LocalDateTime endTime) {
        this.time = startTime.format(START_FORMAT) +
                "-" + endTime.format(END_FORMAT);
        return this;
    }

    public SportEventModelBuilder setFirstWinOdd(BigDecimal firstWinOdd) {
        this.firstWinOdd = setOdd(firstWinOdd);
        return this;
    }

    public SportEventModelBuilder setDrawOdd(BigDecimal drawOdd) {
        this.drawOdd = setOdd(drawOdd);
        return this;
    }

    public SportEventModelBuilder setSecondWinOdd(BigDecimal secondWinOdd) {
        this.secondWinOdd = setOdd(secondWinOdd);
        return this;
    }

    private Double setOdd(BigDecimal odd) {
        return odd != null ? odd.round(new MathContext(3)).doubleValue() : null;
    }

    public SportEventModelBuilder setNumberOfOutcomes(long numberOfOutcomes) {
        this.numberOfOutcomes = numberOfOutcomes;
        return this;
    }

    public SportEventModel build() {
        return new SportEventModel(
                this.id,
                this.title,
                this.time,
                this.firstWinOdd,
                this.drawOdd,
                this.secondWinOdd,
                this.numberOfOutcomes);
    }
}
