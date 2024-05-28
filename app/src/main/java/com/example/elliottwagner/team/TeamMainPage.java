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
import androidx.recyclerview.widget.RecyclerView;

import com.example.elliottwagner.R;
import com.example.elliottwagner.league.LeagueMenuPage;
import com.example.elliottwagner.league.LeagueSelectTeam;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //will hide the title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // hide the title bar
        Objects.requireNonNull(getSupportActionBar()).hide();
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_team_main_page);

        extras = getIntent().getExtras();
        Team team = Objects.requireNonNull(extras).getParcelable("team");

        view = findViewById(R.id.main);
        teamLogo = findViewById(R.id.ivTeamLogo);
        tvRoster = findViewById(R.id.tvTeamRoster);
        teamLogo.setImageResource(Objects.requireNonNull(team).getLogo());
        switch (team.getName()){
            case "Regina":
                view.setBackgroundColor(getResources().getColor(R.color.fcReginaBlue));
                break;
            case "Saskatoon":
                view.setBackgroundColor(getResources().getColor(R.color.saskatoonGreen));

                break;
            case "Winnipeg":
                view.setBackgroundColor(getResources().getColor(R.color.fcWinnipegRed));
                break;
        }
        Log.d("TeamMainPage", "onCreate: " + team.getName());
        Log.d("TeamMainPage", "onCreate: " + team.getColor());
        rvTeamRoster = findViewById(R.id.rvTeamRoster);

        chooseTeam = findViewById(R.id.btnOptions);
        tvRoster = findViewById(R.id.tvTeamRoster);
        tvTeamScheduale = findViewById(R.id.tvScoreboard);
        tvTeamNews = findViewById(R.id.tvTeamNews);

        chooseTeam.setOnClickListener(v -> {
            Intent intent = new Intent(TeamMainPage.this, LeagueSelectTeam.class);
            startActivity(intent);
        });
        tvRoster.setOnClickListener(v -> {
            Intent intent = new Intent(TeamMainPage.this, TeamRosterPage.class);
            intent.putExtra("team", (Parcelable) team);
            startActivity(intent);
            Log.d("TeamMainPage", "onCreate: " + team.getName());
        });
        tvTeamScheduale.setOnClickListener(v -> {
            Intent intent = new Intent(TeamMainPage.this, TeamSchedualePage.class);
            intent.putExtra("team", (Parcelable) team);
            startActivity(intent);
            Log.d("TeamMainPage", "onCreate: " + team.getName());
        });
        tvTeamNews.setOnClickListener(v -> {
            Intent intent = new Intent(TeamMainPage.this, TeamNewsPage.class);
            intent.putExtra("team", (Parcelable) team);
            startActivity(intent);
            Log.d("TeamMainPage", "onCreate: " + team.getName());
        });
    }
    //TODO: Receive the team that was selected and display the logo on the top, and change the color
}