package com.example.gitstalker.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gitstalker.R;

import java.util.List;

public class ReposModel extends RecyclerView.Adapter<ReposModel.ReposViewHolder>{

    private List<GitHubRepo> repos;
    private int rowLayout;
    private Context context;

    public ReposModel(List<GitHubRepo> repos, int rowLayout, Context context) {
        this.setRepos(repos);
        this.setContext(context);
        this.setRowLayout(rowLayout);
    }

    public List<GitHubRepo> getRepos() {
        return repos;
    }

    public void setRepos(List<GitHubRepo> repos) {
        this.repos = repos;
    }

    public int getRowLayout() {
        return rowLayout;
    }

    public void setRowLayout(int rowLayout) {
        this.rowLayout = rowLayout;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ReposViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);

        return new ReposViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReposViewHolder holder, int position) {
        holder.repoName.setText(repos.get(position).getName());
        holder.repoDescription.setText(repos.get(position).getDescription());
        holder.repolanguage.setText(repos.get(position).getLanguage());
    }

    @Override
    public int getItemCount() {
        return repos.size();
    }

    public static class ReposViewHolder extends RecyclerView.ViewHolder{
        LinearLayout reposLayout;
        TextView repoName;
        TextView repoDescription;
        TextView repolanguage;

        public ReposViewHolder(@NonNull View itemView) {
            super(itemView);
            reposLayout = itemView.findViewById(R.id.repo_item_layout);
             repoName = itemView.findViewById(R.id.repoName);
             repoDescription = itemView.findViewById(R.id.repoDescription);
             repolanguage = itemView.findViewById(R.id.repoLanguage);
        }
    }
}
