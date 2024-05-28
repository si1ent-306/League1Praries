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
    ArrayList<Team> teams;
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
        recyclerView = findViewById(R.id.rvTeamSelect);
        button = findViewById(R.id.btBackToLeague);
        recyclerView.setLayoutManager(new LinearLayoutManager(LeagueSelectTeam.this));
        List<Player> players = new ArrayList<>();
        players.add(new Player( 0,1 , " ", "Player 1", "Canada", 19,"Striker", 0, 0,"Regina"  ));
        players.add(new Player( 0,1 , " ", "Player 1", "Canada", 19,"Striker", 0, 0,"Regina"  ));
        players.add(new Player( 0,1 , " ", "Player 1", "Canada", 19,"Striker", 0, 0,"Regina"  ));
        teams = new ArrayList<>();
        teams.add(new Team(0, players, "Regina", "Canada", "Saskatchewan", 1818, R.drawable.reginalogo, 0,0,0,0,0,0,0,0,0));
        teams.add(new Team(1, players, "Saskatoon", "Canada", "Saskatchewan", 1818, R.drawable.saskatoonlogo, 0,0,0,0,0,0,0,0,0));
        teams.add(new Team(2, players, "Valour", "Canada", "Saskatchewan", 1818, R.drawable.valourlogo, 0,0,0,0,0,0,0,0,0));
        teams.add(new Team(3, players, "Brandon", "Canada", "Saskatchewan", 1818, R.drawable.brandonlogo, 0,0,0,0,0,0,0,0,0));
        teams.add(new Team(4, players, "Regina", "Canada", "Saskatchewan", 1818, R.drawable.reginalogo, 0,0,0,0,0,0,0,0,0));

        // Set up the RecyclerView
        adapter = new LeagueSelectTeamAdapter(teams, this);
        recyclerView.setAdapter(adapter);
        dbhelper = new DBHelper(this);
        dbhelper.addTeam(teams.get(0));
        dbhelper.addTeam(teams.get(1));
        dbhelper.addTeam(teams.get(2));
        dbhelper.addTeam(teams.get(3));
        dbhelper.addTeam(teams.get(4));

        button.setOnClickListener(v -> {
            Log.d("Button Clicked", "Back to League Menu");
            Intent intent = new Intent(LeagueSelectTeam.this, LeagueMenuPage.class);
            startActivity(intent);
        });

    }

    @Override
    public void onItemClick(int position) {
        Team selectedTeam = teams.get(position);
        Log.d("Team Clicked", "Selected Team: " + selectedTeam.getName());
        Intent intent = new Intent(this, TeamMainPage.class);
        intent.putExtra("team", (Parcelable) selectedTeam);
        startActivity(intent);
    }
}