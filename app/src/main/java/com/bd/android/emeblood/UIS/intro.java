package com.bd.android.emeblood.UIS;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bd.android.emeblood.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

@SuppressLint("Registered")
public class intro extends AppCompatActivity implements View.OnClickListener {
    private EditText mMail;
    private EditText mPassword;
    private Button mLogIn;

    private FirebaseAuth mAuth;
    private ProgressDialog progressDialog ;
    private FirebaseFirestore mFireStore ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);
        mMail = findViewById(R.id.mail);
        mPassword = findViewById(R.id.pass);
        mLogIn = findViewById(R.id.login);
        progressDialog = new ProgressDialog(intro.this);





        mAuth = FirebaseAuth.getInstance();

        mFireStore = FirebaseFirestore.getInstance();

        mLogIn.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        if (view == mLogIn) {

            final String mail = mMail.getText().toString().trim();
            String pass = mPassword.getText().toString().trim();
            if (!TextUtils.isEmpty(mail) && !TextUtils.isEmpty(pass)) {
                progressDialog.setMessage("Wait please ...");
                progressDialog.show();


                mAuth.signInWithEmailAndPassword(mail, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {




                            // for Notification to specific user

                            String current_id = mAuth.getCurrentUser().getUid();
                            // new map for notification requirements
                            Map<String , Object> tokenMap = new HashMap<>();

                            mFireStore.collection("Users").document(current_id).update(tokenMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(intro.this, " Welcome ^_^ ", Toast.LENGTH_SHORT).show();
                                    Intent enterIntent = new Intent(intro.this, Option.class);
                                    startActivity(enterIntent);
                                    progressDialog.hide();

                                    finish();

                                }

                            });


                        } else {
                            Toast.makeText(intro.this, " Error : " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            progressDialog.hide();
                        }
                    }
                });


            } else {
                Toast.makeText(intro.this, " please enter your data", Toast.LENGTH_SHORT).show();

            }
        }

    }
    }

