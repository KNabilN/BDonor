package com.bd.android.emeblood.UIS;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bd.android.emeblood.R;
import com.bd.android.emeblood.Update;
import com.bd.android.emeblood.Who;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

//    private CircleImageView circleImageView;

    ProgressBar progressBar;
    String gov ;
    private FirebaseAuth mAuth;
    private TextView profile_name;
    String user_blood_type;
    String user_name;
    private TextView signout;
    private TextView updates_text;

    private TextView blood_type_profile;
    //    private CircleImageView profile_image;
    FirebaseFirestore mFireStore ;
    String userID;
    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        mAuth = FirebaseAuth.getInstance();

//     profile_image = view.findViewById(R.id.profile_image);
        profile_name = view.findViewById(R.id.profile_name);
        blood_type_profile = view.findViewById(R.id.blood_type_profile);
//        circleImageView = view.findViewById(R.id.circle);

        progressBar = view.findViewById(R.id.progbar);
        progressBar.setVisibility(View.VISIBLE);
        updates_text = view.findViewById(R.id.update_text);
        //عشان نجيب البيانات من مكان تخزينها
        mFireStore = FirebaseFirestore.getInstance();
        view.findViewById(R.id.who).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Who.class);
                startActivity(intent);
            }
        });

        // الاكونت الحالي
        if ( mAuth.getCurrentUser() != null) {
            userID   = mAuth.getCurrentUser().getUid();

// حدد المكان بالتحديد
            mFireStore.collection("Users").document(userID).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @SuppressLint("CheckResult")
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    //هات البيانات بقى من مفتاحها الاخير في الوثائق
                   user_name = documentSnapshot.getString("name");
                   if (documentSnapshot.getString("blood") != null ) {
                       user_blood_type = documentSnapshot.getString("blood");
                   }else{
                       user_blood_type = "NON";
                   }
                    gov =documentSnapshot.getString("gov");

                    profile_name.setText(user_name);
                    progressBar.setVisibility(View.GONE);

                    blood_type_profile.setText(user_blood_type);
                    if(user_blood_type.equalsIgnoreCase("non")){
                        updates_text.setVisibility(View.VISIBLE);
                    }else{
                        updates_text.setVisibility(View.GONE);
                    }

           }
            });


            view.findViewById(R.id.settings).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent goset = new Intent(getContext(), Settings.class);
                    startActivity(goset);
                }
            });




            updates_text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent updateIntent = new Intent(container.getContext(), Update.class);
                    startActivity(updateIntent);
                }
            });

            signout = view.findViewById(R.id.logout);
            signout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(container.getContext(), Activity2.class);
                    delete();
                    startActivity(intent);




                }
            });
        }


        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        if ( mAuth.getCurrentUser() != null) {
            mFireStore.collection("Users").document(userID).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @SuppressLint("CheckResult")
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    //هات البيانات بقى من مفتاحها الاخير في الوثائق
                    user_name = documentSnapshot.getString("name");
                    if (documentSnapshot.getString("blood") != null ) {
                        user_blood_type = documentSnapshot.getString("blood");
                    }else{
                        user_blood_type = "NON";
                    }
                    gov =documentSnapshot.getString("gov");

                    profile_name.setText(user_name);


                    blood_type_profile.setText(user_blood_type);
                    progressBar.setVisibility(View.GONE);

 }
            });
        }




            // check if loged in


            }
    private void delete() {

        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if ( task.isSuccessful()){
                            DatabaseReference dbUsers = FirebaseDatabase.getInstance().getReference(gov);

                            dbUsers.child(mAuth.getCurrentUser().getUid())
                                    .removeValue();
                        }


                    }
                });
    }


}
