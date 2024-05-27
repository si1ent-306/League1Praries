package com.example.elliottwagner.league;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elliottwagner.MainActivity;
import com.example.elliottwagner.R;
import com.example.elliottwagner.team.Player;
import com.example.elliottwagner.team.Team;
import com.example.elliottwagner.team.TeamMainPage;

import java.util.ArrayList;
import java.util.List;

public class LeagueSelectTeam extends AppCompatActivity implements LeagueSelectTeamAdapter.OnItemClickListener {
    RecyclerView recyclerView;
    ArrayList<Team> teams;
    LeagueSelectTeamAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_league_select_team);
        recyclerView = findViewById(R.id.rvTeamSelect);
        recyclerView.setLayoutManager(new LinearLayoutManager(LeagueSelectTeam.this));
        List<Player> players = new ArrayList<>();
        players.add(new Player( 0,1 , " ", "Player 1", "Canada", 19,"Striker", 0, 0,"Regina"  ));
        players.add(new Player( 0,1 , " ", "Player 1", "Canada", 19,"Striker", 0, 0,"Regina"  ));
        players.add(new Player( 0,1 , " ", "Player 1", "Canada", 19,"Striker", 0, 0,"Regina"  ));
        teams = new ArrayList<>();
        teams.add(new Team(0, players, "Regina", "Canada", "Saskatchewan", "Green", R.drawable.reginalogo, 0,0,0,0,0,0,0,0,0));
        teams.add(new Team(1, players, "Saskatoon", "Canada", "Saskatchewan", "Green", R.drawable.saskatoonlogo, 0,0,0,0,0,0,0,0,0));
        teams.add(new Team(2, players, "Valour", "Canada", "Saskatchewan", "Green", R.drawable.valourlogo, 0,0,0,0,0,0,0,0,0));
        teams.add(new Team(3, players, "Brandon", "Canada", "Saskatchewan", "Green", R.drawable.brandonlogo, 0,0,0,0,0,0,0,0,0));
        teams.add(new Team(4, players, "Regina", "Canada", "Saskatchewan", "Green", R.drawable.reginalogo, 0,0,0,0,0,0,0,0,0));

        adapter = new LeagueSelectTeamAdapter(teams, this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onItemClick(int position) {
        Log.d("Team Clicked", "onItemClick: " + position);
        Team selectedTeam = teams.get(position);
        Intent intent = new Intent(this, TeamMainPage.class);
        intent.putExtra("team", selectedTeam);
        startActivity(intent);
    }
}