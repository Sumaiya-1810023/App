package com.example.bookingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomepagePatientActivity extends AppCompatActivity implements View.OnClickListener {
    public CardView card1,card2,card3,card4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage_patient);
        card1=(CardView)findViewById(R.id.myprofile);
        card2=(CardView)findViewById(R.id.appoinment);
        card3=(CardView)findViewById(R.id.doctor);
        card4=(CardView)findViewById(R.id.folder);

        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
    }
    public void onClick(View v)
    {
        if(v.getId()==R.id.myprofile) {
            Intent intent = new Intent(HomepagePatientActivity.this, MyProfileInitial.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.appoinment) {
            Intent intent = new Intent(HomepagePatientActivity.this,RegisterPatientActivity .class);
            startActivity(intent);
        }
        if(v.getId()==R.id.doctor) {
            Intent intent = new Intent(HomepagePatientActivity.this,Doctorslist.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.folder) {
            Intent intent = new Intent(HomepagePatientActivity.this,image.class);
            startActivity(intent);
        }

    }
}