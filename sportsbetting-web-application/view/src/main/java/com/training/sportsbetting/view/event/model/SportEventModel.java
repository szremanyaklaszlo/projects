package com.training.sportsbetting.view.event.model;

public final class SportEventModel {

    private final long id;
    private final String title;
    private final String time;
    private final Double homeTeamWinOdd;
    private final Double drawOdd;
    private final Double awayTeamWinOdd;
    private final long numberOfOutcomes;

    SportEventModel(long id, String title, String time, Double homeTeamWinOdd, Double drawOdd, Double awayTeamWinOdd, long numberOfOutcomes) {
        super();
        this.id = id;
        this.title = title;
        this.time = time;
        this.homeTeamWinOdd = homeTeamWinOdd;
        this.drawOdd = drawOdd;
        this.awayTeamWinOdd = awayTeamWinOdd;
        this.numberOfOutcomes = numberOfOutcomes;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getTime() {
        return time;
    }

    public Double getHomeTeamWinOdd() {
        return homeTeamWinOdd;
    }

    public Double getDrawOdd() {
        return drawOdd;
    }

    public Double getAwayTeamWinOdd() {
        return awayTeamWinOdd;
    }

    public long getNumberOfOutcomes() {
        return numberOfOutcomes;
    }

}
