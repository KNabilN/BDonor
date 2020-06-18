package com.bd.android.emeblood.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bd.android.emeblood.UIS.firstIntro;
import com.bd.android.emeblood.UIS.secondIntro;
import com.bd.android.emeblood.UIS.thirdIntro;

public class IntroViewAdapter extends FragmentPagerAdapter {



    public IntroViewAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    firstIntro firstIntro = new firstIntro();
                    return firstIntro;
                case 1:
                    secondIntro sendFragment = new secondIntro();
                    return sendFragment ;
                case 2:
                    thirdIntro notiFragment = new thirdIntro();
                    return notiFragment;
                default:
                    return null ;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    }


