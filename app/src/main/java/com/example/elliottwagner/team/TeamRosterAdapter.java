package com.example.elliottwagner.team;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elliottwagner.R;

import java.util.ArrayList;

public class TeamRosterAdapter extends RecyclerView.Adapter<TeamRosterAdapter.ViewHolder>{
    ArrayList<Player> players;
    public TeamRosterAdapter(ArrayList<Player> players) {
        this.players = players;
    }


    @NonNull
    @Override
    public TeamRosterAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.player_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamRosterAdapter.ViewHolder holder, int position) {
        holder.tvPlayerName.setText(players.get(position).getFullName());
        holder.tvPlayerPosition.setText(players.get(position).getPosition());
        holder.tvPlayerNumber.setText(players.get(position).getNumber());
        holder.tvPlayerHeight.setText(players.get(position).getHeight());
        holder.tvPlayerWeight.setText(players.get(position).getWeight());
        holder.tvPlayerCountry.setText(players.get(position).getCountry());
        holder.tvPlayerTeam.setText(players.get(position).getTeam());
        holder.tvPlayerAge.setText(players.get(position).getAge());
        holder.ivPlayerImage.setImageResource(R.drawable.emptyplayerimg);
    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvPlayerName;
        ImageView ivPlayerImage;
        TextView tvPlayerPosition;
        TextView tvPlayerNumber;

        TextView tvPlayerHeight;
        TextView tvPlayerWeight;
        TextView tvPlayerCountry;
        TextView tvPlayerTeam;
        TextView tvPlayerAge;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPlayerName = itemView.findViewById(R.id.tvPlayerName);
            ivPlayerImage = itemView.findViewById(R.id.ivPlayerImage);
            tvPlayerPosition = itemView.findViewById(R.id.tvPosition);
            tvPlayerNumber = itemView.findViewById(R.id.tvNumber);
            tvPlayerHeight = itemView.findViewById(R.id.tvHeight);
            tvPlayerCountry = itemView.findViewById(R.id.tvCountry);
            tvPlayerTeam = itemView.findViewById(R.id.tvTeam);
            tvPlayerAge = itemView.findViewById(R.id.tvAge);
        }
    }
}
