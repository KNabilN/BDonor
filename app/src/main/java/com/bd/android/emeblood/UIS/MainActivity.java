package com.bd.android.emeblood.UIS;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bd.android.emeblood.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {
      Intent intent ;
      String counter;
    String number;
    String hn="";
    String ha="";
    int number_don;
    TextView txt;
    TextView addr;
    long mUserId;
    FirebaseFirestore firebaseFirestore;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt= findViewById(R.id.H_N);
        addr = findViewById(R.id.H_A);

       firebaseAuth = FirebaseAuth.getInstance();
       firebaseFirestore = FirebaseFirestore.getInstance();

         firebaseFirestore.collection("Users").document(firebaseAuth.getCurrentUser().getUid()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
             @Override
             @SuppressLint("CheckResult")
             public void onSuccess(DocumentSnapshot documentSnapshot) {
                 mUserId = documentSnapshot.getLong("counter");

                 firebaseFirestore.collection("Notification").document(Long.toString(mUserId)).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {

                     @SuppressLint("CheckResult")
                     @Override
                     public void onSuccess(DocumentSnapshot documentSnapshot) {

                         number = documentSnapshot.getString("number");
                         hn = documentSnapshot.getString("HN");
                         ha = documentSnapshot.getString("Add");


                     }
                 });
             }
         });
        txt.setText(hn);
        addr.setText(ha);


        findViewById(R.id.cancelbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (number != null) {
                    number_don = Integer.parseInt(number);
                    number_don++;
                    firebaseFirestore.collection("Users").document(firebaseAuth.getCurrentUser().getUid()).update("response", "no");
                    firebaseFirestore.collection("Notification").document(Long.toString(mUserId)).update("number", Integer.toString(number_don));
                    Intent intent = new Intent(MainActivity.this, Option.class);
                    startActivity(intent);

                }else {
                    firebaseFirestore.collection("Users").document(firebaseAuth.getCurrentUser().getUid()).update("response", "no");
                    Intent intent = new Intent(MainActivity.this, Option.class);
                    startActivity(intent);
                }
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        firebaseFirestore.collection("Users").document(firebaseAuth.getCurrentUser().getUid()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            @SuppressLint("CheckResult")
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                mUserId = documentSnapshot.getLong("counter");

                firebaseFirestore.collection("Notification").document(Long.toString(mUserId)).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {

                    @SuppressLint("CheckResult")
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        number = documentSnapshot.getString("number");
                        hn = documentSnapshot.getString("HN");
                        ha = documentSnapshot.getString("Add");


                    }
                });
            }
        });
        txt.setText(hn);
        addr.setText(ha);


    }
}
