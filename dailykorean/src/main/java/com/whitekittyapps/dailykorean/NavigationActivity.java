package com.whitekittyapps.dailykorean;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;

import com.whitekittyapps.dailykorean.navigation.ItemSelectedListener;

public class NavigationActivity extends AppCompatActivity implements
        WordOfDay.OnFragmentInteractionListener,
        TrainFragment.OnFragmentInteractionListener,
        Quiz.OnFragmentInteractionListener,
        Info.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new WordOfDay()).commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new ItemSelectedListener(getSupportFragmentManager()));
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
