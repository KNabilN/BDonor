package com.bd.android.emeblood.UIS;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bd.android.emeblood.Adapters.IntroViewAdapter;
import com.bd.android.emeblood.R;

public class IntroFrag extends AppCompatActivity implements View.OnClickListener {
    private IntroViewAdapter mPagerViewAdapter;
    private ViewPager mMainpager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_frag);
        mMainpager = findViewById(R.id.introfragment);
        mPagerViewAdapter = new IntroViewAdapter(getSupportFragmentManager());
        mMainpager.setOffscreenPageLimit(2);
        // the view pager use the new adapter
        mMainpager.setAdapter(mPagerViewAdapter);
        mMainpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                // here we create a method to change textbox activation

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
    @Override
    public void onClick(View view) {
        if (mMainpager.getCurrentItem()==0) {

            mMainpager.setCurrentItem(1);
        } else if ( mMainpager.getCurrentItem()==1)
        {
            mMainpager.setCurrentItem(2);

        }
    }

}
