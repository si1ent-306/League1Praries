package com.example.elliottwagner.team;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.elliottwagner.R;

import java.util.ArrayList;

public class TeamRosterPage extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Player> teamRoster;
    PlayerAdapter adapter;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_roster_page);
        recyclerView = findViewById(R.id.rvTeamRoster);
        LinearLayoutManager layoutManager = new LinearLayoutManager(TeamRosterPage.this);
        recyclerView.setLayoutManager(layoutManager);
        //Create Teams
        dbHelper.createTeams();
        teamRoster = new ArrayList<>();
        //Add players to the list
        dbHelper = new DBHelper(this);
        //Get all players from the database
        teamRoster = dbHelper.getAllPlayers();
        //Create adapter
        adapter = new PlayerAdapter(teamRoster);
        recyclerView.setAdapter(adapter);

    }
}