package com.example.booking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.booking.DateBaseLayer.DateBase;
import com.example.booking.Register.Register;

public class MainActivity extends AppCompatActivity {
    private Button btnRegister,btnLogin;
    EditText email,password;
    DateBase db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=new DateBase(this);
        email=(EditText)findViewById(R.id.welcomeEmail);
        password=(EditText)findViewById(R.id.welcomePassword);
        btnLogin=(Button) findViewById(R.id.welcomeLogin);
        btnRegister=(Button)findViewById(R.id.welcomeRegister);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _email=email.getText().toString();
                String _password=password.getText().toString();
                Boolean chkemailpass= db.emailpassword(_email,_password);
                if(chkemailpass==true){
                    Toast.makeText(getApplicationContext(),"Successfully Login",Toast.LENGTH_SHORT).show();
                    Intent registerInten=new Intent(MainActivity.this, WelcomeBookApp.class);
                    startActivity(registerInten);
                    finish();
                }
                else{
                    Toast.makeText(getApplicationContext(),"wrong email or password",Toast.LENGTH_SHORT).show();
                }
            }
        });


        //Register
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerInten=new Intent(MainActivity.this,Register.class);
                startActivity(registerInten);
            }
        });
    }





}