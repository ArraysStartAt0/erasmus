package com.example.pc.staysafe.Connection;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pc.staysafe.Common.Quiz_Handler;
import com.example.pc.staysafe.Quiz.Answer;
import com.example.pc.staysafe.Quiz.Question;
import com.example.pc.staysafe.Quiz.Quiz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * Created by Alberto on 09/11/2017.
 */

public class Model {
    Helper helper;
    SQLiteDatabase database;
    public Model(Context context){
        helper = new Helper(context);
        database = helper.getWritableDatabase();
    }




    public Quiz getQuiz (int id, int Type,int Language){
        ArrayList<Answer> _Answer = new ArrayList<>();
        Question _Question = null;
       Cursor Question_Cursor = database.rawQuery(
                String.format("SELECT %s,%s,%s,%s FROM %s WHERE id = %s AND type = %s AND Language = %s;","Quiz_Handler","Answers","idquestions","questions","topic_idtopic","id","language",Integer.toString(Type),Integer.toString(Language)),null);


        if(Question_Cursor.moveToFirst()){
            do{
                    _Question = (new Question(Question_Cursor.getInt(Question_Cursor.getColumnIndex("ID")),Question_Cursor.getInt(Question_Cursor.getColumnIndex("topic_idtopic")),Question_Cursor.getString(Question_Cursor.getColumnIndex("question")),Question_Cursor.getInt(Question_Cursor.getColumnIndex("language")),0));
                Cursor Answer_Cursor = database.rawQuery(String.format("SELECT %s,%s FROM %s JOIN %s on %s = %s JOIN %s on %s = %s","answer","correct","answer","answer_has_question", "question.idquestion","answer_has_question.answer_idanswer", "answer", "answer.idanswer","question_idquestions"),null);
                if(Answer_Cursor.moveToFirst()){
                    do{
                       _Answer.add((new Answer(Answer_Cursor.getInt(Answer_Cursor.getColumnIndex("correct")),Answer_Cursor.getString(Answer_Cursor.getColumnIndex("Answer")))));
                    }while(Question_Cursor.moveToNext());
                }



            }while(Question_Cursor.moveToNext());
        }
        Quiz quiz = new Quiz(_Question,_Answer);

        return quiz;


    }
}
