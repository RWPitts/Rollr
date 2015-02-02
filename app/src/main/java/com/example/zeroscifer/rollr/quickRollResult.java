package com.example.zeroscifer.rollr;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class quickRollResult extends ActionBarActivity {
    int die;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_roll_result);
        int value = 0;

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            value = extras.getInt("die");
        }
        die = value;
        random(die);
        TextView textView = (TextView) this.findViewById(R.id.textResult);
        textView.setText(String.valueOf(random(value)));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quick_roll_result, menu);
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
    public int random(int max) {

        Random rn = new Random();
        return rn.nextInt(max) + 1;
    }

    public void reroll(View view) {
        TextView textView = (TextView) this.findViewById(R.id.textResult);
        textView.setText(String.valueOf(random(die)));
    }

    public void back(View view) {
        startActivity(new Intent(getApplicationContext(), quickMain.class));
        finish();
    }
}
