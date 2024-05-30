package com.example.elliottwagner.league;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elliottwagner.MainActivity;
import com.example.elliottwagner.R;
import com.example.elliottwagner.team.DBHelper;
import com.example.elliottwagner.team.Player;
import com.example.elliottwagner.team.Team;
import com.example.elliottwagner.team.TeamMainPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LeagueSelectTeam extends AppCompatActivity implements LeagueSelectTeamAdapter.OnItemClickListener {
    RecyclerView recyclerView;
    ArrayList<Team> allTeams;
    LeagueSelectTeamAdapter adapter;
    Button button;
    DBHelper dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //will hide the title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // hide the title bar
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_league_select_team);
        //Binding the views
        recyclerView = findViewById(R.id.rvTeamSelect);
        button = findViewById(R.id.btBackToLeague);
        // Set up the RecyclerView
        dbhelper = new DBHelper(this);
        allTeams = dbhelper.getAllTeams();
        recyclerView.setLayoutManager(new LinearLayoutManager(LeagueSelectTeam.this));
        adapter = new LeagueSelectTeamAdapter(allTeams, LeagueSelectTeam.this);
        recyclerView.setAdapter(adapter);

        button.setOnClickListener(v -> {
            // Handle button click event
            Log.d("Button Clicked", "Back to League Menu");
            Intent intent = new Intent(LeagueSelectTeam.this, LeagueMenuPage.class);
            startActivity(intent);
        });

    }

    @Override
    public void onItemClick(int position) {
        Team selectedTeam = allTeams.get(position);
        Log.d("Team Clicked", "Selected Team: " + selectedTeam.getName());
        Intent intent = new Intent(this, TeamMainPage.class);
        intent.putExtra("team", (Parcelable) selectedTeam);
        startActivity(intent);
    }
}