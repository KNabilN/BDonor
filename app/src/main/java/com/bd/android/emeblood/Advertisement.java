package com.bd.android.emeblood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bd.android.emeblood.UIS.News;

public class Advertisement extends AppCompatActivity {
//if we need to put advertisement
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advertisement);
        findViewById(R.id.exit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Advertisement.this , News.class);
                startActivity(intent);
                finish();

            }
        });
    }
}
