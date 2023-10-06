package com.example.appclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button login2main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login2main = findViewById(R.id.login_button);
        login2main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "Going To Menu", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(LoginActivity.this , MenuPage.class);
                startActivity(intent);

            }
        });

        getSupportActionBar().setTitle("Sign In");
    }
}