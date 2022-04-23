package com.example.bookingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class HomepageDoctorActivity extends AppCompatActivity {
    public CardView card5,card6,card7,card8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage_doctor);
        card5=(CardView)findViewById(R.id.myprofile2);
        card6=(CardView)findViewById(R.id.appoinment2);
        card7=(CardView)findViewById(R.id.mypatient2);
        card8=(CardView)findViewById(R.id.payment);


        card5.setOnClickListener(view ->{
            startActivity(new Intent(HomepageDoctorActivity.this, DoctorMyProfile.class));
        });
        card6.setOnClickListener(view ->{
            startActivity(new Intent(HomepageDoctorActivity.this, LoginPatientActivity.class));
        });
        card7.setOnClickListener(view ->{
            startActivity(new Intent(HomepageDoctorActivity.this, LoginPatientActivity.class));
        });
        card8.setOnClickListener(view ->{
            startActivity(new Intent(HomepageDoctorActivity.this,PaymentActivity.class));
        });

    }

    }
