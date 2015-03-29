package com.example.zeroscifer.rollr;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class NewRoll extends ActionBarActivity {
    int D2 = 0;
    int D4 = 0;
    int D6 = 0;
    int D10 = 0;
    int D12 = 0;
    int D20 = 0;
    private String strRoll;
    private String game;
    DBHelper helper = null;
    SQLiteDatabase db = null;
    ContentValues values = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_roll);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            game = extras.getString("game");
        }

        helper = new DBHelper(this, "game_db2", null, 1);
        db = helper.getWritableDatabase();
        values = new ContentValues();
    }

    public void addRoll(View view) {
        EditText rollname = (EditText)findViewById(R.id.rollName);
        strRoll = rollname.getText().toString();
        values.put("rollname", strRoll);
        values.put("name", game);
        values.put("d2", D2);
        values.put("d4", D4);
        values.put("d6", D6);
        values.put("d9", D10);
        values.put("d12", D12);
        values.put("d20", D20);
        db.insert("rolltable", "", values);
        values.clear();

        Intent addRoll = new Intent(getApplicationContext(), RollList.class);
        addRoll.putExtra("game", game);
        startActivity(addRoll);
        finish();
    }

    public void back(View view) {
        startActivity(new Intent(getApplicationContext(), RollList.class));
        finish();
    }
    public void D2Plus(View view) {
        D2++;
        if (D2 > 100) { D2 = 100; }
        TextView textView = (TextView) this.findViewById(R.id.textViewD2);
        textView.setText(String.valueOf(D2));
    }

    public void D2Minus(View view) {
        D2--;
        if (D2 < 0) { D2 = 0; }
        TextView textView = (TextView) this.findViewById(R.id.textViewD2);
        textView.setText(String.valueOf(D2));
    }

    public void D10Plus(View view) {
        D10++;
        if (D10 > 100) { D10 = 100; }
        TextView textView = (TextView) this.findViewById(R.id.textViewD10);
        textView.setText(String.valueOf(D10));
    }
    public void D10Minus(View view) {
        D10--;
        if (D10 < 0) { D10 = 0; }
        TextView textView = (TextView) this.findViewById(R.id.textViewD10);
        textView.setText(String.valueOf(D10));
    }

    public void D4Plus(View view) {
        D4++;
        if (D4 > 100) { D4 = 100; }
        TextView textView = (TextView) this.findViewById(R.id.textViewD4);
        textView.setText(String.valueOf(D4));
    }
    public void D4Minus(View view) {
        D4--;
        if (D4 < 0) { D4 = 0; }
        TextView textView = (TextView) this.findViewById(R.id.textViewD4);
        textView.setText(String.valueOf(D4));
    }

    public void D6Plus(View view) {
        D6++;
        if (D6 > 100) { D6 = 100; }
        TextView textView = (TextView) this.findViewById(R.id.textViewD6);
        textView.setText(String.valueOf(D6));
    }
    public void D6Minus(View view) {
        D6--;
        if (D6 < 0) { D6 = 0; }
        TextView textView = (TextView) this.findViewById(R.id.textViewD6);
        textView.setText(String.valueOf(D6));
    }

    public void D12Plus(View view) {
        D12++;
        if (D12 > 100) { D12 = 100; }
        TextView textView = (TextView) this.findViewById(R.id.textViewD12);
        textView.setText(String.valueOf(D12));
    }
    public void D12Minus(View view) {
        D12--;
        if (D12 < 0) { D12 = 0; }
        TextView textView = (TextView) this.findViewById(R.id.textViewD12);
        textView.setText(String.valueOf(D12));
    }

    public void D20Plus(View view) {
        D20++;
        if (D20 > 100) { D20 = 100; }
        TextView textView = (TextView) this.findViewById(R.id.textViewD20);
        textView.setText(String.valueOf(D20));
    }

    public void D20Minus(View view) {
        D20--;
        if (D20 < 0) { D20 = 0; }
        TextView textView = (TextView) this.findViewById(R.id.textViewD20);
        textView.setText(String.valueOf(D20));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (helper != null) {
            helper.close();
        }
    }
}
