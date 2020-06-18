package com.bd.android.emeblood.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bd.android.emeblood.NotificationsPack.NotificationsFragment;
import com.bd.android.emeblood.UIS.ProfileFragment;
import com.bd.android.emeblood.UIS.SendNotificationsFragment;

public class PagerViewAdapter extends FragmentPagerAdapter {



    public PagerViewAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    ProfileFragment profileFragment = new ProfileFragment();
                    return profileFragment;
                case 1:
                    SendNotificationsFragment sendFragment = new SendNotificationsFragment();
                    return sendFragment ;
                case 2:
                    NotificationsFragment notiFragment = new NotificationsFragment();
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


