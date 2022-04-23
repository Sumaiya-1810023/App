package com.example.bookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MyProfileInitial extends AppCompatActivity {

    Button logout;
    FirebaseAuth auth;
    LinearLayout layout;

    Button update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile_initial);


        logout = findViewById(R.id.logout);
        auth = FirebaseAuth.getInstance();


        update = findViewById(R.id.updateID);
        layout = findViewById(R.id.layout);



        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyProfileInitial.this, "Signout Successful", Toast.LENGTH_LONG).show();
                auth.signOut();
                Intent intent = new Intent(MyProfileInitial.this,Loginbutton.class);
                startActivity(intent);
                finish();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyProfileInitial.this,myprofile.class);
                startActivity(intent);
            }
        });


    }


}