package com.bd.android.emeblood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

public class UI extends AppCompatActivity {

    int counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);
        prog();
        findViewById(R.id.r).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UI.this, Activity2.class);
                 startActivity(intent);
                    finish();
            }
        });

    }

    private void prog() {
      final   Timer t = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                counter ++ ;

                if (counter == 30 ){
                    t.cancel();
                    Intent intent = new Intent(UI.this, Activity2.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
t.schedule(tt, 0,100);
    }

}
