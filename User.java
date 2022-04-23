package com.example.bookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

 public class User {
    public String name, email, specialization,phone;

    public User(){

    }

    public User(String name, String email, String specialization,String phone) {
        this.name = name;
        this.email = email;
        this.specialization = specialization;
        this.phone=phone;

    }
     public String getname() {
         return name;
     }

     public String getemail() {
         return email;
     }

     public String getphone() {
         return phone;
     }
     public String getSpecialization() {
         return specialization;
     }


}