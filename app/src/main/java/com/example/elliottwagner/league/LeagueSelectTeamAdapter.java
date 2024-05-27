package com.example.elliottwagner.league;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elliottwagner.R;
import com.example.elliottwagner.team.Team;

import java.util.ArrayList;

public class LeagueSelectTeamAdapter extends RecyclerView.Adapter<LeagueSelectTeamAdapter.LeagueSelectTeamViewHolder> {
    private final ArrayList<Team> teams;
    private OnItemClickListener listener;


    public LeagueSelectTeamAdapter(ArrayList<Team> teams, OnItemClickListener listener)  {
        this.teams = teams;
        this.listener = listener;
    }

    @NonNull
    @Override
    public LeagueSelectTeamAdapter.LeagueSelectTeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.select_team_item, parent, false);
        return new LeagueSelectTeamViewHolder(view, (OnItemClickListener) listener);
    }

    @Override
    public void onBindViewHolder(@NonNull LeagueSelectTeamAdapter.LeagueSelectTeamViewHolder holder, int position) {
        holder.teamName.setText(teams.get(position).getName());
        holder.teamLogo.setImageResource(teams.get(position).getLogo());
    }


    @Override
    public int getItemCount() {
        return teams.size();
    }


    public static class LeagueSelectTeamViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView teamLogo;
        TextView teamName;
        OnItemClickListener listener;

        public LeagueSelectTeamViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            teamLogo = itemView.findViewById(R.id.ivTeamLogo);
            teamName = itemView.findViewById(R.id.tvTeamName);
            this.listener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onItemClick(getAdapterPosition());
        }
    }
    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
