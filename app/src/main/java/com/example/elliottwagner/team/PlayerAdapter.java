package com.example.elliottwagner.team;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elliottwagner.R;

import java.util.ArrayList;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder> {
    private final ArrayList<Player> players;
    private Player player;

    public Player getPlayer() {
        return player;
    }

    public PlayerAdapter(ArrayList<Player> players) {
        this.players = players;
    }


    @NonNull
    @Override
    public PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PlayerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.player_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerViewHolder holder, int position) {
        holder.tvPlayerName.setText(players.get(position).getFullName());
        holder.tvPosition.setText(players.get(position).getPosition());
        holder.tvAge.setText(players.get(position).getAge());
        holder.tvTeam.setText(players.get(position).getTeam());
        holder.tvHeight.setText(players.get(position).getHeight());
        holder.tvNumber.setText(players.get(position).getNumber());
        holder.itemView.setOnClickListener(v -> {
            player = players.get(position);

        });
    }

    @Override
    public int getItemCount() {return players.size();}

    public static class PlayerViewHolder extends RecyclerView.ViewHolder {

        TextView tvPlayerName;

        TextView tvPosition;

        TextView tvAge;

        TextView tvTeam;

        TextView tvHeight;

        TextView tvNumber;
        public PlayerViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPlayerName = itemView.findViewById(R.id.tvPlayerName);
            tvPosition = itemView.findViewById(R.id.tvPosition);
            tvAge = itemView.findViewById(R.id.tvAge);
            tvTeam = itemView.findViewById(R.id.tvTeam);
            tvHeight = itemView.findViewById(R.id.tvHeight);
            tvPosition = itemView.findViewById(R.id.tvPosition);
            tvNumber = itemView.findViewById(R.id.tvNumber);

        }
    }
}
