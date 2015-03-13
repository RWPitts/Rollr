package com.example.zeroscifer.rollr;

import android.app.AlertDialog;
//import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
//import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
//import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
//import android.widget.ListView;
//import android.widget.TextView;
import android.widget.Toast;

//import java.util.ArrayList;
//import java.util.List;


public class gameList extends ActionBarActivity{

    private AlertDialog.Builder builder;
    private String strGame;
    //private ListView lv;
    //private ArrayList<String> al = new ArrayList<String>();

    public void addGame(View view) {

        builder = new AlertDialog.Builder(this);
        final EditText gameName = new EditText(this);
        strGame = null;

        /*
        Code for listview text colour IN PROGRESS (need AsyncTask)

        lv= (ListView) findViewById(R.id.gameList);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(gameList.this, R.layout.custom_textview, al);
        lv.setAdapter(adapter);

        CustomListAdapter listAdapter = new CustomListAdapter(gameList.this , R.layout.gameList , mList);
        mListView.setAdapter(listAdapter);
        */

        builder.setTitle("Add Game");
        builder.setMessage("Enter Game Name");
        builder.setView(gameName);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                strGame = gameName.getText().toString();
                Toast.makeText(getApplicationContext(), "Your game is: " + strGame, Toast.LENGTH_SHORT).show();

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Canceled", Toast.LENGTH_SHORT).show();

            }
        });

        AlertDialog dialogGameName = builder.create();
        dialogGameName.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_list);

        Typeface titleFont = Typeface.createFromAsset(getAssets(), "GoodDog.otf");

        Button back = (Button)findViewById(R.id.buttonBack);
        back.setTypeface(titleFont);

        Button add = (Button)findViewById(R.id.buttonAdd);
        add.setTypeface(titleFont);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void back(View view) {
        startActivity(new Intent(getApplicationContext(), Rollr.class));
        finish();
    }
}
/*
class CustomListAdapter extends ArrayAdapter {

    private Context mContext;
    private int id;
    private List<String> items;

    public CustomListAdapter(Context context, int textViewResourceId, List<String> list) {
        super(context, textViewResourceId, list);
        mContext = context;
        id = textViewResourceId;
        items = list;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        View mView = v;
        if (mView == null) {
            LayoutInflater vi = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mView = vi.inflate(id, null);
        }

        TextView text = (TextView) mView.findViewById(R.id.tv);

        if (items.get(position) != null) {
            text.setTextColor(Color.WHITE);
            text.setText(items.get(position));

        }

        return mView;
    }
}
]
*/