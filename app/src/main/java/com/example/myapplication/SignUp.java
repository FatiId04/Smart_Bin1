package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {


    EditText firstName,lastName,username,password,confirmPassword;
    Button signup;
    TextView login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        firstName=findViewById(R.id.input1);
        lastName=findViewById(R.id.input2);
        username=findViewById(R.id.input3);
        password=findViewById(R.id.input4);
        confirmPassword=findViewById(R.id.input5);
        signup=findViewById(R.id.button1);
        login=findViewById(R.id.login);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String first = firstName.getText().toString();
                String last = lastName.getText().toString();
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = confirmPassword.getText().toString();
                DBHelper DB = new DBHelper(SignUp.this);


                if(user.equals("")||pass.equals("")||repass.equals(""))
                    Toast.makeText(SignUp.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    if(pass.length()>5){
                        if(pass.equals(repass)){
                            Boolean checkuser = DB.checkusername(user);
                            if(checkuser==false){
                                Boolean insert = DB.insertData(first,last,user, pass);
                                if(insert==true){
                                    Toast.makeText(SignUp.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                    openHome();
                                }else{
                                    Toast.makeText(SignUp.this, "Registration failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else{
                                Toast.makeText(SignUp.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(SignUp.this, "Passwords not matching", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(SignUp.this, "Password should have at least 6 characters", Toast.LENGTH_SHORT).show();
                    }
                }
                lastName.setText("");
                firstName.setText("");
                username.setText("");
                password.setText("");
                confirmPassword.setText("");

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);

            }
        });

    }
    void openHome(){
        Intent intent  = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
