package com.bd.android.emeblood.UIS;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.bd.android.emeblood.R;
import com.bd.android.emeblood.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;



public class Settings extends AppCompatActivity {
    String phone;
    TextView on;
    private CheckBox permission_check;
    FirebaseFirestore mFireStore ;
    String user_blood_type;
    String user_name;
    String userID;
    private FirebaseAuth mAuth;
    String permission;
    Switch notiSwitch ;
    String noti_per;
    String gov;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        on = findViewById(R.id.sit);

        notiSwitch = findViewById(R.id.noti_switch);
        permission_check = findViewById(R.id.permission);
        mAuth = FirebaseAuth.getInstance();
        mFireStore = FirebaseFirestore.getInstance();
//        findViewById(R.id.lang).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Settings.this , Language.class);
//                startActivity(intent);
//            }
//        });
        if (mAuth.getCurrentUser() != null) {
            userID = mAuth.getCurrentUser().getUid();
            mFireStore.collection("Users").document(userID).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @SuppressLint("CheckResult")
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    //هات البيانات بقى من مفتاحها الاخير في الوثائق
                    user_name = documentSnapshot.getString("name");
                    user_blood_type = documentSnapshot.getString("blood");
                    permission = documentSnapshot.getString("permission");
                    phone = documentSnapshot.getString("phone");
                    noti_per = documentSnapshot.getString("noti_per");
                    gov =documentSnapshot.getString("gov");

if(permission != null) {
    if (permission.equalsIgnoreCase("yes")) {
        permission_check.setChecked(true);
    }else {
        permission_check.setChecked(true);
    }
}
                    if(noti_per != null) {
                        if (noti_per.equalsIgnoreCase("yes")) {
                            notiSwitch.setChecked(true);
                            on.setText("On");

                        }else {
                            notiSwitch.setChecked(false);
                            on.setText("Off");

                        }

                    }
                }
            });
            notiSwitch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (notiSwitch.isChecked()){
                        on.setText("On");
                    }else {
                        on.setText("Off");
                    }
                }
            });





            notiSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        mFireStore.collection("Users").document(userID).update("noti_per", "yes");
                    saveToken();
                    }else{
                        mFireStore.collection("Users").document(userID).update("noti_per", "no");
                        delete();
                    }
                }
            });
            permission_check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        mFireStore.collection("Users").document(userID).update("permission", "yes");
                        Map<String, Object> usere = new HashMap<>();
                        usere.put("name", user_name);
                        usere.put("phone", phone);
                        if (user_blood_type.equalsIgnoreCase("O+")) {
                            mFireStore.collection("Grp op").document(userID).set(usere);
                        }
                        if (user_blood_type.equalsIgnoreCase("O-")) {

                            mFireStore.collection("Grp on").document(userID).set(usere);

                        }
                        if (user_blood_type.equalsIgnoreCase("A+")) {
                            mFireStore.collection("Grp ap").document(userID).set(usere);

                        }
                        if (user_blood_type.equalsIgnoreCase("A-")) {

                            mFireStore.collection("Grp an").document(userID).set(usere);

                        }
                        if (user_blood_type.equalsIgnoreCase("AB+")) {

                            mFireStore.collection("Grp abp").document(userID).set(usere);

                        }
                        if (user_blood_type.equalsIgnoreCase("AB-")) {

                            mFireStore.collection("Grp abn").document(userID).set(usere);

                        }
                        if (user_blood_type.equalsIgnoreCase("B+")) {

                            mFireStore.collection("Grp bp").document(userID).set(usere);

                        }
                        if (user_blood_type.equalsIgnoreCase("B-")) {

                            mFireStore.collection("Grp bn").document(userID).set(usere);

                        }
                    } else {
                        mFireStore.collection("Users").document(userID).update("permission", "no");
                        if (user_blood_type.equalsIgnoreCase("O+")) {
                            mFireStore.collection("Grp op").document(userID).delete();
                        }
                        if (user_blood_type.equalsIgnoreCase("O-")) {

                            mFireStore.collection("Grp on").document(userID).delete();

                        }
                        if (user_blood_type.equalsIgnoreCase("A+")) {
                            mFireStore.collection("Grp ap").document(userID).delete();

                        }
                        if (user_blood_type.equalsIgnoreCase("A-")) {

                            mFireStore.collection("Grp an").document(userID).delete();

                        }
                        if (user_blood_type.equalsIgnoreCase("AB+")) {

                            mFireStore.collection("Grp abp").document(userID).delete();

                        }
                        if (user_blood_type.equalsIgnoreCase("AB-")) {

                            mFireStore.collection("Grp abn").document(userID).delete();

                        }
                        if (user_blood_type.equalsIgnoreCase("B+")) {

                            mFireStore.collection("Grp bp").document(userID).delete();

                        }
                        if (user_blood_type.equalsIgnoreCase("B-")) {

                            mFireStore.collection("Grp bn").document(userID).delete();


                        }
                    }
                }
            });


        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mAuth.getCurrentUser() != null) {
            userID = mAuth.getCurrentUser().getUid();
            mFireStore.collection("Users").document(userID).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @SuppressLint("CheckResult")
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    //هات البيانات بقى من مفتاحها الاخير في الوثائق
                    user_name = documentSnapshot.getString("name");
                    user_blood_type = documentSnapshot.getString("blood");
                    permission = documentSnapshot.getString("permission");
                    phone = documentSnapshot.getString("phone");
                    noti_per = documentSnapshot.getString("noti_per");
                    gov = documentSnapshot.getString("gov");


                    if(permission != null) {
                        if (permission.equalsIgnoreCase("yes")) {
                            permission_check.setChecked(true);
                        }else {
                            permission_check.setChecked(true);
                        }
                    }
                    if(noti_per != null) {
                        if (noti_per.equalsIgnoreCase("yes")) {
                            notiSwitch.setChecked(true);
                            on.setText("On");

                        }else {
                            notiSwitch.setChecked(false);
                            on.setText("Off");
                        }

                    }
                }
            });

            notiSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        mFireStore.collection("Users").document(userID).update("noti_per","yes");

                        saveToken();

                    }else{

                        mFireStore.collection("Users").document(userID).update("noti_per","no");

                        delete();
                    }
                }
            });
            permission_check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        mFireStore.collection("Users").document(userID).update("permission", "yes");
                        Map<String, Object> usere = new HashMap<>();
                        usere.put("name", user_name);
                        usere.put("phone", phone);
                        if (user_blood_type.equalsIgnoreCase("O+")) {
                            mFireStore.collection("Grp op").document(userID).set(usere);
                        }
                        if (user_blood_type.equalsIgnoreCase("O-")) {

                            mFireStore.collection("Grp on").document(userID).set(usere);

                        }
                        if (user_blood_type.equalsIgnoreCase("A+")) {
                            mFireStore.collection("Grp ap").document(userID).set(usere);

                        }
                        if (user_blood_type.equalsIgnoreCase("A-")) {

                            mFireStore.collection("Grp an").document(userID).set(usere);

                        }
                        if (user_blood_type.equalsIgnoreCase("AB+")) {

                            mFireStore.collection("Grp abp").document(userID).set(usere);

                        }
                        if (user_blood_type.equalsIgnoreCase("AB-")) {

                            mFireStore.collection("Grp abn").document(userID).set(usere);

                        }
                        if (user_blood_type.equalsIgnoreCase("B+")) {

                            mFireStore.collection("Grp bp").document(userID).set(usere);

                        }
                        if (user_blood_type.equalsIgnoreCase("B-")) {

                            mFireStore.collection("Grp bn").document(userID).set(usere);

                        }
                        if (user_blood_type.equalsIgnoreCase("NON")) {
                        }
                    } else {
                        mFireStore.collection("Users").document(userID).update("permission", "no");
                        if (user_blood_type.equalsIgnoreCase("O+")) {
                            mFireStore.collection("Grp op").document(userID).delete();
                        }
                        if (user_blood_type.equalsIgnoreCase("O-")) {

                            mFireStore.collection("Grp on").document(userID).delete();

                        }
                        if (user_blood_type.equalsIgnoreCase("A+")) {
                            mFireStore.collection("Grp ap").document(userID).delete();

                        }
                        if (user_blood_type.equalsIgnoreCase("A-")) {

                            mFireStore.collection("Grp an").document(userID).delete();

                        }
                        if (user_blood_type.equalsIgnoreCase("AB+")) {

                            mFireStore.collection("Grp abp").document(userID).delete();

                        }
                        if (user_blood_type.equalsIgnoreCase("AB-")) {

                            mFireStore.collection("Grp abn").document(userID).delete();

                        }
                        if (user_blood_type.equalsIgnoreCase("B+")) {

                            mFireStore.collection("Grp bp").document(userID).delete();

                        }
                        if (user_blood_type.equalsIgnoreCase("B-")) {

                            mFireStore.collection("Grp bn").document(userID).delete();


                        }
                    }
                }
            });


        }


    }
    public static final String NODE_NOTI = "notifications";
    private void saveToken() {

        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if (task.isSuccessful()) {
                            String token = task.getResult().getToken();
                            User user = new User( token);

                            DatabaseReference dbUsers = FirebaseDatabase.getInstance().getReference(gov);

                            dbUsers.child(mAuth.getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {

                                    }
                                }
                            });
                        }
                    }
                });
    }
    private void delete() {

        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if ( task.isSuccessful()){
                            DatabaseReference dbUsers = FirebaseDatabase.getInstance().getReference(gov);

                            dbUsers.child(mAuth.getCurrentUser().getUid())
                                    .removeValue();
                }


    }
                });
    }
}
