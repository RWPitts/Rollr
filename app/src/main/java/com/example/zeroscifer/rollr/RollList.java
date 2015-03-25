package com.example.zeroscifer.rollr;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class RollList extends ActionBarActivity{
    String game = "STO";

    DBHelper helper = null;
    SQLiteDatabase db = null;
    ContentValues values = null;

    public void addGame(View view) {


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_list);

        Typeface titleFont = Typeface.createFromAsset(getAssets(), "GoodDog.otf");
        helper = new DBHelper(this, "game_db2", null, 1);
        db = helper.getWritableDatabase();
        values = new ContentValues();

        Button back = (Button)findViewById(R.id.buttonBack);
        back.setTypeface(titleFont);

        Button add = (Button)findViewById(R.id.buttonAdd);
        add.setTypeface(titleFont);

        Cursor c = db.rawQuery("SELECT * FROM gametable g JOIN rolltable r ON g.name = r.name WHERE r.name = \"" + game + "\";", null);
        String[] from = new String[]{"rollname"};

        int[] to = { android.R.id.text1};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, c, from, to, 0);
        ListView listView = (ListView) findViewById(R.id.gameList);
        listView.setAdapter(adapter);
    }

    public void back(View view) {
        startActivity(new Intent(getApplicationContext(), gameList.class));
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (helper != null) {
            helper.close();
        }
    }
}