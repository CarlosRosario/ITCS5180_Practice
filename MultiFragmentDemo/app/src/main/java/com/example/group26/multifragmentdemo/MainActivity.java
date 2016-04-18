package com.example.group26.multifragmentdemo;

import android.app.Fragment;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FirstFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getFragmentManager().beginTransaction().add(R.id.container, new FirstFragment(), "first").commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void gotoNextFragment() {

        getFragmentManager().beginTransaction().replace(R.id.container, new SecondFragment(), "second").addToBackStack(null).commit();

    }

    @Override
    public void onBackPressed() {
        if(getFragmentManager().getBackStackEntryCount() > 0){
            getFragmentManager().popBackStack();
        }
        else {
            super.onBackPressed();
        }

    }
}
