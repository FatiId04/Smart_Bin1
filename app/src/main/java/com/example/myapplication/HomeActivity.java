package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


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
                 String username =b.getString("user");
                 hi_username.setText("Hi \t"+ username);

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
                       openScore();
                    }
                });
                profileBtn.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        openProfile();
                    }
                });
                settingBtn.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(HomeActivity.this, SettingPage.class));
                    }
                });
            }
            public void openProfile(){
                TextView hi_username=findViewById(R.id.hi_username);
                Bundle b=getIntent().getExtras();
                String username =b.getString("user");
                hi_username.setText("Hi \t"+ username);
                Intent intent1 = new Intent(this,ProfilePage.class);
                Bundle b1= new Bundle();
                b1.putString("user1",username.toString());
                intent1.putExtras(b1);
                startActivity(intent1);
            }
    public void openScore(){
        Bundle b=getIntent().getExtras();
        String username =b.getString("user");
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(HomeActivity.this);
        String url ="http://192.168.43.195:5000/get_score/"+username;

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Intent intent1 = new Intent(HomeActivity.this,Score.class);
                        Bundle b1= new Bundle();
                        b1.putString("score",response);
                        intent1.putExtras(b1);
                        startActivity(intent1);
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(HomeActivity.this,"Unreachable",Toast.LENGTH_SHORT ).show();
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    }




