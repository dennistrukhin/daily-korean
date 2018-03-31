package com.whitekittyapps.dailykorean.navigation;


import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;

import com.whitekittyapps.dailykorean.Info;
import com.whitekittyapps.dailykorean.Quiz;
import com.whitekittyapps.dailykorean.R;
import com.whitekittyapps.dailykorean.TrainFragment;
import com.whitekittyapps.dailykorean.WordOfDay;

public class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener {

    private FragmentManager fm;
    private int activeFragmentId = R.id.navigation_home;

    public ItemSelectedListener(FragmentManager fragmentManager)
    {
        fm = fragmentManager;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment;
        FragmentTransaction ft;
        ft = fm.beginTransaction();
        switch (item.getItemId()) {
            case R.id.navigation_home:
                if (activeFragmentId == R.id.navigation_home) {
                    return false;
                }
                activeFragmentId = R.id.navigation_home;
                fragment = new WordOfDay();
                ft.replace(R.id.fragment_container, fragment, "tag").commit();
                return true;
            case R.id.navigation_dashboard:
                if (activeFragmentId == R.id.navigation_dashboard) {
                    return  false;
                }
                activeFragmentId = R.id.navigation_dashboard;
                fragment =  new TrainFragment();
                ft.replace(R.id.fragment_container, fragment, "tag").commit();
                return true;
            case R.id.navigation_quiz:
                if (activeFragmentId == R.id.navigation_quiz) {
                    return false;
                }
                activeFragmentId = R.id.navigation_quiz;
                fragment =  new Quiz();
                ft.replace(R.id.fragment_container, fragment, "tag").commit();
                return true;
            case R.id.navigation_info:
                if (activeFragmentId == R.id.navigation_info) {
                    return false;
                }
                activeFragmentId = R.id.navigation_info;
                fragment =  new Info();
                ft.replace(R.id.fragment_container, fragment, "tag").commit();
                return true;
        }
        return false;
    }

}
