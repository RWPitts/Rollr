package com.example.zeroscifer.rollr;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper  extends SQLiteOpenHelper {


    public DBHelper(Context context, String dBName, SQLiteDatabase.CursorFactory factory, int version ) {
        super(context, dBName, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase dB) {


        String createString =
                "CREATE TABLE IF NOT EXISTS gametable "
                        + "(_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + "name TEXT NOT NULL);";
        String createStringSecondary =
                "CREATE TABLE IF NOT EXISTS rolltable "
                        + "(_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "name TEXT NOT NULL," +
                        " rollname TEXT NOT NULL," +
                        " d2 INTEGER NOT NULL," +
                        " d4 INTEGER NOT NULL," +
                        " d6 INTEGER NOT NULL," +
                        " d9 INTEGER NOT NULL," +
                        " d12 INTEGER NOT NULL," +
                        " d20 INTEGER NOT NULL" +
                        ");";
        dB.execSQL(createString);
        dB.execSQL(createStringSecondary);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropString =
                "DROP TABLE IF EXISTS gametable;";
        String dropString2 =
                "DROP TABLE IF EXISTS rolltable;";
        db.execSQL(dropString);
        db.execSQL(dropString2);
        onCreate(db);
    }


}