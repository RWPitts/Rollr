package com.example.zeroscifer.rollr;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
//import android.widget.ImageButton;
import android.widget.TextView;



public class quickMain extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_main);
        Typeface titleFont = Typeface.createFromAsset(getAssets(), "GoodDog.otf");
        TextView title = (TextView)findViewById(R.id.textViewQuickRoll);
        title.setTypeface(titleFont);
        //ImageButton back = (ImageButton)findViewById(R.id.buttonBack);
        //back.setTypeface(titleFont);

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
            case R.id.buttonD10:
                die = 10;
                break;
            case R.id.buttonD20:
                die = 20;
                break;
        }
        Quick.putExtra("die", die);
        startActivity(Quick);
        finish();
    }

    public void back(View view) {
        startActivity(new Intent(getApplicationContext(), Rollr.class));
        finish();
    }

}
