package com.bd.android.emeblood.Adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bd.android.emeblood.R;
import com.bd.android.emeblood.UIS.ShowSecondStep;
import com.bd.android.emeblood.Users;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

//import com.bumptech.glide.Glide;
//import com.bumptech.glide.request.RequestOptions;

//import de.hdodenhof.circleimageview.CircleImageView;

public class UsersRecyclerAdapter extends RecyclerView.Adapter<UsersRecyclerAdapter.ViewHolder> {
      private List<Users> usersList;
      private Context context;
    private String hn_name;

    public UsersRecyclerAdapter(Context context , List<Users> usersList) {
        this.usersList = usersList;
        this.context = context ;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.users_layout, parent, false);
        return new ViewHolder(view);


    }

    @SuppressLint("CheckResult")
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

            hn_name = usersList.get(position).getHN();
            holder.h_name.setText(hn_name);


        final Long counter = usersList.get(position).userId;

        holder.cou.setText(""+counter);

//       //عشان اما اضغط على اليوزر view
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                String noti_type = "pat";



                Intent intent = new Intent ( context , ShowSecondStep.class);
                intent.putExtra("counter", counter);
                intent.putExtra("noti_type", noti_type);

                FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                firebaseFirestore.collection("Users").document(firebaseAuth.getCurrentUser().getUid()).update("counter", counter);
                firebaseFirestore.collection("Users").document(firebaseAuth.getCurrentUser().getUid()).update("hospital", hn_name);
                ((Activity)context).finish();
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {



        private View mView;
        private TextView h_name;
        private TextView cou;
        private TextView head;

        public ViewHolder(@NonNull View itemView) {
                super(itemView);
                mView = itemView;


                h_name = mView.findViewById(R.id.h_name);
                head = mView.findViewById(R.id.head);
                cou = mView.findViewById(R.id.cou);

        }
    }
}
