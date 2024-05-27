package com.example.elliottwagner.league;

import android.os.Bundle;
import android.view.Window;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.elliottwagner.R;
import com.example.elliottwagner.team.DBHelper;
import com.example.elliottwagner.team.Player;
import com.example.elliottwagner.team.Roster;
import com.example.elliottwagner.team.Team;

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
        // add some teams to the database
        DBHelper dbHelper = new DBHelper(this);
        dbHelper.addTeam(new Team(1, new ArrayList<>(
                new Player(1, 1, "John", "Smith", "Canada", 20, "Goalkeeper", 190, 190, "FC Regina" ),
                new Player(2, 2, "John", "Smith", "Canada", 20, "Defender", 190, 190, "FC Regina" ),
                new Player(3, 3, "John", "Smith", "Canada", 20, "Defender", 190, 190, "FC Regina" ),
                new Player(4, 4, "John", "Smith", "Canada", 20, "Defender", 190, 190, "FC Regina" ),
                new Player(5, 5, "John", "Smith", "Canada", 20, "Defender", 190, 190, "FC Regina" ),
                new Player(6, 6, "John", "Smith", "Canada", 20, "Defender", 190, 190, "FC Regina" ),
                new Player(7, 7, "John", "Smith", "Canada", 20, "Defender", 190, 190, "FC Regina" ),
                new Player(8, 8, "John", "Smith", "Canada", 20, "Defender", 190, 190, "FC Regina" ),
                new Player(9, 9, "John", "Smith", "Canada", 20, "Defender", 190, 190, "FC Regina" ),
                new Player(10, 10, "John", "Smith", "Canada", 20, "Defender", 190, 190, "FC Regina" ),
                new Player(11, 11, "John", "Smith", "Canada", 20, "Defender", 190, 190, "FC Regina" )

        ), "FC Regina", "Regina", "Saskatchewan", "Green", R.drawable.reginalogo, 0,0,0,0,0,0,0,0,1 ));
        dbHelper.addTeam(new Team(2, new ArrayList<>(), "Winnipeg FC", "Winnipeg", "Manitoba", "Blue", R.drawable.winnipeglogo, 0,0,0,0,0,0,0,0,2 ));
        dbHelper.addTeam(new Team(3, new ArrayList<>(), "FC Brandon", "Victoria", "Manitoba", "Blue", R.drawable.brandonlogo, 0,0,0,0,0,0,0,0,3 ));
        dbHelper.addTeam(new Team(4, new ArrayList<>(), "AFC MJ", "Victoria", "Saskatchewan", "Blue", R.drawable.mjlogo, 0,0,0,0,0,0,0,0,4 ));
        dbHelper.addTeam(new Team(5, new ArrayList<>(), "Valour U21", "Victoria", "Manitoba", "Blue", R.drawable.valourlogo, 0,0,0,0,0,0,0,0,5 ));
        dbHelper.addTeam(new Team(6, new ArrayList<>(), "Yorkton Wanderers", "Yorkton", "Saskatchewan", "Blue", R.drawable.yorktonlogo, 0,0,0,0,0,0,0,0,6 ));
        dbHelper.addTeam(new Team(7, new ArrayList<>(), "Manitoba United", "Winnipeg", "Manitoba", "Blue", R.drawable.manitobalogo, 0,0,0,0,0,0,0,0,7 ));
        dbHelper.addTeam(new Team(8, new ArrayList<>(), "Saskatoon Impact", "Victoria", "Saskatchewan", "Blue", R.drawable.saskatoonlogo, 0,0,0,0,0,0,0,0,8 ));

    }
}