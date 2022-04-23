package com.example.bookingapp;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bookingapp.Loginbutton;
import com.example.bookingapp.R;
import com.example.bookingapp.myprofile;
import com.google.firebase.auth.FirebaseAuth;

public class DoctorMyProfile extends AppCompatActivity {

    Button logout2;
    FirebaseAuth auth;
    LinearLayout layout;

    Button update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_my_profile);


        logout2 = findViewById(R.id.logout2);
        auth = FirebaseAuth.getInstance();


        update = findViewById(R.id.updateID);
        layout = findViewById(R.id.layout);



        logout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DoctorMyProfile.this, "Signout Successful", Toast.LENGTH_LONG).show();
                auth.signOut();
                Intent intent = new Intent(DoctorMyProfile.this, Loginbutton.class);
                startActivity(intent);
                finish();
            }
        });




    }


}