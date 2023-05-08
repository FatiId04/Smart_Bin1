package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class updatePassword extends AppCompatActivity {

    EditText username, password;
    Button update;
    TextView login ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot);
        username = findViewById(R.id.input9);
        password = findViewById(R.id.input10);
        update = findViewById(R.id.button3);
        login=findViewById(R.id.login);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //And only then we call this
                DBHelper myDB = new DBHelper(updatePassword.this);
                String user = username.getText().toString();
                String pass= password.getText().toString();
                myDB.updatePass(user, pass);
                username.setText("");
                password.setText("");

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

            }
        });
    }
}
