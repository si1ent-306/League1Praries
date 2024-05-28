package com.example.elliottwagner.league;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elliottwagner.Game;
import com.example.elliottwagner.R;
import com.example.elliottwagner.team.DBHelper;
import com.example.elliottwagner.team.Player;
import com.example.elliottwagner.team.Roster;
import com.example.elliottwagner.team.Team;
import com.example.elliottwagner.team.TeamMainPage;
import com.example.elliottwagner.team.TeamRosterPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
//THINGS TO DO FOR THIS PROJECT
//USE STRINGS.XML TO SET TEXT
//USE COLOR.XML TO SET COLORS
//USE COMMENTS AND LOGS
//USE CONSTRAINT LAYOUT PROPERLY
//LANDSCAPE AND PORTRAIT ON ALL PAGES

public class LeagueMenuPage extends AppCompatActivity {
    Button chooseTeam;
    TextView tvScoreboard;
    TextView tvStandings;
    TextView tvNews;
    RecyclerView standings;
    DBHelper dbHelper;
    TeamAdapter standingsAdapter;
    ArrayList<Team> teams;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //will hide the title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // hide the title bar
        Objects.requireNonNull(getSupportActionBar()).hide();
        EdgeToEdge.enable(this);
        //set the layout
        setContentView(R.layout.activity_league_menu_page);
        //Create the players
        Player playerRegina = new Player(0,1,"John", "Smith", "Canada", 20, "Striker", 0,0,0,0,0,0, "FC Regina" );
        Player playerWinnipeg = new Player(0,1,"John", "Smith", "Canada", 20, "Striker", 0,0,0,0,0,0, "Winnipeg FC" );
        Player playerBrandon = new Player(0,1,"John", "Smith", "Canada", 20, "Striker", 0,0,0,0,0,0, "FC Brandon" );
        Player playerMooseJaw = new Player(0,1,"John", "Smith", "Canada", 20, "Striker", 0,0,0,0,0,0, "AFC MJ" );
        Player playerValour = new Player(0,1,"John", "Smith", "Canada", 20, "Striker", 0,0,0,0,0,0, "Valour U21" );
        Player playerYorkton = new Player(0,1,"John", "Smith", "Canada", 20, "Striker", 0,0,0,0,0,0, "Yorkton Wanderers" );
        Player playerManitoba = new Player(0,1,"John", "Smith", "Canada", 20, "Striker", 0,0,0,0,0,0, "Manitoba United" );
        Player playerSaskatoon = new Player(0,1,"John", "Smith", "Canada", 20, "Striker", 0,0,0,0,0,0, "Saskatoon Impact" );
        //Add the players to the database
        dbHelper = new DBHelper(this);
        dbHelper.addPlayer(playerRegina);
        dbHelper.addPlayer(playerWinnipeg);
        dbHelper.addPlayer(playerBrandon);
        dbHelper.addPlayer(playerMooseJaw);
        dbHelper.addPlayer(playerValour);
        dbHelper.addPlayer(playerYorkton);
        dbHelper.addPlayer(playerManitoba);
        dbHelper.addPlayer(playerSaskatoon);
        //Create the teams
        List<Player> rosterRegina = new ArrayList<>();
        rosterRegina.add(playerRegina);
        List<Player> rosterWinnipeg = new ArrayList<>();
        rosterWinnipeg.add(playerWinnipeg);
        List<Player> rosterBrandon = new ArrayList<>();
        rosterBrandon.add(playerBrandon);
        List<Player> rosterMooseJaw = new ArrayList<>();
        rosterMooseJaw.add(playerMooseJaw);
        List<Player> rosterValour = new ArrayList<>();
        rosterValour.add(playerValour);
        List<Player> rosterYorkton = new ArrayList<>();
        rosterYorkton.add(playerYorkton);
        List<Player> rosterManitoba = new ArrayList<>();
        rosterManitoba.add(playerManitoba);
        List<Player> rosterSaskatoon = new ArrayList<>();
        rosterSaskatoon.add(playerSaskatoon);
        // add the teams to the database
        Team FCRegina = new Team(1, rosterRegina, "FC Regina", "Regina", "Saskatchewan", 2600, R.drawable.reginalogo, 0,0,0,0,0,0,0,0,1);
        Team TeamWinnipeg = new Team(2, rosterWinnipeg, "Winnipeg FC", "Winnipeg", "Manitoba", 1818, R.drawable.winnipeglogo, 0,0,0,0,0,0,0,0,2);
        Team FCBrandon = new Team(3, rosterBrandon, "FC Brandon", "Victoria", "Manitoba", 1818, R.drawable.brandonlogo, 0,0,0,0,0,0,0,0,3);
        Team AFCMJ = new Team(4, rosterMooseJaw, "AFC MJ", "Victoria", "Saskatchewan", 1818, R.drawable.mjlogo, 0,0,0,0,0,0,0,0,4);
        Team ValourU21 = new Team(5, rosterValour, "Valour U21", "Victoria", "Manitoba", 1818, R.drawable.valourlogo, 0,0,0,0,0,0,0,0,5);
        Team YorktonWanderers = new Team(6, rosterYorkton, "Yorkton Wanderers", "Yorkton", "Saskatchewan", 1818, R.drawable.yorktonlogo, 0,0,0,0,0,0,0,0,6);
        Team ManitobaUnited = new Team(7, rosterManitoba, "Manitoba United", "Winnipeg", "Manitoba", 1818, R.drawable.manitobalogo, 0,0,0,0,0,0,0,0,7);
        Team SaskatoonImpact = new Team(8, rosterSaskatoon, "Saskatoon Impact", "Victoria", "Saskatchewan", 1818, R.drawable.saskatoonlogo, 0,0,0,0,0,0,0,0,8);
        //Add the teams to the database
        dbHelper.addTeam(FCRegina);
        dbHelper.addTeam(TeamWinnipeg);
        dbHelper.addTeam(FCBrandon);
        dbHelper.addTeam(AFCMJ);
        dbHelper.addTeam(ValourU21);
        dbHelper.addTeam(YorktonWanderers);
        dbHelper.addTeam(ManitobaUnited);
        dbHelper.addTeam(SaskatoonImpact);
        //Create the games
//        dbHelper.addGame(new Game(1, "05/03/2024", FCRegina, TeamWinnipeg, 0,0,"6:00", "Mosaic Stadium"));
        //set the layout
        standings = findViewById(R.id.rvStandings);
        teams = dbHelper.getAllTeams();
        standingsAdapter = new TeamAdapter(teams);
        standings.setAdapter(standingsAdapter);


        chooseTeam = findViewById(R.id.btnOptions);
        tvScoreboard = findViewById(R.id.tvScoreboard);
        tvStandings = findViewById(R.id.tvStandings);
        tvNews = findViewById(R.id.tvNews);

        chooseTeam.setOnClickListener(v -> {
            Intent intent = new Intent(LeagueMenuPage.this, LeagueSelectTeam.class);
            startActivity(intent);
        });
        tvScoreboard.setOnClickListener(v -> {
            Intent intent = new Intent(LeagueMenuPage.this, LeagueSchedualeView.class);
            startActivity(intent);
            Log.d("Scoreboard", "Going to scoreboard");
        });
        tvStandings.setOnClickListener(v -> {
            Intent intent = new Intent(LeagueMenuPage.this, LeagueStandingsPage.class);

            startActivity(intent);
            Log.d("Standings", "Going to standings");
        });
        tvNews.setOnClickListener(v -> {
            Intent intent = new Intent(LeagueMenuPage.this, LeagueNewsPage.class);
            startActivity(intent);
            Log.d("News", "Going to News");
        });
    }
    //TODO: Fully Create the databases and try to make them work by creating each team once on this page.
}