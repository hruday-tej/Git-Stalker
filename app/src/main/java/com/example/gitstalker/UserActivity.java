package com.example.gitstalker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.gitstalker.model.GitHubUser;
import com.example.gitstalker.rest.APIClient;
import com.example.gitstalker.rest.GitHubUserEndPoints;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.Circle;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static java.security.AccessController.getContext;

public class UserActivity extends AppCompatActivity {


    private ImageView avatarImg;
    private TextView usernameTV;
    private TextView follwersTV;
    private TextView followingTV;
    private TextView logIn;
    private TextView email;
    private Button ownedrepos;

    ProgressBar progressBar;

    Bundle extras;
    String newString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        avatarImg = findViewById(R.id.avatar);
        usernameTV = findViewById(R.id.username);
        follwersTV = findViewById(R.id.followers);
        followingTV = findViewById(R.id.following);
        followingTV = findViewById(R.id.following);
        email = findViewById(R.id.email);
        ownedrepos = findViewById(R.id.ownedReposBtn);
        logIn = findViewById(R.id.logIn);

        extras = getIntent().getExtras();
        newString = extras.getString("STRING_I_NEED");

        progressBar = findViewById(R.id.spin_kit);
        Circle doubleBounce = new Circle();
        progressBar.setIndeterminateDrawable(doubleBounce);
        loadData();
    }

    private void loadData() {

        final GitHubUserEndPoints apiService = APIClient.getClient().create(GitHubUserEndPoints.class);

        Call<GitHubUser> call = apiService.getUser(newString);
        call.enqueue(new Callback<GitHubUser>() {
            @Override
            public void onResponse(Call<GitHubUser> call, Response<GitHubUser> response) {
                progressBar.setVisibility(View.GONE);
                if(response.body().getName() == null){
                    Toast.makeText(UserActivity.this,"Invalid Details", Toast.LENGTH_LONG);
                }
                else{
                    usernameTV.setText(response.body().getName());
                }

                follwersTV.setText(response.body().getFollowers()+"\n followers");
                followingTV.setText(response.body().getFollowing()+"\n following");
                logIn.setText(response.body().getLogin());
                email.setText(response.body().getEmail());

                String image = response.body().getAvatar();
                Picasso.get().load(image).into(avatarImg);
//                Glide.with(UserActivity.this)
//                        .load(image)
//                        .transform(new PositionedCropTransformation(UserActivity.this, 1, 0))
//                        .into(avatarImg);
            }

            @Override
            public void onFailure(Call<GitHubUser> call, Throwable t) {
                Toast.makeText(UserActivity.this,"Uh Oh! some error has occured", Toast.LENGTH_LONG).show();
            }
        });

    }
}