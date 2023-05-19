package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);


                ImageButton assistantBtn = findViewById(R.id.image_button1);
                ImageButton locateBtn = findViewById(R.id.image_button2);
                ImageButton learnBtn = findViewById(R.id.image_button3);
                ImageButton scoreBtn = findViewById(R.id.score);
                ImageButton profileBtn = findViewById(R.id.profile);
                ImageButton settingBtn = findViewById(R.id.sett);

                TextView hi_username=findViewById(R.id.hi_username);
                 Bundle b=getIntent().getExtras();
                 hi_username.setText("Hi \t"+ b.getString("user"));

                assistantBtn.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(HomeActivity.this, SmartRecyclingAssistant.class));
                    }
                });

                locateBtn.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(HomeActivity.this, Locate.class));
                    }
                });

                learnBtn.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(HomeActivity.this, LearnPage.class));
                    }
                });
                scoreBtn.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(HomeActivity.this, ScorePage.class));
                    }
                });
                profileBtn.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(HomeActivity.this, ProfilePage.class));
                    }
                });
                settingBtn.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(HomeActivity.this, SettingPage.class));
                    }
                });
            }
        }


