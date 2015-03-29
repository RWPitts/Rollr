package com.example.zeroscifer.rollr;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;


public class RollList extends ActionBarActivity{
    String game = "";
    String message = "";

    DBHelper helper = null;
    SQLiteDatabase db = null;
    ContentValues values = null;

    public void addGame(View view) {

        Intent addRoll = new Intent(getApplicationContext(), NewRoll.class);
        addRoll.putExtra("game", game);
        startActivity(addRoll);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_list);

        Typeface titleFont = Typeface.createFromAsset(getAssets(), "GoodDog.otf");
        helper = new DBHelper(this, "game_db2", null, 1);
        db = helper.getWritableDatabase();
        values = new ContentValues();

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            game = extras.getString("game");
        }
        //Toast.makeText(getApplicationContext(), game, Toast.LENGTH_LONG).show();


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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent Quick = new Intent(getApplicationContext(), CustomRollResult.class);
                message = (String)((TextView) view).getText();

                //Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                Quick.putExtra("game", game);
                Quick.putExtra("roll", message);
                startActivity(Quick);
                finish();
            }
        });

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