package com.bd.android.emeblood;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bd.android.emeblood.UIS.SendNoti;


public class Next extends AppCompatActivity {

    Button next ;
    EditText number ;
    EditText rec ;
    EditText phone;
    EditText des ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.recievername);
        next = findViewById(R.id.button);
        rec = findViewById(R.id.rec);
        des = findViewById(R.id.edit_number_des);
        number = findViewById(R.id.edit_number);
        phone = findViewById(R.id.edit_number_phone);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = rec.getText().toString().trim();
                String num = number.getText().toString().trim();
                String phn = phone.getText().toString().trim();
                String desc = des.getText().toString().trim();
                String choose = getIntent().getStringExtra("gov");
                int counterr = 0;

                for (int i=0 ;i < phn.length() ;i++){
                    counterr ++ ;
                }



                if (!phn.isEmpty() && counterr != 11){
                    Toast.makeText(Next.this, "رقم الهاتف خاطئ", Toast.LENGTH_LONG).show();
                    //stopping the function executing further
                    return;
                }

                if (!num.isEmpty() && !name.isEmpty()) {


                    Intent intent = new Intent(Next.this, SendNoti.class);
                    intent.putExtra("mnam", "" + name);
                    intent.putExtra("mnum", num);
                    intent.putExtra("phn", phn);
                    intent.putExtra("des", desc);
                    intent.putExtra("govern", choose);
                    startActivity(intent);
                } else if (name.isEmpty() ) {

                    Toast.makeText(Next.this,"أدخل اسم الحالة" , Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Next.this,"أدخل عدد المتبرعين المطلوب" , Toast.LENGTH_LONG).show();

                }
            }
        });
    }



}
