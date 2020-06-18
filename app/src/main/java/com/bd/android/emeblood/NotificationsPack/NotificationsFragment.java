package com.bd.android.emeblood.NotificationsPack;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bd.android.emeblood.BloodTypes;
import com.bd.android.emeblood.Hospitals;
import com.bd.android.emeblood.MedicalInfo;
import com.bd.android.emeblood.UIS.News;
import com.bd.android.emeblood.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationsFragment extends Fragment {
TextView show_text ;

    public NotificationsFragment() {
        // Required empty public constructor
    }

private TextView blood_frag;

    private TextView news_frag;

    private TextView hospitals_frag;

    private TextView medical_info_frag;



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notifications, container, false);
blood_frag = view.findViewById(R.id.blood_type_frag);
        news_frag = view.findViewById(R.id.news_frag);
        hospitals_frag = view.findViewById(R.id.hospitals_frag);
        medical_info_frag = view.findViewById(R.id.medical_info_frag);

blood_frag.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(container.getContext() , BloodTypes.class);
        startActivity(intent);

    }
});
        hospitals_frag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(container.getContext() , Hospitals.class);
                startActivity(intent);
            }
        });
        news_frag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(container.getContext() , News.class);
                startActivity(intent);

            }
        });
        medical_info_frag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(container.getContext() , MedicalInfo.class);
                startActivity(intent);
            }
        });
        return view ;
    }

}
