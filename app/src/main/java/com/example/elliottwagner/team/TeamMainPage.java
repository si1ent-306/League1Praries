package com.example.elliottwagner.team;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elliottwagner.R;
import com.example.elliottwagner.league.LeagueMenuPage;
import com.example.elliottwagner.league.LeagueSelectTeam;

import java.util.ArrayList;
import java.util.Objects;

public class TeamMainPage extends AppCompatActivity {
    ImageView teamLogo;
    Bundle extras = null;
    Button chooseTeam;
    View view;
    RecyclerView rvTeamRoster;
    TextView tvRoster;
    TextView tvTeamScheduale;
    TextView tvTeamNews;
    TeamRosterAdapter adapter;
    ArrayList<Player> players;
    DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //will hide the title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // hide the title bar
        Objects.requireNonNull(getSupportActionBar()).hide();
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_team_main_page);

        //Get the extras from the intent including the team
        extras = getIntent().getExtras();
        Team team = Objects.requireNonNull(extras).getParcelable("team");
        Log.d("TeamMainPage", "onCreate: " + team);
        Log.d("TeamMainPage", "onCreate: " + team.getLogo());

        //Set the background color based on the team
        view = findViewById(R.id.main);
        teamLogo = findViewById(R.id.ivTeamLogo);
        tvRoster = findViewById(R.id.tvTeamRoster);
        teamLogo.setImageResource(Objects.requireNonNull(team).getLogo());
        switch (team.getName()) {
            case "FC Regina":
                view.setBackgroundColor(getResources().getColor(R.color.fcReginaBlue));
                break;
            case "Saskatoon":
                view.setBackgroundColor(getResources().getColor(R.color.saskatoonGreen));
                break;
            case "Winnipeg FC":
                view.setBackgroundColor(getResources().getColor(R.color.fcWinnipegRed));
                break;
            case "Yorkton Wanderers":
                view.setBackgroundColor(getResources().getColor(R.color.yorktonYellow));
                break;
            case "FC Brandon":
                view.setBackgroundColor(getResources().getColor(R.color.fcBrandonBlue));
                break;
            case "AFC MJ":
                view.setBackgroundColor(getResources().getColor(R.color.teal_200));
                break;
            case "Valour U21":
                view.setBackgroundColor(getResources().getColor(R.color.valourU21Blue));
                break;
            case "Manitoba United":
                view.setBackgroundColor(getResources().getColor(R.color.purple_200));
                break;

        }
        Log.d("TeamMainPage", "onCreate: " + team.getName());

        //Bind the views
        dbHelper = new DBHelper(this);
        rvTeamRoster = findViewById(R.id.rvTeamRoster);
        chooseTeam = findViewById(R.id.btnOptions);
        tvRoster = findViewById(R.id.tvTeamRoster);
        tvTeamScheduale = findViewById(R.id.tvScoreboard);
        tvTeamNews = findViewById(R.id.tvTeamNews);

        //Set the layout manager
        rvTeamRoster.setLayoutManager(new LinearLayoutManager(TeamMainPage.this));

        //Get the players from the database

        adapter = new TeamRosterAdapter((ArrayList<Player>) team.getRoster());
        rvTeamRoster.setAdapter(adapter);

        //Set the click listeners
        chooseTeam.setOnClickListener(v -> {
            Intent intent = new Intent(TeamMainPage.this, LeagueSelectTeam.class);
            startActivity(intent);
        });
        //Set the click listeners
        tvRoster.setOnClickListener(v -> {
            Intent intent = new Intent(TeamMainPage.this, TeamRosterPage.class);
            intent.putExtra("team", (Parcelable) team);
            startActivity(intent);
            Log.d("TeamMainPage", "Roast click: " + team.getName());
        });
        //Set the click listeners
        tvTeamScheduale.setOnClickListener(v -> {
            Intent intent = new Intent(TeamMainPage.this, TeamSchedualePage.class);
            intent.putExtra("team", (Parcelable) team);
            startActivity(intent);
            Log.d("TeamMainPage", "onCreate: " + team.getName());
        });
        //Set the click listeners
        tvTeamNews.setOnClickListener(v -> {
            Intent intent = new Intent(TeamMainPage.this, TeamNewsPage.class);
            intent.putExtra("team", (Parcelable) team);
            startActivity(intent);
            Log.d("TeamMainPage", "onCreate: " + team.getName());
        });
    }
}