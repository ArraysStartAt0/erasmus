package com.example.pc.staysafe.databaseInfo;

import android.database.Cursor;

import com.example.pc.staysafe.model.Model;

public final class Question {

    public final int idquestion;
    public final String question;
    public final int topic_idtopic;
    public final int language;

    public Question(Cursor cursor){
        int idquestion_index = cursor.getColumnIndex(Model.COL_IDQUESTION);
        int question_index = cursor.getColumnIndex(Model.COL_INDEX);
        int topic_idtopic_index = cursor.getColumnIndex(Model.COL_TOPIC_IDTOPIC);
        int language_index = cursor.getColumnIndex(Model.COL_INDEX);

        idquestion = cursor.getInt(idquestion_index);
        question = cursor.getString(question_index);
        topic_idtopic = cursor.getInt(topic_idtopic_index);
        language = cursor.getInt(language_index);

    }

}
