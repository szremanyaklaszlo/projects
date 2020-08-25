package com.training.sportsbetting.view.events.model;

public class SportEventModel {
    
    private Long id;
    private String title;
    private String time;
    private String betType;
    private String outcome;
    private String odd;
    
    public SportEventModel(Long id, String title, String time, String betType, String outcome, String odd) {
        super();
        this.id = id;
        this.title = title;
        this.time = time;
        this.betType = betType;
        this.outcome = outcome;
        this.odd = odd;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getTime() {
        return time;
    }

    public String getBetType() {
        return betType;
    }

    public String getOutcome() {
        return outcome;
    }

    public String getOdd() {
        return odd;
    }
    
}
