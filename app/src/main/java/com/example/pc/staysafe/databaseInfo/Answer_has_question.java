package com.example.pc.staysafe.databaseInfo;

import android.database.Cursor;

import com.example.pc.staysafe.model.Model;

public final class Answer_has_question {

    public final int answer_idanswer;
    public final int question_idquestion;

    public Answer_has_question(Cursor cursor){
        int answer_idanswer_index = cursor.getColumnIndex(Model.COL_ANSWER_IDANSWER);
        int question_idquestion_index = cursor.getColumnIndex(Model.COL_QUESTION_IDQUESTION);

        answer_idanswer = cursor.getInt(answer_idanswer_index);
        question_idquestion = cursor.getInt(question_idquestion_index);

    }

}
