package com.example.elliottwagner.league;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elliottwagner.Game;
import com.example.elliottwagner.GameAdapter;
import com.example.elliottwagner.R;
import com.example.elliottwagner.team.DBHelper;

import java.util.ArrayList;
import java.util.Objects;

public class LeagueSchedualeView extends AppCompatActivity {
    private static final String MY_NOTIFICATION_CHANNEL_ID = "my_notification_channel";
    Button button;
    private NotificationManager notificationManager;
    RecyclerView recyclerView;
    DBHelper dbHelper;
    ArrayList<Game> games;
    GameAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //will hide the title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // hide the title bar
        Objects.requireNonNull(getSupportActionBar()).hide();
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_league_scheduale_view);
        //get the notification button
        button = findViewById(R.id.btnNotification);
        //get the notification manager
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        button.setOnClickListener(v -> {
            Log.d("Notification Clicked", "click detected");
            //Make Notification
            showNotification();
        });
        //get the recycler view
        recyclerView = findViewById(R.id.rvLeagueSchedule);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        dbHelper = new DBHelper(this);
        games = dbHelper.getAllGames();

        adapter = new GameAdapter(games);
        recyclerView.setAdapter(adapter);
    }
    private void showNotification() {
        //Create notification
        Intent intent = new Intent(
                Intent.ACTION_VIEW,
                Uri.parse("http://www.youtube.com/@league1canada298"));
        PendingIntent pendingIntent = PendingIntent.getActivity(LeagueSchedualeView.this, 1, intent, PendingIntent.FLAG_IMMUTABLE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, MY_NOTIFICATION_CHANNEL_ID);
        //Build notification
        builder.setContentTitle("GAME ALERT");
        builder.setContentText("A game about to start! Click to go to the League 1 Canada Youtube Channel");
        builder.setAutoCancel(true);
        builder.setContentIntent(pendingIntent);
        builder.setSmallIcon(R.drawable.leagueoneprairies);
        //Show notification
        NotificationChannel notificationChannel = new NotificationChannel(MY_NOTIFICATION_CHANNEL_ID, "Game Notification", NotificationManager.IMPORTANCE_DEFAULT);
        notificationManager.createNotificationChannel(notificationChannel);
        notificationManager.notify(1, builder.build());
    }

}