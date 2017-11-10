package com.example.pc.staysafe.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pc.staysafe.databaseInfo.Note;
import com.example.pc.staysafe.model.Model;

import java.util.ArrayList;

/**
 * Created by erasmus on 9.11.2017.
 */

public final class Model {
    private final Helper helper;
    private final SQLiteDatabase database;

    //Construct itself
     public Model(Context context) {
        helper = new Helper(context);
        database = helper.getWritableDatabase();
    }
    // Columns
    public static String COL_ID = "note_id";
    public static String COL_TITLE = "title";
    public static String COL_AUTHOR = "author";
    public static String COL_NOTE = "note";
    private final String TABLE_NAME ="note";

    public void insertNote(String author, String title, String note) {
        String SQL = String.format("INSERT INTO %s (%s, %s, %s) VALUES(?, ?, ?);",
                TABLE_NAME, COL_AUTHOR, COL_TITLE, COL_NOTE);
        database.execSQL(SQL, new String[] {author, title, note});
    }


    public ArrayList<Note> fetchAllNotes() {
        ArrayList<Note> arrayList = new ArrayList<>();

        String SQL = String.format("SELECT %s, %s, %s, %s FROM %s;",
                COL_ID, COL_AUTHOR, COL_TITLE, COL_NOTE, TABLE_NAME);

        Cursor cursor = database.rawQuery(SQL, new String[]{});

        if (cursor.moveToFirst()) {
            do {
                arrayList.add(new Note(cursor));
            } while (cursor.moveToNext());

        }

        return arrayList;
    }

}
