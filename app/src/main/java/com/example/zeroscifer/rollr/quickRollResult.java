package com.example.zeroscifer.rollr;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import java.util.Random;


public class quickRollResult extends ActionBarActivity {
    int die;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_roll_result);
        Typeface titleFont = Typeface.createFromAsset(getAssets(), "GoodDog.otf");
        TextView title = (TextView)findViewById(R.id.textRollResult);
        title.setTypeface(titleFont);
        TextView result = (TextView)findViewById(R.id.textResult);
        result.setTypeface(titleFont);


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

    public int random(int max) {

        Random rn = new Random();
        return rn.nextInt(max) + 1;
    }

    public void reroll(View view) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.roll);
        mp.start();
        TextView textView = (TextView) this.findViewById(R.id.textResult);
        textView.setText(String.valueOf(random(die)));

    }

    public void back(View view) {
        startActivity(new Intent(getApplicationContext(), quickMain.class));
        finish();
    }
}
