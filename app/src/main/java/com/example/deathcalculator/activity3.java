package com.example.deathcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class activity3 extends AppCompatActivity {
    private TextView wins;
    private TextView losses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity3);
        wins=(TextView)findViewById(R.id.wins);
        losses=(TextView)findViewById(R.id.losses);
        int e=getIntent().getExtras().getInt("win");
        int f=getIntent().getExtras().getInt("losses");
        wins.setText("Number of wins:"+e);
        losses.setText("Number of losses"+f);
    }
}
