package com.bd.android.emeblood.UIS;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bd.android.emeblood.R;
import com.bd.android.emeblood.ReNum;

public class Reneed extends AppCompatActivity implements View.OnClickListener{

    Button reg_op , reg_on , reg_ap , reg_an , reg_abp , reg_abn , reg_bp , reg_bn  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reneed);

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

    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void onClick(View view) {

        Intent go = new Intent(Reneed.this , ReNum.class);
        if(view == reg_abn) {
            reg_abn.setBackground(getResources().getDrawable(R.drawable.circlee));
            reg_on.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_op.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_abp.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_ap.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_an.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_bp.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_bn.setBackground(getResources().getDrawable(R.drawable.circle));
            go.putExtra("blood_group", "Grp abn");
            startActivity(go);


        }
        if (view == reg_abp){
            reg_abn.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_on.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_op.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_abp.setBackground(getResources().getDrawable(R.drawable.circlee));
            reg_ap.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_an.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_bp.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_bn.setBackground(getResources().getDrawable(R.drawable.circle));
            go.putExtra("blood_group", "Grp abp");
            startActivity(go);

        }
        if (view == reg_op){

            reg_abn.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_on.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_op.setBackground(getResources().getDrawable(R.drawable.circlee));
            reg_abp.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_ap.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_an.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_bp.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_bn.setBackground(getResources().getDrawable(R.drawable.circle));
            go.putExtra("blood_group", "Grp op");
            startActivity(go);

        }
        if (view == reg_on){

            reg_abn.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_on.setBackground(getResources().getDrawable(R.drawable.circlee));
            reg_op.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_abp.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_ap.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_an.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_bp.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_bn.setBackground(getResources().getDrawable(R.drawable.circle));
            go.putExtra("blood_group", "Grp on");
            startActivity(go);

        }
        if (view == reg_ap){
            reg_abn.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_on.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_op.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_abp.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_ap.setBackground(getResources().getDrawable(R.drawable.circlee));
            reg_an.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_bp.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_bn.setBackground(getResources().getDrawable(R.drawable.circle));
            go.putExtra("blood_group", "Grp ap");
            startActivity(go);

        }
        if (view == reg_an){

            reg_abn.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_on.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_op.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_abp.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_ap.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_an.setBackground(getResources().getDrawable(R.drawable.circlee));
            reg_bp.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_bn.setBackground(getResources().getDrawable(R.drawable.circle));
            go.putExtra("blood_group", "Grp an");
            startActivity(go);

        }
        if (view == reg_bp){
            reg_abn.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_on.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_op.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_abp.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_ap.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_an.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_bp.setBackground(getResources().getDrawable(R.drawable.circlee));
            reg_bn.setBackground(getResources().getDrawable(R.drawable.circle));
            go.putExtra("blood_group", "Grp bp");
            startActivity(go);


        }
        if (view == reg_bn){

            reg_abn.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_on.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_op.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_abp.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_ap.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_an.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_bp.setBackground(getResources().getDrawable(R.drawable.circle));
            reg_bn.setBackground(getResources().getDrawable(R.drawable.circlee));
            go.putExtra("blood_group", "Grp bn");
            startActivity(go);


        }



    }

}