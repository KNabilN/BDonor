package com.bd.android.emeblood.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bd.android.emeblood.R;
import com.bd.android.emeblood.Users;

import java.util.List;

public class CampsRecyclerAdapter extends RecyclerView.Adapter<CampsRecyclerAdapter.ViewHolder> {
      private List<Users> usersList;
      private Context context;

    public CampsRecyclerAdapter(Context context , List<Users> usersList) {
        this.usersList = usersList;
        this.context = context ;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.camps_layout, parent, false);
        return new ViewHolder(view);


    }

    @SuppressLint("CheckResult")
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

         final String mess = usersList.get(position).getMessage();
         holder.messagecamp.setText(mess);

    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private View mView;
        private TextView messagecamp;

        public ViewHolder(@NonNull View itemView) {
                super(itemView);
                mView = itemView;
                messagecamp = mView.findViewById(R.id.messagecamp);

        }
    }
}
