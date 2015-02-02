package com.example.zeroscifer.rollr;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.Random;


public class quickMain extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quick_main, menu);
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

    public void onClickMain(View view) {
        Intent Quick = new Intent(getApplicationContext(), quickRollResult.class);
        int die = 0;

        switch(view.getId()) {
            case R.id.buttonD2:
                die = 2;
                break;
            case R.id.buttonD4:
                die = 4;
                break;
            case R.id.buttonD6:
                die = 6;
                break;
            case R.id.buttonD12:
                die = 12;
                break;
            case R.id.buttonD20:
                die = 20;
                break;
        }
        Quick.putExtra("die", die);
        startActivity(Quick);
        finish();
    }


}
