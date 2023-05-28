package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;




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
