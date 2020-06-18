package com.bd.android.emeblood.UIS;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bd.android.emeblood.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class thirdIntro extends Fragment {


    public thirdIntro() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       final View view = inflater.inflate(R.layout.fragment_third_intro, container, false);

       view.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(container.getContext(),Option.class);
               startActivity(intent);
               ((Activity)container.getContext()).finish();

           }
       });
       view.findViewById(R.id.f).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(container.getContext(),Option.class);
               startActivity(intent);
               ((Activity)container.getContext()).finish();
           }
       });
       return view;
    }


}
