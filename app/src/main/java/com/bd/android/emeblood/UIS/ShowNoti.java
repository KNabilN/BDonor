package com.bd.android.emeblood.UIS;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.bd.android.emeblood.Adapters.CampsRecyclerAdapter;
import com.bd.android.emeblood.Adapters.UsersRecyclerAdapter;
import com.bd.android.emeblood.BloodTypes;
import com.bd.android.emeblood.Hospitals;
import com.bd.android.emeblood.R;
import com.bd.android.emeblood.Users;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Nullable;

public class ShowNoti extends AppCompatActivity {

    private RecyclerView mRecycleUsers;
    String noti_type;
    // list
    private List<Users> usersList;
    private UsersRecyclerAdapter usersRecyclerAdapter;
    private CampsRecyclerAdapter campsRecyclerAdapter;


    // عشان نجيب البيانات
    FirebaseFirestore firebaseFirestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.notification_recycler);

        mRecycleUsers = findViewById(R.id.usersView);
        mRecycleUsers.removeAllViews();
        mRecycleUsers.setHasFixedSize(true);
        mRecycleUsers.setLayoutManager(new LinearLayoutManager(ShowNoti.this));

        usersList = new ArrayList<>();
        if (getIntent().getStringExtra("noti_type") != null) {
            noti_type = getIntent().getStringExtra("noti_type");
            if (noti_type.equalsIgnoreCase("pat")) {
                usersRecyclerAdapter = new UsersRecyclerAdapter(ShowNoti.this, usersList);
                mRecycleUsers.setAdapter(usersRecyclerAdapter);
            } else if (noti_type.equalsIgnoreCase("camp")) {
                campsRecyclerAdapter = new CampsRecyclerAdapter(ShowNoti.this, usersList);
                mRecycleUsers.setAdapter(campsRecyclerAdapter);
            }

            usersList.clear();
            //get data
            firebaseFirestore = FirebaseFirestore.getInstance();
            if (noti_type.equalsIgnoreCase("pat")) {
                firebaseFirestore.collection("Notification").addSnapshotListener(this, new com.google.firebase.firestore.EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                        // focus here to get data and se them
                        assert queryDocumentSnapshots != null;
                        for (DocumentChange doc : queryDocumentSnapshots.getDocumentChanges()) {
                            usersList.clear();
                            if ( doc.getType()== DocumentChange.Type.ADDED) {

                                Long counter = doc.getDocument().getLong("counter");
                                assert counter != null;
                                Users users = doc.getDocument().toObject(Users.class).withId(counter);
                                usersList.add(users);

                            }

                            }
                        Collections.reverse(usersList);
                        usersRecyclerAdapter.notifyDataSetChanged();
                    }
                });
            } else if (noti_type.equalsIgnoreCase("camp")) {
                usersList.clear();
                firebaseFirestore.collection("Camps").addSnapshotListener(this, new com.google.firebase.firestore.EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                        // focus here to get data and se them
                        assert queryDocumentSnapshots != null;
                        usersList.clear();
                        for (DocumentChange doc : queryDocumentSnapshots.getDocumentChanges()) {
                            if (doc.getType() == DocumentChange.Type.ADDED) {
                                Long counter = doc.getDocument().getLong("counter");
                                assert counter != null;
                                Users users = doc.getDocument().toObject(Users.class).withId(counter);
                                usersList.add(users);
                            }
                        }

                        campsRecyclerAdapter.notifyDataSetChanged();
                    }
                });
            }
        }
        }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_Hospitals) {
            Intent intent = new Intent(ShowNoti.this, Hospitals.class);
            startActivity(intent);

        } else if (id == R.id.nav_btypes) {
            Intent intent = new Intent(ShowNoti.this, BloodTypes.class);
            startActivity(intent);

        } else {
            return super.onOptionsItemSelected(item);
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.drewer_menu, menu);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        usersList.clear();
        if (noti_type.equalsIgnoreCase("pat")) {
            usersList.clear();
            firebaseFirestore.collection("Notification").addSnapshotListener(this, new com.google.firebase.firestore.EventListener<QuerySnapshot>() {
                @Override
                public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                    // focus here to get data and se them
                    assert queryDocumentSnapshots != null;
                    usersList.clear();
                    for (DocumentChange doc : queryDocumentSnapshots.getDocumentChanges()) {

                        if ( doc.getType()== DocumentChange.Type.ADDED) {
                            Long counter = doc.getDocument().getLong("counter");
                            assert counter != null;


                            Users users = doc.getDocument().toObject(Users.class).withId(counter);
                            usersList.add(users);
                        }
                        }
                    Collections.reverse(usersList);

                    usersRecyclerAdapter.notifyDataSetChanged();
                    }

            });
        }else if (noti_type.equalsIgnoreCase("camp")) {
            firebaseFirestore.collection("Camps").addSnapshotListener(this, new com.google.firebase.firestore.EventListener<QuerySnapshot>() {
                @Override
                public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                    // focus here to get data and se them
                    assert queryDocumentSnapshots != null;
                    usersList.clear();
                    for (DocumentChange doc : queryDocumentSnapshots.getDocumentChanges()) {
                        if ( doc.getType()== DocumentChange.Type.ADDED) {
                            Long counter = doc.getDocument().getLong("counter");
                            assert counter != null;
                            Users users = doc.getDocument().toObject(Users.class).withId(counter);
                            usersList.add(users);
                        }

                    }

                    campsRecyclerAdapter.notifyDataSetChanged();
                }
            });
        }
    }
}