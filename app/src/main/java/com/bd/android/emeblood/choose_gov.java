package com.bd.android.emeblood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class choose_gov extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    String choose;
    ArrayAdapter<CharSequence> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        choose = getIntent().getStringExtra("choose");
        setContentView(R.layout.activity_choose_gov);
        Spinner spinner = findViewById(R.id.gov_spinner);
        if (choose.equalsIgnoreCase("camp")) {
            adapter = ArrayAdapter.createFromResource(this,
                    R.array.governs, android.R.layout.simple_spinner_item);
        }else if (choose.equalsIgnoreCase("pat")){
            adapter = ArrayAdapter.createFromResource(this,
                    R.array.governs, android.R.layout.simple_spinner_item);
        }
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String text = parent.getItemAtPosition(position).toString();
        if (text.equalsIgnoreCase("اختر محافظتك")){

        }else {
            if (choose.equalsIgnoreCase("camp")) {
                Intent intent = new Intent(choose_gov.this, campaign.class);
                intent.putExtra("gov", text);
                startActivity(intent);
                finish();
            }else if (choose.equalsIgnoreCase("pat")) {
                Intent intent = new Intent(choose_gov.this, Next.class);
                intent.putExtra("gov", text);
                startActivity(intent);
                finish();
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    }

