package com.example.group26.myapplication;

import android.database.sqlite.SQLiteDatabase;
import android.database.SQLException;
/**
 * Created by Carlos on 3/14/2016.
 */
public class NotesTable {

    static final String TABLENAME = "notes";
    static final String COLUMN_ID = "_id";
    static final String COLUMN_SUBJECT = "subject";
    static final String COLUMN_TEXT = "text";

    static public void onCreate(SQLiteDatabase db){
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE " + TABLENAME + " (");
        sb.append(COLUMN_ID + " integer primary key autoincrement, ");
        sb.append(COLUMN_SUBJECT + " text not null, ");
        sb.append(COLUMN_TEXT + " text not null);");


        try {
            db.execSQL(sb.toString());
        } catch (SQLException ex){
            ex.printStackTrace();
        }

    }

    static public void onUpdate(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABLENAME);
        NotesTable.onCreate(db);
    }
}
