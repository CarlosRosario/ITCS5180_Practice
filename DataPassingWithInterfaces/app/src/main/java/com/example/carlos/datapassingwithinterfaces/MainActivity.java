package com.example.carlos.datapassingwithinterfaces;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity implements GetTweetsAsyncTask.IData {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new GetTweetsAsyncTask(this).execute("some url...");
    }

    @Override
    public void setupData(LinkedList<String> data){

        // set up data
        ListView listview = (ListView)findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, data);
        listview.setAdapter(adapter);

    }

    @Override
    public Context getContext() {
        return this;
    }
}
