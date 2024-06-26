package com.example.elliottwagner.team;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;

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
        //will hide the title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // hide the title bar
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_team_roster_page);
        recyclerView = findViewById(R.id.rvTeamRoster);
        LinearLayoutManager layoutManager = new LinearLayoutManager(TeamRosterPage.this);

        extras = getIntent().getExtras();
        Team team = Objects.requireNonNull(extras).getParcelable("team");
        Log.d("TeamRosterPage", "onCreate: " + team);

        recyclerView.setLayoutManager(layoutManager);
        teamRoster = (ArrayList<Player>) Objects.requireNonNull(team).getRoster();
        extras = getIntent().getExtras();
        //Create adapter
        adapter = new TeamRosterAdapter(teamRoster);
        recyclerView.setAdapter(adapter);

    }
}