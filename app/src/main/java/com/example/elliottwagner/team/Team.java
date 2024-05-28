package com.example.elliottwagner.team;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.List;

public class Team implements Serializable, Parcelable {
    private int id;
    private List<Player> roster;
    private String name;
    private String city;
    private String division;
    private int color;
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

    public Team(int id, List<Player> roster, String name, String city, String division, int color, int logo, int wins, int losses, int draws, int points, int gamesPlayed, int goalsScored, int goalsAllowed, int goalDifference, int standing) {
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

    public Team(int id, String name, String city, String division,int color, int wins, int losses, int draws, int points, int goalDifference, int standing) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.division = division;
        this.color = color;
        this.wins = wins;
        this.losses = losses;
        this.draws = draws;
        this.points = points;
        this.goalDifference = goalDifference;
        this.standing = standing;
    }

    protected Team(Parcel in) {
        id = in.readInt();
        name = in.readString();
        city = in.readString();
        division = in.readString();
        color = in.readInt();
        logo = in.readInt();
        wins = in.readInt();
        losses = in.readInt();
        draws = in.readInt();
        points = in.readInt();
        gamesPlayed = in.readInt();
        goalsScored = in.readInt();
        goalsAllowed = in.readInt();
        goalDifference = in.readInt();
        standing = in.readInt();
    }
    public static final Creator<Team> CREATOR = new Creator<Team>() {
        @Override
        public Team createFromParcel(Parcel in) {
            return new Team(in);
        }

        @Override
        public Team[] newArray(int size) {
            return new Team[size];
        }
    };
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

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(city);
        dest.writeString(division);
        dest.writeInt(color);
        dest.writeInt(logo);
        dest.writeInt(wins);
        dest.writeInt(losses);
        dest.writeInt(draws);
        dest.writeInt(points);
        dest.writeInt(gamesPlayed);
        dest.writeInt(goalsScored);
        dest.writeInt(goalsAllowed);
        dest.writeInt(goalDifference);
        dest.writeInt(standing);
    }
}
