package com.bd.android.emeblood.UIS;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bd.android.emeblood.R;
import com.google.firebase.auth.FirebaseAuth;

public class Activity2 extends AppCompatActivity
{
FirebaseAuth mAuth;
//here we give user the option to login or create new account
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newactivity);
        mAuth = FirebaseAuth.getInstance();
        mAuth.signOut();
    }
    //open login activity and close this one
    public void goToLog (View view){
        Intent logintent = new Intent(Activity2.this , intro.class);
        startActivity(logintent);
        finish();

    }
    //open sign up activity and close this one
    public void goToSign (View view){
        Intent signintent = new Intent(Activity2.this , SignUp.class);
        startActivity(signintent);
        finish();
    }


    }

