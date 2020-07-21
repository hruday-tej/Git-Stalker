package com.example.gitstalker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.gitstalker.model.GitHubRepo;
import com.example.gitstalker.model.ReposModel;
import com.example.gitstalker.rest.APIClient;
import com.example.gitstalker.rest.GitHubUserEndPoints;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repositories extends AppCompatActivity {


    String recievedUserName;
    TextView usernameTV;
    RecyclerView recyclerView;
    List<GitHubRepo> myDataSource = new ArrayList<>();
    RecyclerView.Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repositories);

        Bundle bundle = getIntent().getExtras();
        recievedUserName = bundle.getString("username");

        usernameTV = findViewById(R.id.userNameTV);
        usernameTV.setText(recievedUserName);
        recyclerView = findViewById(R.id.repos_recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ReposModel(myDataSource, R.layout.list_item_repo, getApplicationContext());
        recyclerView.setAdapter(adapter);
        loadRepositories();
    }

    private void loadRepositories() {

        GitHubUserEndPoints apiService = APIClient.getClient().create(GitHubUserEndPoints.class);
        Call<List<GitHubRepo>> call = apiService.getRepo(recievedUserName);
        call.enqueue(new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                myDataSource.clear();
                myDataSource.addAll(response.body());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {

            }
        });

    }
}