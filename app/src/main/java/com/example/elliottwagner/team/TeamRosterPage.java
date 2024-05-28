package com.example.elliottwagner.team;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.elliottwagner.R;

import java.util.ArrayList;
import java.util.Objects;

public class TeamRosterPage extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Player> teamRoster = null;
    TeamRosterAdapter adapter;
    DBHelper dbHelper;
    Bundle extras = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_roster_page);
        recyclerView = findViewById(R.id.rvTeamRoster);
        LinearLayoutManager layoutManager = new LinearLayoutManager(TeamRosterPage.this);
        Team team = Objects.requireNonNull(extras).getParcelable("team");
        recyclerView.setLayoutManager(layoutManager);
        teamRoster = (ArrayList<Player>) Objects.requireNonNull(team).getRoster();
        extras = getIntent().getExtras();
        //Create adapter
        adapter = new TeamRosterAdapter(teamRoster);
        recyclerView.setAdapter(adapter);

    }
}