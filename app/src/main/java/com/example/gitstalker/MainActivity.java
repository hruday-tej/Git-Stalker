package com.example.gitstalker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.TintTypedArray;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button login;
    private EditText inputUsername;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = (Button)findViewById(R.id.login_github);
        inputUsername = (EditText)findViewById(R.id.git_username);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getUser();
            }
        });
    }

    private void getUser() {
        intent = new Intent(MainActivity.this, UserActivity.class);
        intent.putExtra("STRING_I_NEED", inputUsername.getText().toString());
        startActivity(intent);
    }
}