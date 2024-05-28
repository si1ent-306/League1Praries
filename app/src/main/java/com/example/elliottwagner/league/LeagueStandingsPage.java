package com.example.elliottwagner.league;

import android.os.Bundle;
import android.view.Window;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.elliottwagner.R;

import java.util.Objects;

public class LeagueStandingsPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_league_standings_page);
        //will hide the title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // hide the title bar
        Objects.requireNonNull(getSupportActionBar()).hide();
    }
    //TODO: Using streams, create the standings where the teams are sorted by their standings
}