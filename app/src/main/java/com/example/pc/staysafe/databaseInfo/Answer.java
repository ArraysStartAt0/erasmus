package com.example.pc.staysafe.databaseInfo;

import android.database.Cursor;

import com.example.pc.staysafe.model.Model;

public final class Answer {

    public final String answer;
    public final int correct;
    public final int idanswer;

    public Answer(Cursor cursor){
        int answer_index = cursor.getColumnIndex(Model.COL_ANSWER);
        int correct_index = cursor.getColumnIndex(Model.COL_CORRECT);
        int idanswer_index = cursor.getColumnIndex(Model.COL_IDANSWER);

        idanswer = cursor.getInt(idanswer_index);
        correct = cursor.getInt(correct_index);
        answer = cursor.getString(answer_index);

    }

}
