package com.example.zeroscifer.rollr;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class NewRoll extends ActionBarActivity {
    int D2 = 0;
    int D4 = 0;
    int D6 = 0;
    int D10 = 0;
    int D12 = 0;
    int D20 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_roll);
    }

    public void onClickMain(View view) {

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
}
