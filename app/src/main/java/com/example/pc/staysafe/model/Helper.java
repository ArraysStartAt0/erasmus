package com.example.pc.staysafe.Connection;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Alberto on 09/11/2017.
 */

public class Helper extends SQLiteOpenHelper{

    private static final String DB_Name = "Database.sqlite";
    public Helper(Context context){
        super(context, DB_Name, null, 1 );

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
       sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `question` ( `ID` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, `Question` TEXT NOT NULL, `IDTopic` INTEGER NOT NULL, `IDLanguage` INTEGER NOT NULL)");
                sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `Topic` ( `IDTopic` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, `Topic` TEXT NOT NULL);");
                sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `Answer_Question` ( `IDAnswer` INTEGER NOT NULL, `IDQuestion` INTEGER NOT NULL, PRIMARY KEY(`IDAnswer`,`IDQuestion`);");
                sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `Answer` ( `IDAnswer` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, `Answer` TEXT NOT NULL, `Correct` INTEGER NOT NULL);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //IF NEW VERSION IS AVAILABLE
    }
}
