package com.example.group26.myapplication;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Carlos on 3/14/2016.
 */
public class DatabaseOpenHelper extends SQLiteOpenHelper {

    static final String DB_NAME = "mynotes.db";
    static final int DB_VERSION = 1;


    public DatabaseOpenHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

//    public DatabaseOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
//        super(context, name, factory, version, errorHandler);
//    }


    // Called if did not already exist.
    @Override
    public void onCreate(SQLiteDatabase db) {
        NotesTable.onCreate(db);
    }

    // Called if database exists AND the newVersion > oldVersion
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        NotesTable.onUpdate(db, oldVersion, newVersion);
    }


}
