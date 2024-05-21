package com.example.elliottwagner.team;

import java.util.ArrayList;

public class Roster {
    ArrayList<Player> players;

    public Roster(ArrayList<Player> players) {
        this.players = players;
    }

    public void printPlayers() {
        for (Player player : players) {
            System.out.println(player);
        }
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
    public Player findPlayer(String name) {
        for (Player player : players) {
            if (player.getFullName().equals(name)) {
                return player;
            }
        }
        return null;
    }
}
