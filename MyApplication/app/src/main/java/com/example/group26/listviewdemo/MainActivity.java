package com.example.group26.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String[] colors = {"Red", "Blue", "Green", "White", "Black", "Orange", "Yellow"}; // unused at the moment.
    ArrayList<Color> colors2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        colors2 = new ArrayList<Color>();

        colors2.add(new Color("Black", "#000000"));
        colors2.add(new Color("Blue", "#0000FF"));
        colors2.add(new Color("Brown", "#654321"));
        colors2.add(new Color("Green", "#006600"));
        colors2.add(new Color("Orange", "#FF6600"));
        colors2.add(new Color("Red", "#FF0000"));
        colors2.add(new Color("Grey", "#BBBBBB"));

        ListView listView = (ListView)findViewById(R.id.listView1);
        //ArrayAdapter<Color> adapter = new ArrayAdapter<Color>(this, android.R.layout.simple_list_item_1, colors2); // use a standard android layout
        ColorAdapter adapter = new ColorAdapter(this, R.layout.row_item_layout, colors2); // use a custom layout
        listView.setAdapter(adapter);


        // demo 2 code:

        // notify view that dataset has updated so it can repaint itself
        adapter.setNotifyOnChange(true);

        // add a new color
        //adapter.add(new Color("Purple", "N/A"));
        //adapter.remove(colors2.get(0));
        //adapter.insert(new Color("Brown", "N/A"), 4);
        // end demo 2 code


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("demo", "Position " + position + ", Value " + colors2.get(position).toString());
            }
        });

    }
}
