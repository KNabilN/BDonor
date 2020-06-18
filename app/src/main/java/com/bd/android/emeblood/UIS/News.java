package com.bd.android.emeblood.UIS;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.bd.android.emeblood.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

public class News extends AppCompatActivity {
FirebaseFirestore firebaseFirestore;
TextView news ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        firebaseFirestore = FirebaseFirestore.getInstance();

       news = findViewById(R.id.textNews);

        firebaseFirestore.collection("News").document("UceMFIMAixz6cm69XN2u").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                String news_live = documentSnapshot.getString("news");
                news.setText(news_live);
            }
        });

    }
}
