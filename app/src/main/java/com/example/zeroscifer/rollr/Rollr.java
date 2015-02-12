package com.example.zeroscifer.rollr;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Rollr extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rollr);
        Typeface titleFont = Typeface.createFromAsset(getAssets(), "GoodDog.otf");
        //Button quickRoll = (Button)findViewById(R.id.buttonGames);
        //Button settings = (Button)findViewById(R.id.buttonSet);
        //quickRoll.setTypeface(titleFont);
        //settings.setTypeface(titleFont);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_rollr, menu);
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

    public void onClickQuickRoll(View view) {
        startActivity(new Intent(getApplicationContext(), quickMain.class));
        finish();
    }

    public void onClickGames(View view) {
        startActivity(new Intent(getApplicationContext(), gameList.class));
        finish();
    }
}
