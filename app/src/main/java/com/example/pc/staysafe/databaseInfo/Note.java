package com.example.pc.staysafe.databaseInfo;

import android.database.Cursor;

import com.example.pc.staysafe.model.Model;

public final class Note {

    public final String author;
    public final String title;
    public final String note;
    public final int id;

    public Note(Cursor cursor){
        int author_index = cursor.getColumnIndex(Model.COL_AUTHOR);
        int title_index = cursor.getColumnIndex(Model.COL_TITLE);
        int note_index = cursor.getColumnIndex(Model.COL_NOTE);
        int id_index = cursor.getColumnIndex(Model.COL_ID);

        id = cursor.getInt(id_index);
        author = cursor.getString(author_index);
        note = cursor.getString(note_index);
        title = cursor.getString(title_index);

    }

}
