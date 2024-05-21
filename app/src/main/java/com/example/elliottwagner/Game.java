package com.example.elliottwagner;

import com.example.elliottwagner.team.Team;

public class Game {
    private Team homeTeam;
    private Team awayTeam;
    private int homeScore;
    private int awayScore;
    private int startTime;
    private int dateOfGame;
    private int gameID;
    private String stadium;

    public Game(Team homeTeam, Team awayTeam, int homeScore, int awayScore, int startTime, int dateOfGame, int gameID, String stadium) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.startTime = startTime;
        this.dateOfGame = dateOfGame;
        this.gameID = gameID;
        this.stadium = stadium;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getDateOfGame() {
        return dateOfGame;
    }

    public void setDateOfGame(int dateOfGame) {
        this.dateOfGame = dateOfGame;
    }

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    @Override
    public String toString() {
        return "Game{" +
                "homeTeam=" + homeTeam +
                ", awayTeam=" + awayTeam +
                ", homeScore=" + homeScore +
                ", awayScore=" + awayScore +
                ", startTime=" + startTime +
                ", dateOfGame=" + dateOfGame +
                ", gameID=" + gameID +
                ", stadium='" + stadium + '\'' +
                '}';
    }
}
