package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;



import androidx.appcompat.app.AppCompatActivity;

public class Score extends AppCompatActivity {
    TextView score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score);
        score=findViewById(R.id.score);
        Bundle b=getIntent().getExtras();
        score.setText( b.getString("score"));



    }
}
