package com.bd.android.emeblood;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import javax.annotation.Nullable;

public class TH extends AppCompatActivity {

    private TextView op ;
    private TextView on ;
    private TextView ap ;
    private TextView an ;
    private TextView abp ;
    private TextView abn ;
    private TextView bp ;
    private TextView bn ;
    private TextView textGrid ;

    FirebaseFirestore firebaseFirestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_th);
        firebaseFirestore = FirebaseFirestore.getInstance();
        op = findViewById(R.id.op);
        on = findViewById(R.id.on);
        ap = findViewById(R.id.ap);
        an = findViewById(R.id.an);
        abp = findViewById(R.id.abp);
        abn = findViewById(R.id.abn);
        bp = findViewById(R.id.bp);
        bn = findViewById(R.id.bn);
        textGrid = findViewById(R.id.textGrid);

      String activity =  getIntent().getStringExtra("activity");

      if(activity.equalsIgnoreCase("th")){


          firebaseFirestore.collection("TH").document("pLj06hRXeWpGEfJC7Y32").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
              @SuppressLint("CheckResult")
              @Override
              public void onSuccess(DocumentSnapshot documentSnapshot) {
                  //هات البيانات بقى من مفتاحها الاخير في الوثائق


                  String OP = documentSnapshot.getString("O+");
                  String ON =  documentSnapshot.getString("O-");
                  String AP =  documentSnapshot.getString("A+");
                  String AN =  documentSnapshot.getString("A-");
                  String ABP = documentSnapshot.getString("AB+");
                  String ABN = documentSnapshot.getString("AB-");
                  String BP =  documentSnapshot.getString("B+");
                  String BN =  documentSnapshot.getString("B-");

                  textGrid.setText("Tayser Hospital");
                  op.setText(OP);
                  on.setText(ON);
                  ap.setText(AP);
                  an.setText( AN);
                  abp.setText(ABP);
                  abn.setText( ABN);
                  bp.setText( BP);
                  bn.setText( BN);


//
              }
          });
      }
        if(activity.equalsIgnoreCase("ah")){


            firebaseFirestore.collection("AH").document("bVh2hxygebBAFoRBUd93").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @SuppressLint("CheckResult")
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    //هات البيانات بقى من مفتاحها الاخير في الوثائق

                    String OP = documentSnapshot.getString("O+");
                    String ON =  documentSnapshot.getString("O-");
                    String AP =  documentSnapshot.getString("A+");
                    String AN =  documentSnapshot.getString("A-");
                    String ABP = documentSnapshot.getString("AB+");
                    String ABN = documentSnapshot.getString("AB-");
                    String BP =  documentSnapshot.getString("B+");
                    String BN =  documentSnapshot.getString("B-");

                    textGrid.setText("Ahrar Hospital");
                    op.setText(OP);
                    on.setText(ON);
                    ap.setText(AP);
                    an.setText( AN);
                    abp.setText(ABP);
                    abn.setText( ABN);
                    bp.setText( BP);
                    bn.setText( BN);

//
                }
            });
        }
        if(activity.equalsIgnoreCase("gh")){


            firebaseFirestore.collection("GH").document("OR7DIaVi3bISCDZfeOqT").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @SuppressLint("CheckResult")
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    //هات البيانات بقى من مفتاحها الاخير في الوثائق

                    String OP = documentSnapshot.getString("O+");
                    String ON =  documentSnapshot.getString("O-");
                    String AP =  documentSnapshot.getString("A+");
                    String AN =  documentSnapshot.getString("A-");
                    String ABP = documentSnapshot.getString("AB+");
                    String ABN = documentSnapshot.getString("AB-");
                    String BP =  documentSnapshot.getString("B+");
                    String BN =  documentSnapshot.getString("B-");

                    textGrid.setText("AL-Gamaa Hospital");
                    op.setText(OP);
                    on.setText(ON);
                    ap.setText(AP);
                    an.setText( AN);
                    abp.setText(ABP);
                    abn.setText( ABN);
                    bp.setText( BP);
                    bn.setText( BN);


//
                }
            });
        }
    }
}
