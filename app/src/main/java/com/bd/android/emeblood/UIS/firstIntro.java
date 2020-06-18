package com.bd.android.emeblood.UIS;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bd.android.emeblood.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class firstIntro extends Fragment {


    public firstIntro() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first_intro, container, false);
    }

}
