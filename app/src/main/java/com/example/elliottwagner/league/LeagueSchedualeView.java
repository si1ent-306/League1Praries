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

import com.example.elliottwagner.R;

import java.util.Objects;

public class LeagueSchedualeView extends AppCompatActivity {
    private static final String MY_NOTIFICATION_CHANNEL_ID = "my_notification_channel";
    Button button;
    private NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //will hide the title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // hide the title bar
        Objects.requireNonNull(getSupportActionBar()).hide();
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_league_scheduale_view);
        button = findViewById(R.id.btnNotification);
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        button.setOnClickListener(v -> {
            Log.d("Notification Clicked", "click detected");
            showNotification();
        });
        //TODO: Create a recycler view for the games

    }
    //TODO: Create a notifiacation simulation for the game on the menu view
    private void showNotification() {
        Intent intent = new Intent(
                Intent.ACTION_VIEW,
                Uri.parse("http://www.youtube.com/@league1canada298"));
        PendingIntent pendingIntent = PendingIntent.getActivity(LeagueSchedualeView.this, 1, intent, PendingIntent.FLAG_IMMUTABLE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, MY_NOTIFICATION_CHANNEL_ID);
        builder.setContentTitle("GAME ALERT");
        builder.setContentText("A game about to start! Click to go to the League 1 Canada Youtube Channel");
        builder.setAutoCancel(true);
        builder.setContentIntent(pendingIntent);
        builder.setSmallIcon(R.drawable.leagueoneprairies);
        NotificationChannel notificationChannel = new NotificationChannel(MY_NOTIFICATION_CHANNEL_ID, "Game Notification", NotificationManager.IMPORTANCE_DEFAULT);
        notificationManager.createNotificationChannel(notificationChannel);
        notificationManager.notify(1, builder.build());
    }
    //TODO: Make a recylcer view for games based off of the game database

}