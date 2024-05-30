package com.example.elliottwagner.league;

import android.os.Bundle;
import android.view.Window;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elliottwagner.R;
import com.example.elliottwagner.team.DBHelper;
import com.example.elliottwagner.team.Team;

import java.util.ArrayList;
import java.util.Objects;

public class LeagueStandingsPage extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Team> teams;
    TeamAdapter adapter;
    DBHelper dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //will hide the title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // hide the title bar
        Objects.requireNonNull(getSupportActionBar()).hide();
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_league_standings_page);


        //get the recyclerview
        recyclerView = findViewById(R.id.rvStandings);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        dbHandler = new DBHelper(this);
        //get the teams
        teams = dbHandler.getAllTeams();
        adapter = new TeamAdapter(teams);
        recyclerView.setAdapter(adapter);
    }
}