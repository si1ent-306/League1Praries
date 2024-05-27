package com.example.elliottwagner.team;

import android.widget.ImageView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Team implements Serializable {
    private int id;
    private List<Player> roster;
    private String name;
    private String city;
    private String division;
    private String color;
    private int logo;
    private int wins;
    private int losses;
    private int draws;
    private int points;
    private int gamesPlayed;
    private int goalsScored;
    private int goalsAllowed;
    private int goalDifference;
    private int standing;

    public Team() {
    }

    public Team(int id, List<Player> roster, String name, String city, String division, String color, int logo, int wins, int losses, int draws, int points, int gamesPlayed, int goalsScored, int goalsAllowed, int goalDifference, int standing) {
        this.id = id;
        this.roster = roster;
        this.name = name;
        this.city = city;
        this.division = division;
        this.color = color;
        this.logo = logo;
        this.wins = wins;
        this.losses = losses;
        this.draws = draws;
        this.points = points;
        this.gamesPlayed = gamesPlayed;
        this.goalsScored = goalsScored;
        this.goalsAllowed = goalsAllowed;
        this.goalDifference = goalDifference;
        this.standing = standing;
    }
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public List<Player> getRoster() {
        return roster;
    }

    public void setRoster(List<Player> roster) {
        this.roster = roster;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int getGoalsAllowed() {
        return goalsAllowed;
    }

    public void setGoalsAllowed(int goalsAllowed) {
        this.goalsAllowed = goalsAllowed;
    }

    public int getGoalDifference() {
        return goalDifference;
    }

    public void setGoalDifference(int goalDifference) {
        this.goalDifference = goalDifference;
    }

    public int getStanding() {
        return standing;
    }

    public void setStanding(int standing) {
        this.standing = standing;
    }

    @Override
    public String toString() {
        return "Team{" +
                "roster=" + roster +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", division='" + division + '\'' +
                ", color='" + color + '\'' +
                ", logo=" + logo +
                ", wins=" + wins +
                ", losses=" + losses +
                ", draws=" + draws +
                ", points=" + points +
                ", gamesPlayed=" + gamesPlayed +
                ", goalsScored=" + goalsScored +
                ", goalsAllowed=" + goalsAllowed +
                ", goalDifference=" + goalDifference +
                ", standing=" + standing +
                '}';
    }
}
