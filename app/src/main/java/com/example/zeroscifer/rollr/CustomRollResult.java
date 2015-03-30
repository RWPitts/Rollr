package com.example.zeroscifer.rollr;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.Random;



public class CustomRollResult extends ActionBarActivity {
    String game = null;
    String roll = null;

    int D2 = 0;
    int D4 = 0;
    int D6 = 0;
    int D10 = 0;
    int D12 = 0;
    int D20 = 0;
    int value = 0;

    DBHelper helper = null;
    SQLiteDatabase db = null;
    ContentValues values = null;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_roll_result);

        setContentView(R.layout.activity_quick_roll_result);
        Typeface titleFont = Typeface.createFromAsset(getAssets(), "GoodDog.otf");
        TextView title = (TextView)findViewById(R.id.textRollResult);
        title.setTypeface(titleFont);
        TextView result = (TextView)findViewById(R.id.textResult);
        result.setTypeface(titleFont);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            game = extras.getString("game");
            roll = extras.getString("roll");
        }


        helper = new DBHelper(this, "game_db2", null, 1);
        db = helper.getWritableDatabase();
        values = new ContentValues();
        Cursor c = db.rawQuery("SELECT * FROM rolltable WHERE name = \"" + game + "\" AND rollname = \"" + roll + "\";", null);

        c.moveToFirst();
        D2 = c.getInt(3);
        D4 = c.getInt(4);
        D6 = c.getInt(5);
        D10 = c.getInt(6);
        D12 = c.getInt(7);
        D20 = c.getInt(8);

        for (int i = 0; i < D2; i++ ) {
            value += random(2);
        }
        for (int i = 0; i < D4; i++ ) {
            value += random(4);
        }
        for (int i = 0; i < D6; i++ ) {
            value += random(6);
        }
        for (int i = 0; i < D10; i++ ) {
            value += random(10);
        }
        for (int i = 0; i < D12; i++ ) {
            value += random(12);
        }
        for (int i = 0; i < D20; i++ ) {
            value += random(20);
        }
        textView = (TextView) this.findViewById(R.id.textResult);
        textView.setText(String.valueOf(value));
    }

    public void reroll(View view) {
        value = 0;
        for (int i = 0; i < D2; i++ ) {
            value += random(2);
        }
        for (int i = 0; i < D4; i++ ) {
            value += random(4);
        }
        for (int i = 0; i < D6; i++ ) {
            value += random(6);
        }
        for (int i = 0; i < D10; i++ ) {
            value += random(10);
        }
        for (int i = 0; i < D12; i++ ) {
            value += random(12);
        }
        for (int i = 0; i < D20; i++ ) {
            value += random(20);
        }
        textView = (TextView) this.findViewById(R.id.textResult);
        textView.setText(String.valueOf(value));
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.roll);
        mp.start();
    }

    public int random(int max) {
        Random rn = new Random();
        return rn.nextInt(max) + 1;
    }

    public void back(View view) {
        Intent Quick = new Intent(getApplicationContext(), RollList.class);
        Quick.putExtra("game", game);
        Quick.putExtra("roll", roll);
        startActivity(Quick);
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
