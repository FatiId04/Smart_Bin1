package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText username,password;
    Button login;
    TextView signup,forgot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        username=findViewById(R.id.input1);
        password=findViewById(R.id.input2);
        login=findViewById(R.id.button1);
        signup=findViewById(R.id.sign_up);
        forgot=findViewById(R.id.forgot);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DBHelper DB = new DBHelper(LoginActivity.this);
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(LoginActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if(checkuserpass==true){
                        Toast.makeText(LoginActivity.this, "Sign in successfully", Toast.LENGTH_SHORT).show();
                        openHome();
                    }else{
                        Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
                username.setText("");
               password.setText("");

            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(getApplicationContext(), SignUp.class);
                startActivity(intent);

            }
        });
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(getApplicationContext(), updatePassword.class);
                startActivity(intent);

            }
        });
    }
    void openHome(){
        Intent intent = new Intent(this,HomeActivity.class);
        Bundle b= new Bundle();
        b.putString("user",username.getText().toString());
        intent.putExtras(b);
        startActivity(intent);
    }
}