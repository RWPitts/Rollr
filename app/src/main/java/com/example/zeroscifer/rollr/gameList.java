package com.example.zeroscifer.rollr;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
//import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
//import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class gameList extends ActionBarActivity{

    private AlertDialog.Builder builder;
    private String strGame;
    DBHelper helper = null;
    SQLiteDatabase db = null;
    ContentValues values = null;
    String[] from;

    public void addGame(View view) {

        builder = new AlertDialog.Builder(this);
        final EditText gameName = new EditText(this);
        strGame = null;


        builder.setTitle("Add Game");
        builder.setMessage("Enter Game Name");
        builder.setView(gameName);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                strGame = gameName.getText().toString();
                values.put("name", strGame);
                db.insert("gametable", "", values);
                listViewUpdate();
                values.clear();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog dialogGameName = builder.create();
        dialogGameName.show();

    }

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_list);

        //Typeface titleFont = Typeface.createFromAsset(getAssets(), "GoodDog.otf");
        helper = new DBHelper(this, "game_db2", null, 1);
        db = helper.getWritableDatabase();
        values = new ContentValues();

        /*
        Button back = (Button)findViewById(R.id.buttonBack);
        back.setTypeface(titleFont);

        Button add = (Button)findViewById(R.id.buttonAdd);
        add.setTypeface(titleFont);
        */
        listViewUpdate();

    }

    public void back(View view) {
        startActivity(new Intent(getApplicationContext(), Rollr.class));
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (helper != null) {
            helper.close();
        }
    }

    public void listViewUpdate() {

        Cursor c = db.rawQuery("SELECT * FROM gametable;", null);
        from = new String[]{"name"};

        int[] to = { android.R.id.text1};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, c, from, to, 0);
        ListView listView = (ListView) findViewById(R.id.gameList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent Quick = new Intent(getApplicationContext(), RollList.class);
                String message = (String)((TextView) view).getText();

                //Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                Quick.putExtra("game", message);
                startActivity(Quick);

                finish();
            }
        });
    }
}
