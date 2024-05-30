package com.example.elliottwagner.league;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elliottwagner.R;
import com.example.elliottwagner.team.Team;

import java.util.ArrayList;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.ViewHolder> {
    private final ArrayList<Team> teams;
    private final ArrayList<Object> teamImages;

    public TeamAdapter(ArrayList<Team> teams) {
        this.teams = teams;

        teamImages = new ArrayList<>();
        teamImages.add(R.drawable.reginalogo);
        teamImages.add(R.drawable.winnipeglogo);
        teamImages.add(R.drawable.brandonlogo);
        teamImages.add(R.drawable.mjlogo);
        teamImages.add(R.drawable.valourlogo);
        teamImages.add(R.drawable.yorktonlogo);
        teamImages.add(R.drawable.manitobalogo);
        teamImages.add(R.drawable.saskatoonlogo);
        // int reginaImage = teamImages.get(teamImages.indexOf(R.drawable.reginalogo));

    }

    @NonNull
    @Override
    public TeamAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.team_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamAdapter.ViewHolder holder, int position) {
        Team team = teams.get(position);
        holder.teamStanding.setText(String.valueOf(team.getStanding()));
        holder.teamLogo.setImageResource(team.getLogo());
        holder.teamWins.setText(String.valueOf(team.getWins()));
        holder.teamLosses.setText(String.valueOf(team.getLosses()));
        holder.teamDraws.setText(String.valueOf(team.getDraws()));
        holder.teamPoints.setText(String.valueOf(team.getPoints()));
        holder.teamGoalsFor.setText(String.valueOf(team.getGoalsScored()));
        holder.teamGoalsAgainst.setText(String.valueOf(team.getGoalsAllowed()));
        holder.teamGoalDifference.setText(String.valueOf(team.getGoalDifference()));
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView teamStanding;
        ImageView teamLogo;
        TextView teamWins;
        TextView teamLosses;
        TextView teamDraws;
        TextView teamPoints;
        TextView teamGoalsFor;
        TextView teamGoalsAgainst;
        TextView teamGoalDifference;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            teamStanding = itemView.findViewById(R.id.tvTeamStanding);
            teamLogo = itemView.findViewById(R.id.ivTeamLogo);
            teamWins = itemView.findViewById(R.id.tvWins);
            teamLosses = itemView.findViewById(R.id.tvLosses);
            teamDraws = itemView.findViewById(R.id.tvDraws);
            teamPoints = itemView.findViewById(R.id.tvPoints);
            teamGoalsFor = itemView.findViewById(R.id.tvGoalsFor);
            teamGoalsAgainst = itemView.findViewById(R.id.tvGoalsAgainst);
            teamGoalDifference = itemView.findViewById(R.id.tvGoalDifference);
        }
    }
}
