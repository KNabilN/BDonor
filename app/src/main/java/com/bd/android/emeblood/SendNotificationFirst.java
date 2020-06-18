//package com.example.android.emeblood;
//
//import android.annotation.SuppressLint;
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.view.View;
//import android.widget.TextView;
//
//import com.google.firebase.firestore.DocumentChange;
//import com.google.firebase.firestore.FirebaseFirestore;
//import com.google.firebase.firestore.FirebaseFirestoreException;
//import com.google.firebase.firestore.QuerySnapshot;
//
//import javax.annotation.Nullable;
//
//@SuppressLint("Registered")
//public class SendNotificationFirst extends AppCompatActivity {
//    FirebaseFirestore firebaseFirestore;
//
//    private TextView send_text ;
//    private TextView num_text ;
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.send_notification_first_step);
//
//    send_text = findViewById(R.id.send_text);
//    num_text = findViewById(R.id.num_text);
//        send_text.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            Intent sendIntent = new Intent(SendNotificationFirst.this,Next.class);
//            startActivity(sendIntent);
//
//        }
//    });
//    firebaseFirestore = FirebaseFirestore.getInstance();
//        firebaseFirestore.collection("Users").addSnapshotListener(new com.google.firebase.firestore.EventListener<QuerySnapshot>() {
//            @SuppressLint("SetTextI18n")
//            @Override
//            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
//                // focus here to get data and se them
//                int counter = 0 ;
//                assert queryDocumentSnapshots != null;
//                for (DocumentChange doc : queryDocumentSnapshots.getDocumentChanges()){
//                    if ( doc.getType()== DocumentChange.Type.ADDED){
//                        counter ++ ;
//
//                    }
//                }
//                num_text.setText(""+counter);
//            }
//        });
//
//
//}
//
//    @Override
//    public void onStart() {
//        super.onStart();
//        firebaseFirestore.collection("Users").addSnapshotListener(new com.google.firebase.firestore.EventListener<QuerySnapshot>() {
//            @SuppressLint("SetTextI18n")
//            @Override
//            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
//                // focus here to get data and se them
//                int counter = 0 ;
//                assert queryDocumentSnapshots != null;
//                for (DocumentChange doc : queryDocumentSnapshots.getDocumentChanges()){
//                    if ( doc.getType()== DocumentChange.Type.ADDED){
//                        counter ++ ;
//
//                    }
//                }
//                num_text.setText(""+counter);
//            }
//        });
//
//    }
//}
