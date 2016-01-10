package com.crosario.mythirdandroidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public void clickFunction(View view){
        EditText usernameEditText = (EditText)findViewById(R.id.usernameEditText);
        EditText passwordEditText = (EditText)findViewById(R.id.passwordEditText);
        // added a comment
        // adding a second mfing comment
        Log.i("INFO", "username=" + usernameEditText.getText().toString() + " password=" + passwordEditText.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
