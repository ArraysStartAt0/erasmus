package com.example.pc.staysafe.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by erasmus on 9.11.3017.
 */

/**
 * DATABASE INIT
 */

final class Helper extends SQLiteOpenHelper {

    //private static final String DATABASE_NAME = "note_database";
    private static final int DATABASE_VERSION = 1;

    public Helper(Context context) {
        super(context, "save_database", null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE question(note_id INTEGER PRIMARY KEY AUTO_INCREMENT, question TEXT NOT NULL, topic FOREIGN KEY REFERENCES topic(topic_id), language INT NOT NULL);");
        db.execSQL("CREATE TABLE answer(answer_id INTEGER PRIMARY KEY AUTO_INCREMENT, answer TEXT NOT NULL, correct INT NOT NULL);");
        db.execSQL("CREATE TABLE topic(topic_id INTEGER PRIMARY KEY AUTO_INCREMENT, topic TEXT NOT NULL);");
        db.execSQL("CREATE TABLE answer_has_question();");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
}
