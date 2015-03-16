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
        dB.execSQL(createString);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropString =
                "DROP TABLE IF EXISTS gametable;";
        db.execSQL(dropString);
        onCreate(db);
    }
}