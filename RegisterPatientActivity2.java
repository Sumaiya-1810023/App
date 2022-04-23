package com.example.bookingapp;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterPatientActivity2 extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextName2, editTextEmail2, editTextPassword2, editTextPhone2;
    private ProgressBar progressBar2;
    private TextView tvLoginHere2;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_patient2);

        editTextName2 = findViewById(R.id.edit_text_name2);
        editTextEmail2 = findViewById(R.id.edit_text_email2);
        editTextPassword2 = findViewById(R.id.edit_text_password2);
        editTextPhone2 = findViewById(R.id.edit_text_phone2);

        progressBar2 = findViewById(R.id.progressbar);
        progressBar2.setVisibility(View.GONE);
        tvLoginHere2 = findViewById(R.id.tvLoginHere);
        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.button_register2).setOnClickListener(this);

        tvLoginHere2.setOnClickListener(view -> {
            startActivity(new Intent(RegisterPatientActivity2.this, LoginPatientActivity.class));
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (mAuth.getCurrentUser() == null) {
            //handle the already login user
            startActivity(new Intent(RegisterPatientActivity2.this, LoginPatientActivity.class));
        }
    }

    private void registerUser() {
        final String name2= editTextName2.getText().toString().trim();
        final String email2 = editTextEmail2.getText().toString().trim();
        String password2 = editTextPassword2.getText().toString().trim();

        final String phone2 = editTextPhone2.getText().toString().trim();
        if (name2.isEmpty()) {
            editTextName2.setError("This field cannot be empty");
            editTextName2.requestFocus();
            return;
        }

        if (email2.isEmpty()) {
            editTextEmail2.setError("Email cannot be empty");
            editTextEmail2.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email2).matches()) {
            editTextEmail2.setError("This Email Hasbeen Used Before");
            editTextEmail2.requestFocus();
            return;
        }

        if (password2.isEmpty()) {
            editTextPassword2.setError("This digit cannot be empty");
            editTextPassword2.requestFocus();
            return;
        }

        if (password2.length() < 6) {
            editTextPassword2.setError("Password should be at least 6 digit");
            editTextPassword2.requestFocus();
            return;
        }


        if (phone2.isEmpty()) {
            editTextPhone2.setError("This field cannot be empty");
            editTextPhone2.requestFocus();
            return;
        }

        if (phone2.length() != 11) {
            editTextPhone2.setError("Phone Number Invalid");
            editTextPhone2.requestFocus();
            return;
        }


        progressBar2.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email2, password2)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {

                            patients patients = new patients(
                                    name2,
                                    email2,
                                    phone2
                            );

                            FirebaseDatabase.getInstance().getReference("Patients")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(patients).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    progressBar2.setVisibility(View.GONE);
                                    if (task.isSuccessful()) {
                                        Toast.makeText(RegisterPatientActivity2.this, getString(R.string.registration_success), Toast.LENGTH_LONG).show();
                                    } else {
                                        //display a failure message
                                    }
                                }
                            });

                        } else {
                            Toast.makeText(RegisterPatientActivity2.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_register2:
                registerUser();
                break;
        }
    }
}