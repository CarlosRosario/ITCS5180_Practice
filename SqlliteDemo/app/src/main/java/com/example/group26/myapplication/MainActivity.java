package com.example.group26.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    DatabaseDataManager dm;

    @Override
    protected void onDestroy() {
        dm.close();
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dm = new DatabaseDataManager(this);
        dm.saveNote(new Note("CARLOS", "CARLOS IS AWESOME"));
        dm.saveNote(new Note("CARLOS", "CARLOS IS TIRED"));
        dm.saveNote(new Note("CARLOS", "CARLOS IS ANNOYED"));

        List<Note> notes = dm.getAllNotes();

        Log.d("demo", notes.toString());
    }
}
