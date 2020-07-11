package com.example.booking.Register;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Database;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.booking.DateBaseLayer.DateBase;
import com.example.booking.MainActivity;
import com.example.booking.R;

import java.sql.Time;

public class Register extends AppCompatActivity {
    EditText firstName,lastName,email,password,passwordAgain,phoneNumber;
    Button btnRegister,btnLogin;
    DateBase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db=new DateBase(this);
        setContentView(R.layout.activity_register);
        firstName=(EditText)findViewById(R.id.editTxtFirstNameRegisterActivity);
        lastName=(EditText)findViewById(R.id.editTxtLastNameRegisterActivity);
        email=(EditText)findViewById(R.id.editTxtEmailRegisterActivity);
        password=(EditText)findViewById(R.id.editTxtPasswordRegisterActivity);
        passwordAgain=(EditText)findViewById(R.id.editTxtPasswordAgainRegisterActivity);
        phoneNumber=(EditText)findViewById(R.id.editTxtPhoneRegisterActivity);
        btnRegister=(Button)findViewById(R.id.btnRegisterRegisterActivity);
        btnLogin=(Button)findViewById(R.id.btnLoginRegisterActivity);




        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _firstName=firstName.getText().toString();
                String _lastName=lastName.getText().toString();
                String _email=email.getText().toString();
                String _password=password.getText().toString();
                String _passwordAgain=passwordAgain.getText().toString();
                String _phoneNumber=phoneNumber.getText().toString();

                if (_firstName.equals("")||_lastName.equals("")||_email.equals("")||_password.equals("")||_phoneNumber.equals("")){
                    Toast.makeText(getApplicationContext(),"Filds are empy",Toast.LENGTH_SHORT).show();
                }
                else{
                    if(_password.equals(_passwordAgain)){
                        Boolean chkemail=db.chkemail(_email);
                        if(chkemail==true){
                            Boolean insert=db.insert(_email,_firstName,_lastName,_password,_phoneNumber);
                            if(insert==true){
                                Toast.makeText(getApplicationContext(),"Registered Successfully",Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
                            }
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Email is Already exists",Toast.LENGTH_SHORT).show();
                        }
                    }
                    Toast.makeText(getApplicationContext(),"Password do not match",Toast.LENGTH_SHORT).show();
                }

            }

        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerInten=new Intent(Register.this,MainActivity.class);
                startActivity(registerInten);

            }
        });
    }
}