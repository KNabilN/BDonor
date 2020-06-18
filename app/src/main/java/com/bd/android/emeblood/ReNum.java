package com.bd.android.emeblood;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bd.android.emeblood.Adapters.UsersRepeatedAdapter;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Nullable;

public class ReNum extends AppCompatActivity {
    private RecyclerView mRecycleUsers;
    private List<UsersRe> usersList;
    private UsersRepeatedAdapter usersRecyclerAdapter;
    FirebaseFirestore firebaseFirestore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.notification_recycler);

        mRecycleUsers = findViewById(R.id.usersView);
        mRecycleUsers.removeAllViews();
        mRecycleUsers.setHasFixedSize(true);
        mRecycleUsers.setLayoutManager(new LinearLayoutManager(ReNum.this));

        usersList = new ArrayList<>();

        Collections.reverse(usersList);
        usersRecyclerAdapter = new UsersRepeatedAdapter(ReNum.this, usersList);

        mRecycleUsers.setAdapter(usersRecyclerAdapter);


        usersList.clear();
        //get data
        firebaseFirestore = FirebaseFirestore.getInstance();
        String which = getIntent().getStringExtra("blood_group");

            firebaseFirestore.collection(which).addSnapshotListener(this, new com.google.firebase.firestore.EventListener<QuerySnapshot>() {
                @Override
                public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                    // focus here to get data and se them
                    usersList.clear();

                        for (DocumentChange doc : queryDocumentSnapshots.getDocumentChanges()) {
                            if ( doc.getType()== DocumentChange.Type.ADDED) {
                                UsersRe users = doc.getDocument().toObject(UsersRe.class);
                                usersList.add(users);
                                Collections.reverse(usersList);
                                usersRecyclerAdapter.notifyDataSetChanged();
                            }
                        }
                    }



            });


    }

    @Override
    protected void onStart() {
        super.onStart();
        String which = getIntent().getStringExtra("blood_group");

            firebaseFirestore.collection(which).addSnapshotListener(this, new com.google.firebase.firestore.EventListener<QuerySnapshot>() {
                @Override
                public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                    // focus here to get data and se them
                    usersList.clear();

                    for (DocumentChange doc : queryDocumentSnapshots.getDocumentChanges()) {

                            if (doc.getType() == DocumentChange.Type.ADDED) {
                                UsersRe users = doc.getDocument().toObject(UsersRe.class);
                                usersList.add(users);

                                Collections.reverse(usersList);
                                usersRecyclerAdapter.notifyDataSetChanged();
                            }
                        }
                    }



            });

        }


}
