package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SmartRecyclingAssistant extends AppCompatActivity {
    TextView textView2,textView3;

    ImageView imageView2;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.smartrecyclingassistant);
            textView2=findViewById(R.id.textView2);
            textView3=findViewById(R.id.textView3);
            imageView2=findViewById(R.id.imageView2);

       

    }

}
