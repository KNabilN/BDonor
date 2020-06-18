package com.bd.android.emeblood.UIS;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bd.android.emeblood.Choose;
import com.bd.android.emeblood.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import javax.annotation.Nullable;


/**
 * A simple {@link Fragment} subclass.
 */
public class SendNotificationsFragment extends Fragment {

 TextView send_notification ;
     TextView show_camps ;
 TextView show_notification ;
 TextView reneed_text;
 TextView num_text ;
FirebaseAuth firebaseAuth;
 TextView noti_num;
     TextView camps_num;
FirebaseFirestore firebaseFirestore;
    public SendNotificationsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();


            firebaseFirestore.collection("Users").addSnapshotListener(new com.google.firebase.firestore.EventListener<QuerySnapshot>() {
                @SuppressLint("SetTextI18n")
                @Override
                public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                    // focus here to get data and se them
                    int users = 0;
                    try {


                        for (DocumentChange doc : queryDocumentSnapshots.getDocumentChanges()) {

                            if (doc.getType() == DocumentChange.Type.ADDED) {
                                users++;
                            }

                            }

                    }catch (Exception ee){

                    }

                    num_text.setText("" + users);
                }
            });
            firebaseFirestore.collection("Notification").addSnapshotListener(new com.google.firebase.firestore.EventListener<QuerySnapshot>() {
                @SuppressLint("SetTextI18n")
                @Override
                public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                    // focus here to get data and se them
                    int counter = 0;
try {


    for (DocumentChange doc : queryDocumentSnapshots.getDocumentChanges()) {
        if (doc.getType() == DocumentChange.Type.ADDED) {


            counter++;
        }


    }
}catch (Exception ee){

}

                    noti_num.setText("" + counter);
                }
            });
            firebaseFirestore.collection("Camps").addSnapshotListener(new com.google.firebase.firestore.EventListener<QuerySnapshot>() {
                @SuppressLint("SetTextI18n")
                @Override
                public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                    // focus here to get data and se them
                    int counter = 0;
                    try {


                        for (DocumentChange doc : queryDocumentSnapshots.getDocumentChanges()) {
                            if (doc.getType() == DocumentChange.Type.ADDED) {


                                counter++;
                            }

                        }
                    }catch (Exception ee){

                    }

                    camps_num.setText("" + counter);
                }
            });

    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_send_notifications, container, false);

        show_camps = view.findViewById(R.id.show_camp);
        firebaseFirestore = FirebaseFirestore.getInstance();
        num_text = view.findViewById(R.id.numm_text);
        firebaseAuth = FirebaseAuth.getInstance();
        noti_num = view.findViewById(R.id.noti_num);
        camps_num = view.findViewById(R.id.camp_num);

        send_notification = view.findViewById(R.id.send_notificatoin);
        show_notification = view.findViewById(R.id.show_notification);
        reneed_text = view.findViewById(R.id.reneed);
        firebaseFirestore = FirebaseFirestore.getInstance();



        firebaseFirestore.collection("Users").addSnapshotListener(new com.google.firebase.firestore.EventListener<QuerySnapshot>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                // focus here to get data and se them
                int users = 0;

                try {


                    for (DocumentChange doc : queryDocumentSnapshots.getDocumentChanges()) {
                        if (doc.getType() == DocumentChange.Type.ADDED) {

                            users++;

                        }
                    }
                }catch (Exception ee){

                }

                num_text.setText("" + users);
            }
        });
        firebaseFirestore.collection("Camps").addSnapshotListener(new com.google.firebase.firestore.EventListener<QuerySnapshot>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                // focus here to get data and se them
                int counter = 0;
                try {
                    for (DocumentChange doc : queryDocumentSnapshots.getDocumentChanges()) {
                        if (doc.getType() == DocumentChange.Type.ADDED) {

                            counter++;

                        }
                    }
                }catch (Exception ee){

                }

                camps_num.setText("" + counter);

            }
        });


        firebaseFirestore.collection("Notification").addSnapshotListener(new com.google.firebase.firestore.EventListener<QuerySnapshot>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                // focus here to get data and se them
                int counter = 0;
try {


    for (DocumentChange doc : queryDocumentSnapshots.getDocumentChanges()) {

        if (doc.getType() == DocumentChange.Type.ADDED) {

            counter++;
        }

    }
}catch (Exception ee){

}
                    noti_num.setText("" + counter);

            }
        });
        send_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent(container.getContext(), Choose.class);
                startActivity(sendIntent);

            }
        });
        show_camps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String noti_type = "camp";
                Intent intent = new Intent(container.getContext() , ShowNoti.class);
                intent.putExtra("noti_type", noti_type);
                startActivity(intent);
            }
        });
        show_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseFirestore.collection("Users").document(firebaseAuth.getCurrentUser().getUid()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        String response = documentSnapshot.getString("response");
                        String hp = documentSnapshot.getString("hospital");
                        Long counter = documentSnapshot.getLong("counter");
                        if (response.equalsIgnoreCase("no")) {

                            Intent showIntent = new Intent(container.getContext(), ShowNoti.class);
                            showIntent.putExtra("noti_type", "pat");
                            startActivity(showIntent);
                        }else if ( response.equalsIgnoreCase("yes")&& firebaseFirestore.collection("Notification").document(Long.toString(counter)).get() != null){
                            Intent last = null;


                                    last = new Intent(container.getContext(), MainActivity.class);




                            startActivity(last);
                        }
                    }
                });


            }
        });
        reneed_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reneed_intent = new Intent(container.getContext(),Reneed.class);
                startActivity(reneed_intent);
            }
        });



        return view ;
    }


}
