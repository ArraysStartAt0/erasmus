package com.example.pc.staysafe.databaseInfo;

import android.database.Cursor;

import com.example.pc.staysafe.model.Model;

public final class Topic {

    public final int idtopic;
    public final String topic;

    public Topic(Cursor cursor){
        int idtopic_index = cursor.getColumnIndex(Model.COL_IDTOPIC);
        int topic_index = cursor.getColumnIndex(Model.COL_TOPIC);

        idtopic = cursor.getInt(idtopic_index);
        topic = cursor.getString(topic_index);


    }

}
