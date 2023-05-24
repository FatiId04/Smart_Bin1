package com.example.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.google.android.material.button.MaterialButton;

public class ProfilePage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        TextView first=findViewById(R.id.first_name1);
        TextView last=findViewById(R.id.last_name1);
        TextView user=findViewById(R.id.username1);
        Button change =findViewById(R.id.button);
        Bundle b=getIntent().getExtras();
        user.setText( b.getString("user1"));
        DBHelper DB= new DBHelper(ProfilePage.this);
        last.setText(DB.getLastName(b.getString("user1")));
        first.setText(DB.getFirstName(b.getString("user1")));
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfilePage.this, changePassword.class));

            }
        });


    }


}
