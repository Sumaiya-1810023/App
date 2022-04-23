package com.example.bookingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class myprofile extends AppCompatActivity {
    private EditText UserName, Number;
    private Button SaveInformationbuttion;


    private FirebaseAuth mAuth;
    private DatabaseReference UsersRef;


    String currentUserID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myprofile);

        mAuth = FirebaseAuth.getInstance();
        currentUserID = mAuth.getCurrentUser().getUid();
        UsersRef = FirebaseDatabase.getInstance().getReference().child("Users").child(currentUserID);



        UserName = (EditText) findViewById(R.id.edit_text_name2);
        Number = (EditText) findViewById(R.id.edit_text_number);

        SaveInformationbuttion = (Button) findViewById(R.id.button_save);



        SaveInformationbuttion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String username = UserName.getText().toString();
                String number = Number.getText().toString();


                if(TextUtils.isEmpty(username))
                {
                    Toast.makeText(myprofile.this, "Please write your username...", Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(number))
                {
                    Toast.makeText(myprofile.this, "Please write your full name...", Toast.LENGTH_SHORT).show();
                }

                else
                {


                    HashMap userMap = new HashMap();
                    userMap.put("username", username);
                    userMap.put("number", number);

                    UsersRef.updateChildren(userMap).addOnCompleteListener(new OnCompleteListener() {
                        @Override
                        public void onComplete(@NonNull Task task)
                        {
                            if(task.isSuccessful())
                            {

                                Toast.makeText(myprofile.this, "your Account is created Successfully.", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(myprofile.this,  HomepagePatientActivity.class);
                                startActivity(intent);
                            }
                            else
                            {
                                String message =  task.getException().getMessage();
                                Toast.makeText(myprofile.this, "Error Occured: " + message, Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
                }
            }
    });



}}