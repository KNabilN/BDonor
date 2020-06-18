package com.bd.android.emeblood;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bd.android.emeblood.UIS.Option;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.firestore.FirebaseFirestore;


public class Update extends AppCompatActivity implements View.OnClickListener{
    FirebaseAuth mAuth ;
    private ProgressDialog progressDialog ;
    String blood ;
    Button reg_op , reg_on , reg_ap , reg_an , reg_abp , reg_abn , reg_bp , reg_bn;


    Button update ;
    FirebaseFirestore mfirestore;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        reg_op = findViewById(R.id.reg_op);
        reg_on = findViewById(R.id.reg_on);
        reg_ap = findViewById(R.id.reg_ap);
        reg_an = findViewById(R.id.reg_an);
        reg_abp = findViewById(R.id.reg_abp);
        reg_abn = findViewById(R.id.reg_abn);
        reg_bp = findViewById(R.id.reg_bp);
        reg_bn = findViewById(R.id.reg_bn);
        reg_ap.setOnClickListener(this);
        reg_an.setOnClickListener(this);
        reg_op.setOnClickListener(this);
        reg_on.setOnClickListener(this);
        reg_bp.setOnClickListener(this);
        reg_bn.setOnClickListener(this);
        reg_abp.setOnClickListener(this);
        reg_abn.setOnClickListener(this);

        //diolog
        progressDialog = new ProgressDialog(this);

        //firebase initilization
        mAuth = FirebaseAuth.getInstance();
        mfirestore = FirebaseFirestore.getInstance();


        // spinner

        update = findViewById(R.id.update_btn);

        final String user_id = mAuth.getCurrentUser().getUid();


        update.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View view) {
        if (view == reg_abn) {
            blood = "AB-";
            reg_abn.setBackground(getResources().getDrawable(R.drawable.circlee));
            reg_on.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_op.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_abp.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_ap.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_an.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_bp.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_bn.setBackground(getResources().getDrawable(R.drawable.circle));


        }
        if (view == reg_abp) {
            blood = "AB+";
            reg_abn.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_on.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_op.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_abp.setBackground(getResources().getDrawable(R.drawable.circlee));
            reg_ap.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_an.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_bp.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_bn.setBackground(getResources().getDrawable(R.drawable.circle));

        }
        if (view == reg_op) {
            blood = "O+";
            reg_abn.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_on.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_op.setBackground(getResources().getDrawable(R.drawable.circlee));
            reg_abp.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_ap.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_an.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_bp.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_bn.setBackground(getResources().getDrawable(R.drawable.circle));

        }
        if (view == reg_on) {
            blood = "O-";
            reg_abn.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_on.setBackground(getResources().getDrawable(R.drawable.circlee));
            reg_op.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_abp.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_ap.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_an.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_bp.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_bn.setBackground(getResources().getDrawable(R.drawable.circle));

        }
        if (view == reg_ap) {
            blood = "A+";
            reg_abn.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_on.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_op.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_abp.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_ap.setBackground(getResources().getDrawable(R.drawable.circlee));
            reg_an.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_bp.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_bn.setBackground(getResources().getDrawable(R.drawable.circle));

        }
        if (view == reg_an) {
            blood = "A-";
            reg_abn.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_on.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_op.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_abp.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_ap.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_an.setBackground(getResources().getDrawable(R.drawable.circlee));
            reg_bp.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_bn.setBackground(getResources().getDrawable(R.drawable.circle));

        }
        if (view == reg_bp) {
            blood = "B+";
            reg_abn.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_on.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_op.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_abp.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_ap.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_an.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_bp.setBackground(getResources().getDrawable(R.drawable.circlee));
            reg_bn.setBackground(getResources().getDrawable(R.drawable.circle));


        }
        if (view == reg_bn) {
            blood = "B-";
            reg_abn.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_on.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_op.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_abp.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_ap.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_an.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_bp.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_bn.setBackground(getResources().getDrawable(R.drawable.circlee));
        }

            if (view == update) {

                if (!blood.isEmpty()) {
                progressDialog.setMessage("Wait please ...");
                progressDialog.show();

                //create account


                final String user_id = mAuth.getCurrentUser().getUid();

                    final String mBlood = blood;


                    //عشان كل اكونت جديد يتعمله فولدر كده
                    mfirestore.collection("Users").document(user_id).update("blood", mBlood).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                progressDialog.hide();

                                // go to main activity
                                Intent intent = new Intent(Update.this, Option.class);
                                startActivity(intent);
                                finish();
                                // go to enable sign in method in firebase
                                // and database to change safty after finish change it to request.auth != null
                            } else {
                                progressDialog.hide();
                                Toast.makeText(Update.this, "Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                progressDialog.hide();

                            }


                        }
                    });

                }
            }else {}


    }


}
