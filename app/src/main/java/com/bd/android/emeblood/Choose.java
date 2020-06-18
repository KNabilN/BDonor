package com.bd.android.emeblood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Choose extends AppCompatActivity {

    String chosen ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        findViewById(R.id.cam).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Choose.this , choose_gov.class);
                intent.putExtra("choose", "camp");
                startActivity(intent);
                finish();
            }
        });
        findViewById(R.id.pat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Choose.this , choose_gov.class);
                intent.putExtra("choose", "pat");
                startActivity(intent);
                finish();
            }
        });

    }
    }

