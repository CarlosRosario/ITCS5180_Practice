package com.example.group26.myapplication;

import android.app.Fragment;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AFragment.OnFragmentTextChange{

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("demo", "MainActivity: onStart");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("demo", "MainActivity: onCreate before inflating layout");
        setContentView(R.layout.activity_main);
        Log.d("demo", "MainActivity: onCreate after inflating layout");

        getFragmentManager().beginTransaction().add(R.id.fragmentContainer, new AFragment(), "tag_afragment1").commit();
        getFragmentManager().beginTransaction().add(R.id.fragmentContainer, new AFragment(), "tag_afragment2").commit();

        RadioGroup rg = (RadioGroup)findViewById(R.id.radioGroup);
        //noinspection ConstantConditions
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                //AFragment f = (AFragment)getFragmentManager().findFragmentById(R.id.fragment);
                AFragment f1 = (AFragment)getFragmentManager().findFragmentByTag("tag_afragment1");
                AFragment f2 = (AFragment)getFragmentManager().findFragmentByTag("tag_afragment2");

                if(f1!= null){
                    if(checkedId == R.id.radioButtonRed){
                        f1.changeColor(Color.RED);
                    }
                    else if(checkedId == R.id.radioButtonGreen){
                        f1.changeColor(Color.GREEN);
                    }
                    else if(checkedId == R.id.radioButtonBlue){
                        f1.changeColor(Color.BLUE);
                    }
                }

                if(f2!= null){
                    if(checkedId == R.id.radioButtonRed){
                        f2.changeColor(Color.RED);
                    }
                    else if(checkedId == R.id.radioButtonGreen){
                        f2.changeColor(Color.GREEN);
                    }
                    else if(checkedId == R.id.radioButtonBlue){
                        f2.changeColor(Color.BLUE);
                    }
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("demo", "MainActivity: onDestroy");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("demo", "MainActivity: onResume");
    }

    @Override
    public void onTextChanged(String text) {
        TextView tv = (TextView)findViewById(R.id.textView);
        tv.setText(text);
    }
}
