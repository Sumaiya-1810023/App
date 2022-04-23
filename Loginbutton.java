package com.example.bookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Loginbutton extends AppCompatActivity implements View.OnClickListener{
    private Button logindoctor;
    private Button loginpatient;
    private Button signUpdoctor;
    private Button signUppatient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginbutton);
        signUpdoctor = (Button) findViewById(R.id.signupDoctorID);
        signUppatient = (Button) findViewById(R.id.signupPatientID);
        loginpatient =(Button)findViewById(R.id.LoginPatientID);
        logindoctor  =  (Button) findViewById(R.id.LoginDoctorID);
        logindoctor.setOnClickListener(this);
        loginpatient.setOnClickListener(this);
        signUpdoctor.setOnClickListener(this);
        signUppatient.setOnClickListener(this);
    }
    public void onClick(View v)
    {
        if(v.getId()==R.id.signupDoctorID) {
            Intent intent = new Intent(Loginbutton.this,  RegisterDoctorActivity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.signupPatientID) {
            Intent intent = new Intent(Loginbutton.this,RegisterPatientActivity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.LoginDoctorID) {
            Intent intent = new Intent(Loginbutton.this,LoginDoctorActivity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.LoginPatientID) {
            Intent intent = new Intent(Loginbutton.this,LoginPatientActivity.class);
            startActivity(intent);
        }


    }
}