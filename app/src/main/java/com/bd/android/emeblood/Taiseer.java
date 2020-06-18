package com.bd.android.emeblood;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bd.android.emeblood.UIS.Option;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Taiseer extends AppCompatActivity {
    Intent intent ;

    String counter;
    String number;
    int number_don;

    long mUserId;
    FirebaseFirestore firebaseFirestore;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txt = findViewById(R.id.H_N);
        txt.setText("Taiseer Hospital");
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

                    }
                });
            }
        });


        findViewById(R.id.cancelbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                number_don = Integer.parseInt(number);
                number_don ++ ;
                firebaseFirestore.collection("Users").document(firebaseAuth.getCurrentUser().getUid()).update("response", "no");
                firebaseFirestore.collection("Notification").document(Long.toString(mUserId)).update("number", Integer.toString(number_don));
                Intent intent = new Intent(Taiseer.this , Option.class);
                startActivity(intent);

            }
        });

    }
    public void showMap(View view ) {


        Uri mapUri = Uri.parse("google.navigation:q=30.5979188,31.4959376");

        intent = new Intent(Intent.ACTION_VIEW, mapUri);

        startActivity(intent);
    }
}