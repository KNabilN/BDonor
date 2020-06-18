package com.bd.android.emeblood.UIS;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bd.android.emeblood.BloodTypes;
import com.bd.android.emeblood.Hospitals;
import com.bd.android.emeblood.Adapters.PagerViewAdapter;
import com.bd.android.emeblood.R;
import com.bd.android.emeblood.UI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;


//implements NavigationView.OnNavigationItemSelectedListener
public class Option extends AppCompatActivity implements View.OnClickListener{

    public static final String NODE_NOTI = "notifications";

FirebaseAuth firebaseAuth ;

private TextView mUsers;
    private   TextView mNoti;
    private TextView mProfile;
    private ViewPager mMainpager;
    private TextView ot;
    private TextView not;
    private TextView pro;
    private LinearLayout LP;
    private LinearLayout LOT;
    private LinearLayout LN;


    FirebaseAuth mAuth ;
    private PagerViewAdapter mPagerViewAdapter;

    FirebaseFirestore mFireStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        mFireStore = FirebaseFirestore.getInstance();
        setContentView(R.layout.options);
        firebaseAuth = FirebaseAuth.getInstance();
        ot = findViewById(R.id.ot);
        not = findViewById(R.id.not);
        pro = findViewById(R.id.pro);
        mUsers = findViewById(R.id.users_label);
        mNoti = findViewById(R.id.notifications_label);
        LP = findViewById(R.id.LP);
        LN = findViewById(R.id.LN);
        LOT = findViewById(R.id.LOT);

        mProfile = findViewById(R.id.profile_label);
        mMainpager = findViewById(R.id.mainfragment);
        // create new adapter and initial it
        mPagerViewAdapter = new PagerViewAdapter(getSupportFragmentManager());
        mMainpager.setOffscreenPageLimit(2);
        // the view pager use the new adapter
        mMainpager.setAdapter(mPagerViewAdapter);
        // onchange
        mMainpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                // here we create a method to change textbox activation
                changeTabs(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //on click
        LP.setOnClickListener(this);
        LOT.setOnClickListener(this);
        LN.setOnClickListener(this);


    }




//

//    @Override
//  public void   onBackPressed () {
//        if ( drawer.isDrawerOpen(GravityCompat.START))
//        {
//            drawer.closeDrawer(GravityCompat.START);
//        }else{
//            super.onBackPressed();
//        }
//
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_Hospitals) {
            Intent intent = new Intent(Option.this, Hospitals.class);
            startActivity(intent);
finish();
        } else if (id == R.id.nav_btypes) {
            Intent intent = new Intent(Option.this, BloodTypes.class);
            startActivity(intent);

        }
        else if (id == R.id.nav_Logout) {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(Option.this, Activity2.class);
            startActivity(intent);
            finish();
        }
        else {
            return super.onOptionsItemSelected(item);
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.drewer_menu, menu);
        return true;
    }
    private void sendToStart(){
        Intent startIntent = new Intent(Option.this , UI.class);
        startActivity (startIntent);
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        // check if loged in

        FirebaseUser currentUser = firebaseAuth.getCurrentUser();

        if (currentUser == null) {
            sendToStart();
        }
    }

    private void changeTabs(int position) {
        if ( position == 0 )
        {
            mProfile.setTextColor(getResources().getColor(R.color.activite));
            mProfile.setTextSize(24);
            pro.setVisibility(View.VISIBLE);
            not.setVisibility(View.INVISIBLE);
            ot.setVisibility(View.INVISIBLE);
            mNoti.setTextSize(16);
            mNoti.setTextColor(getResources().getColor(R.color.deactivated));
            mUsers.setTextSize(16);
            mUsers.setTextColor(getResources().getColor(R.color.deactivated));
        } else if ( position == 1 ) {
            mUsers.setTextColor(getResources().getColor(R.color.activite));
            mUsers.setTextSize(24);
            not.setVisibility(View.VISIBLE);
            pro.setVisibility(View.INVISIBLE);
            ot.setVisibility(View.INVISIBLE);
            mNoti.setTextSize(16);
            mNoti.setTextColor(getResources().getColor(R.color.deactivated));
            mProfile.setTextSize(16);
            mProfile.setTextColor(getResources().getColor(R.color.deactivated));
        } else if ( position == 2 ) {
            mNoti.setTextColor(getResources().getColor(R.color.activite));
            mNoti.setTextSize(24);
            ot.setVisibility(View.VISIBLE);
            not.setVisibility(View.INVISIBLE);
            pro.setVisibility(View.INVISIBLE);
            mUsers.setTextSize(16);
            mUsers.setTextColor(getResources().getColor(R.color.deactivated));
            mProfile.setTextSize(16);
            mProfile.setTextColor(getResources().getColor(R.color.deactivated));
        }
    }

    @Override
    public void onClick(View view) {
        if (view == LP) {
            mMainpager.setCurrentItem(0);
        } else if (view == LN)
        {
            mMainpager.setCurrentItem(1);
        } else if ( view == LOT)
        {
            mMainpager.setCurrentItem(2);

        }
    }


    }

