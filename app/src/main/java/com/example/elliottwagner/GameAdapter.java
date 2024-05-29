package com.example.elliottwagner;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elliottwagner.league.TeamAdapter;

import java.util.ArrayList;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.ViewHolder> {
    ArrayList<Game> games;
    public GameAdapter(ArrayList<Game> games) {
        this.games = games;
    }

    @NonNull
    @Override
    public GameAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.schedule_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GameAdapter.ViewHolder holder, int position) {
        Game game = games.get(position);
        holder.gameID.setText(game.getGameID());
        holder.homeTeam.setText(game.getHomeTeam().getName());
        holder.awayTeam.setText(game.getAwayTeam().getName());
        holder.date.setText(game.getDateOfGame());
        holder.time.setText(game.getStartTime());
        holder.stadium.setText(game.getStadium());
        holder.streamLink.setText("@string/streamLink");


    }

    @Override
    public int getItemCount() {
        return games.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView homeTeam;
        TextView awayTeam;
        TextView date;
        TextView time;
        TextView stadium;
        TextView gameID;
        TextView streamLink;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            gameID = itemView.findViewById(R.id.tvGameID);
            homeTeam = itemView.findViewById(R.id.tvHomeTeam);
            awayTeam = itemView.findViewById(R.id.tvAwayTeam);
            date = itemView.findViewById(R.id.tvDate);
            time = itemView.findViewById(R.id.tvTime);
            stadium = itemView.findViewById(R.id.tvStadium);
            streamLink = itemView.findViewById(R.id.tvStreamLink);
        }
    }
}
