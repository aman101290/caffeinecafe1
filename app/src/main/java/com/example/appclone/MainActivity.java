package com.example.appclone;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button login;
    Button register;
    Button skipbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        login = findViewById(R.id.btn_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Login has been clicked", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this , LoginActivity.class);
                startActivity(intent);

            }
        });

        register = findViewById(R.id.btn_register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Register New Account", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this , Signup.class);
                startActivity(intent);

            }
        });

        skipbutton = findViewById(R.id.skip_button);

        skipbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Going to Menu", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this , MenuPage.class);
                startActivity(intent);

            }
        });

        getSupportActionBar().setTitle("Welcome To Caffeine Cafe");
    }
}