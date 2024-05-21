package com.example.elliottwagner.team;

import android.widget.ImageView;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Player implements Serializable {
    int number;
    String firstName;
    String lastName;
    String country;
    int age;
    String team;

    ImageView photo;
    String position;
    int height;
    int weight;
    int goals;
    int assists;
    int yellowCards;
    int redCards;


    public Player() {
    }

    public Player(int number, String firstName, String lastName, String country, int age, String position, int height, int weight, int goals, int assists, int yellowCards, int redCards, String team) {
        this.number = number;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.age = age;
        this.position = position;
        this.height = height;
        this.weight = weight;
        this.goals = goals;
        this.assists = assists;
        this.yellowCards = yellowCards;
        this.redCards = redCards;
        this.team = team;

    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFullName() {
        return firstName + " " + lastName;
    }
    public ImageView getPhoto() {
        return photo;
    }
    public void setPhoto(ImageView photo) {
        this.photo = photo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;

    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(int yellowCards) {
        this.yellowCards = yellowCards;
    }

    public int getRedCards() {
        return redCards;
    }

    public void setRedCards(int redCards) {
        this.redCards = redCards;
    }

    @NonNull
    @Override
    public String toString() {
        return "Player{" +
                "number=" + number +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                ", age=" + age +
                ", position='" + position + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", goals=" + goals +
                ", assists=" + assists +
                ", yellowCards=" + yellowCards +
                ", redCards=" + redCards +
                '}';
    }
}
