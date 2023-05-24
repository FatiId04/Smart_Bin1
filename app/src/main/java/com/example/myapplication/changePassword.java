package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class changePassword extends AppCompatActivity {
    EditText username, password;
    Button update;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot1);
        username = findViewById(R.id.input9);
        password = findViewById(R.id.input10);
        update = findViewById(R.id.button3);


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //And only then we call this
                DBHelper myDB = new DBHelper(changePassword.this);
                String user = username.getText().toString();
                String pass= password.getText().toString();
                myDB.updatePass(user, pass);
                username.setText("");
                password.setText("");

            }
        });

    }
}
