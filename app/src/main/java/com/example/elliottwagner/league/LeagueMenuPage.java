package com.example.elliottwagner.league;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.Window;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elliottwagner.Game;
import com.example.elliottwagner.GameAdapter;
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
//Inspiration used included:
//OneFootball : https://images.ctfassets.net/furi30ndpl6w/3TmuAqZysNDsVtjFWIDBek/b62e8f8450863ee050cadcc000cbe67a/preroll.png
//SportNet App: https://play-lh.googleusercontent.com/rg4dF8U62eeE4-vvYIJayLAwrHNjst4zYTSideerCp0oy8rgcIocjTi4CkIjRMx62A=w526-h296-rw
//CPL App: https://play-lh.googleusercontent.com/Qri-Qm-KhjqRfnTfs7qTmneYGq9j4vNYRF8LKzHThzly7cWgC9qu4pbWgptldBOsVmjV=w526-h296-rw

public class LeagueMenuPage extends AppCompatActivity {
    //Declare the Button and textview
    Button chooseTeam;
    TextView tvScoreboard;
    TextView tvStandings;
    TextView tvNews;
    //Declare the recyclerview and webview
    RecyclerView standings;
    RecyclerView rvLeagueScoreboard;
    WebView webview;
    //Declare Database, adapter and arraylists
    DBHelper dbHelper;
    TeamAdapter standingsAdapter;
    GameAdapter scoreboardAdapter;
    ArrayList<Team> teams;
    ArrayList<Game> games;

    ArrayList<Integer> teamImages;


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
        dbHelper = new DBHelper(this);
        //Create the players
        Player playerRegina = new Player(0, 1, "John", "Smith", "Canada", 20, "Striker", 0, 0, 0, 0, 0, 0, "FC Regina");
        Player playerWinnipeg = new Player(0, 1, "John", "Smith", "Canada", 20, "Striker", 0, 0, 0, 0, 0, 0, "Winnipeg FC");
        Player playerBrandon = new Player(0, 1, "John", "Smith", "Canada", 20, "Striker", 0, 0, 0, 0, 0, 0, "FC Brandon");
        Player playerMooseJaw = new Player(0, 1, "John", "Smith", "Canada", 20, "Striker", 0, 0, 0, 0, 0, 0, "AFC MJ");
        Player playerValour = new Player(0, 1, "John", "Smith", "Canada", 20, "Striker", 0, 0, 0, 0, 0, 0, "Valour U21");
        Player playerYorkton = new Player(0, 1, "John", "Smith", "Canada", 20, "Striker", 0, 0, 0, 0, 0, 0, "Yorkton Wanderers");
        Player playerManitoba = new Player(0, 1, "John", "Smith", "Canada", 20, "Striker", 0, 0, 0, 0, 0, 0, "Manitoba United");
        Player playerSaskatoon = new Player(0, 1, "John", "Smith", "Canada", 20, "Striker", 0, 0, 0, 0, 0, 0, "Saskatoon Impact");



        //Add the players to the database
        dbHelper.addPlayer(playerRegina);
        dbHelper.addPlayer(playerWinnipeg);
        dbHelper.addPlayer(playerBrandon);
        dbHelper.addPlayer(playerMooseJaw);
        dbHelper.addPlayer(playerValour);
        dbHelper.addPlayer(playerYorkton);
        dbHelper.addPlayer(playerManitoba);
        dbHelper.addPlayer(playerSaskatoon);

        //Create the teams list of players
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

        //Create the images
        teamImages = new ArrayList<>();
        teamImages.add(R.drawable.reginalogo);
        teamImages.add(R.drawable.winnipeglogo);
        teamImages.add(R.drawable.brandonlogo);
        teamImages.add(R.drawable.mjlogo);
        teamImages.add(R.drawable.valourlogo);
        teamImages.add(R.drawable.yorktonlogo);
        teamImages.add(R.drawable.manitobalogo);
        teamImages.add(R.drawable.saskatoonlogo);

        // add the teams to the database
        Team FCRegina = new Team(1, rosterRegina, "FC Regina", "Regina", "Saskatchewan", 2600, R.drawable.reginalogo, 20, 0, 0, 0, 0, 0, 0, 0, 1);
        Team TeamWinnipeg = new Team(2, rosterWinnipeg, "Winnipeg FC", "Winnipeg", "Manitoba", 1818,  R.drawable.winnipeglogo, 10, 0, 0, 0, 0, 0, 0, 0, 2);
        Team FCBrandon = new Team(3, rosterBrandon, "FC Brandon", "Victoria", "Manitoba", 1818,  R.drawable.brandonlogo, 0, 4, 0, 0, 0, 0, 0, 0, 3);
        Team AFCMJ = new Team(4, rosterMooseJaw, "AFC MJ", "Victoria", "Saskatchewan", 1818,  R.drawable.mjlogo, 0, 0, 5, 0, 0, 0, 0, 0, 4);
        Team ValourU21 = new Team(5, rosterValour, "Valour U21", "Victoria", "Manitoba", 1818,  R.drawable.valourlogo, 0, 0, 0, 0, 0, 0, 0, 0, 5);
        Team YorktonWanderers = new Team(6, rosterYorkton, "Yorkton Wanderers", "Yorkton", "Saskatchewan", 1818,  R.drawable.yorktonlogo, 0, 0, 0, 0, 0, 0, 0, 0, 6);
        Team ManitobaUnited = new Team(7, rosterManitoba, "Manitoba United", "Winnipeg", "Manitoba", 1818,  R.drawable.manitobalogo, 0, 0, 0, 0, 0, 0, 0, 0, 7);
        Team SaskatoonImpact = new Team(8, rosterSaskatoon, "Saskatoon Impact", "Victoria", "Saskatchewan", 1818,  R.drawable.saskatoonlogo, 0, 0, 0, 0, 0, 0, 0, 0, 8);

        // fetch the existing teams

        // if no teams are fetched, add the new teams

            //Add the teams to the database
        if (dbHelper.getAllTeams().isEmpty()) {
            dbHelper.addTeam(FCRegina);
            dbHelper.addTeam(TeamWinnipeg);
            dbHelper.addTeam(FCBrandon);
            dbHelper.addTeam(AFCMJ);
            dbHelper.addTeam(ValourU21);
            dbHelper.addTeam(YorktonWanderers);
            dbHelper.addTeam(ManitobaUnited);
            dbHelper.addTeam(SaskatoonImpact);
        }
        // fetch the existing games
        List<Game> gamesList = dbHelper.getAllGames();
        // if no games are fetched, add the new games
        if (gamesList.isEmpty()) {
            dbHelper.addGame(new Game(1, "05/03/24", "FCRegina", "TeamWinnipeg", 0,0,"6:00", "Mosaic Stadium"));
            dbHelper.addGame(new Game(2, "05/03/24", "FCRegina", "FCBrandon", 0,0,"6:00", "Mosaic Stadium"));
            dbHelper.addGame(new Game(3, "05/04/24", "FCRegina", "AFCMJ", 0,0,"6:00", "Mosaic Stadium"));
        }

        //set the layouts
        standings = findViewById(R.id.rvStandings);
        rvLeagueScoreboard = findViewById(R.id.rvLeagueScoreboard);
        standings.setLayoutManager(new LinearLayoutManager(LeagueMenuPage.this));
        rvLeagueScoreboard.setLayoutManager(new LinearLayoutManager(LeagueMenuPage.this));

        //get the teams from the database
        teams = dbHelper.getAllTeams();
        //get the games from the database
        games = dbHelper.getAllGames();
        Log.d("League main page", "Teams: " + teams.toString());
        //Make a new list to show with only the top 4 teams
        ArrayList<Team> standingsList = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            standingsList.add(teams.get(i));
        }
        //Set the adapters
        scoreboardAdapter = new GameAdapter(games);
        rvLeagueScoreboard.setAdapter(scoreboardAdapter);
        standingsAdapter = new TeamAdapter(standingsList);
        standings.setAdapter(standingsAdapter);

        //Set the buttons
        chooseTeam = findViewById(R.id.btnOptions);
        tvScoreboard = findViewById(R.id.tvScoreboard);
        tvStandings = findViewById(R.id.tvStandings);
        tvNews = findViewById(R.id.tvNews);
        webview = findViewById(R.id.webView);
        //Load the webview with the league preview
        String data = "";
        data = "<HTML> " +
                "<BODY> " +
                "<H1>League Preview</H1> " +
                "<IMG SRC='https://images2.minutemediacdn.com/image/upload/c_crop,w_4515,h_2539,x_0,y_183/c_fill,w_720,ar_16:9,f_auto,q_auto,g_auto/images/GettyImages/mmsport/90min_en_international_web/01ghvfc0eqe3qaz4remn.jpg' WIDTH='100%' HEIGHT='50%'> " +
                "<P>With the league starting soon, lets take a look at the preview of the league and upcoming matches.</P> " +
                "</BODY> " +
                "</HTML>";

        webview.loadData(data, "text/html", "UTF-8");
        //Set the onclick listeners
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
}