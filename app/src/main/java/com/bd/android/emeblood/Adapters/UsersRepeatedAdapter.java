package com.bd.android.emeblood.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bd.android.emeblood.R;
import com.bd.android.emeblood.UsersRe;

import java.util.List;

//import com.bumptech.glide.Glide;
//import com.bumptech.glide.request.RequestOptions;

//import de.hdodenhof.circleimageview.CircleImageView;

public class UsersRepeatedAdapter extends RecyclerView.Adapter<UsersRepeatedAdapter.ViewHolder> {
    private List<UsersRe> usersList;
    private Context context;
    String phone;

    public UsersRepeatedAdapter(Context context, List<UsersRe> usersList) {
        this.usersList = usersList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.users_relayout, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("CheckResult")
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final String name = usersList.get(position).getName();
        final String gov = usersList.get(position).getGov();


        holder.name_re.setText(name);
        holder.gov_re.setText(gov);
        final String phone_num = usersList.get(position).getPhone();






        holder.send_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent send = new Intent(Intent.ACTION_VIEW);
                send.setData(Uri.parse("smsto:"));
                send.setType("vnd.android-dir/mms-sms");
                send.putExtra("address"  , phone_num);
                try {
                    context.startActivity(send);

                    Log.i("Finished sending SMS...", "");
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(context,
                            "SMS faild, please try again later.", Toast.LENGTH_SHORT).show();
                }



            }
        });
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private View mView;
private TextView name_re ;
        private TextView gov_re ;
private ImageView send_message;
        public ViewHolder(@NonNull View itemView) {
                super(itemView);
                mView = itemView;

                name_re = mView.findViewById(R.id.name_re);
                send_message = mView.findViewById(R.id.send_message);
                gov_re = mView.findViewById(R.id.gove);



        }
    }
}
