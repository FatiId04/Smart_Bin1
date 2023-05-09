package com.example.cleanspaceapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SmartRecyclingAssistant extends AppCompatActivity {
    TextView tv1,tv2;
    Button button3;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.smartrecyclingassistant);
            tv1=findViewById(R.id.tv1);
            tv2=findViewById(R.id.tv2);
            button3=findViewById(R.id.button3);

        button3.setOnClickListener((evt) -> {
            finish();
        });

    }

}
