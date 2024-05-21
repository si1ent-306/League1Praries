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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_roster_page);
        recyclerView = findViewById(R.id.rvTeamRoster);
        LinearLayoutManager layoutManager = new LinearLayoutManager(TeamRosterPage.this);
        recyclerView.setLayoutManager(layoutManager);
        teamRoster = new ArrayList<>();
        //Add players to the list
        adapter = new PlayerAdapter(teamRoster);
        recyclerView.setAdapter(adapter);

    }
}