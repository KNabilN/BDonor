package com.bd.android.emeblood.UIS;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bd.android.emeblood.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class ShowSecondStep extends AppCompatActivity {
FirebaseFirestore firebaseFirestore;
TextView message_show ;
    private Long mUserId;


    FirebaseAuth firebaseAuth;
   private String number;
    String HN ;
    long count;
    Button show;
    int count_don;
    String message;
    String noti_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_second_step);
         firebaseFirestore = FirebaseFirestore.getInstance();
        mUserId = getIntent().getLongExtra("counter",4 );
        noti_type = getIntent().getStringExtra("noti_type");
        firebaseAuth = FirebaseAuth.getInstance();
        message_show = findViewById(R.id.message_show);

    if (noti_type.equalsIgnoreCase("pat")) {

    firebaseFirestore.collection("Notification").document(Long.toString(mUserId)).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
        @SuppressLint("CheckResult")
        @Override
        public void onSuccess(final DocumentSnapshot documentSnapshot) {
            //هات البيانات بقى من مفتاحها الاخير في الوثائق
            message = documentSnapshot.getString("message");
            message_show.setText(message);
            if (documentSnapshot.getString("HN") != null) {
                HN = documentSnapshot.getString("HN");
                number = documentSnapshot.getString("number");
            } else {
                show.setVisibility(View.GONE);
            }
            count = documentSnapshot.getLong("counter");
            count_don = (int) count;

        }
    });
}else if (noti_type.equalsIgnoreCase("camp")){
    firebaseFirestore.collection("Camps").document(Long.toString(mUserId)).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
        @SuppressLint("CheckResult")
        @Override
        public void onSuccess(final DocumentSnapshot documentSnapshot) {
            //هات البيانات بقى من مفتاحها الاخير في الوثائق
            message = documentSnapshot.getString("message");
            message_show.setText(message);
            show.setVisibility(View.GONE);
            count = documentSnapshot.getLong("counter");
            count_don = (int) count;

        }
    });
}
      show = findViewById(R.id.show_btn);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseFirestore.collection("Users").document(firebaseAuth.getCurrentUser().getUid()).update("response", "yes");

                Intent last = null;

                int number_don = Integer.parseInt(number);

                number_don -- ;
                if(number_don >= 0) {

                    if (HN != null) {

                        last = new Intent(ShowSecondStep.this, MainActivity.class);

                        Map<String, Object> num = new HashMap<>();
                        num.put("number", Integer.toString(number_don));


                        firebaseFirestore.collection("Notification").document(Long.toString(mUserId)).update("number", Integer.toString(number_don));
                        startActivity(last);
                        finish();
                    }

                } else if ( number_don < 0 ){
                    Toast.makeText(ShowSecondStep.this, "الحمدلله وصلنا للعدد المطلوب", Toast.LENGTH_LONG).show();
                    firebaseFirestore.collection("Notification").document(Long.toString(mUserId)).delete();
                }


            }
        });



    }

    @Override
    protected void onStart() {
        super.onStart();
        findViewById(R.id.show_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent last = null;
                firebaseFirestore.collection("Users").document(firebaseAuth.getCurrentUser().getUid()).update("response", "yes");


                int number_don = Integer.parseInt(number);

                number_don--;
                if(number_don >= 0) {

                    if (HN != null) {
                        last = new Intent(ShowSecondStep.this, MainActivity.class);

                        Map<String, Object> num = new HashMap<>();
                        num.put("number", Integer.toString(number_don));


                        firebaseFirestore.collection("Notification").document(Long.toString(mUserId)).update("number", Integer.toString(number_don));
                        startActivity(last);
                        finish();
                    }

                } else if ( number_don < 0 ){
                    Toast.makeText(ShowSecondStep.this, "الحمدلله وصلنا للعدد المطلوب", Toast.LENGTH_LONG).show();
                    firebaseFirestore.collection("Notification").document(Long.toString(mUserId)).delete();
                }


            }
        });


    }



}
