package com.example.deathcalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.graphics.Color.*;

public class activity_2 extends AppCompatActivity {
    private android.widget.EditText Enter_guess;
    private Button guess;
    private TextView Result;
    private TextView attempts;
    private TextView score;
    private ConstraintLayout r;
    private Button replay;
    int d = 0;
    private Button history;
    private EditText wins;
    private EditText loss;
    public static final String sharedPref="sharedPref";
    int e = 0,f = 0;
    int i=0,j=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Enter_guess = (EditText) findViewById(R.id.etEnterGuess);
        guess = (Button) findViewById(R.id.guess);
        Result = (TextView) findViewById(R.id.result);
        attempts = (TextView) findViewById(R.id.attempts);
        score = (TextView) findViewById(R.id.score);
        r = (ConstraintLayout) findViewById(R.id.r);
        replay = (Button) findViewById(R.id.replay);
        history = (Button) findViewById(R.id.history);
        wins = (EditText) findViewById(R.id.wins);
        wins.setVisibility(View.INVISIBLE);
        loss = (EditText) findViewById(R.id.loss);
        loss.setVisibility(View.INVISIBLE);
        replay.setEnabled(false);
        final int getOrientation = getRequestedOrientation();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
        guess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Enter_guess.getText().toString().equals("")) {
                    Enter_guess.setError("please enter your guess");
                    Result.setVisibility(View.INVISIBLE);
                    score.setVisibility(View.INVISIBLE);
                    attempts.setVisibility(View.INVISIBLE);
                } else {

                    int b = Integer.parseInt(Enter_guess.getText().toString());
                    if ((b > 100) || (b == 0))
                        Enter_guess.setError("Enter guess between 1 to 100");
                    else {
                        int c = getIntent().getExtras().getInt("my_key");
                        d = d + 1;
                        if (b > c) {
                            Result.setVisibility(View.VISIBLE);
                            score.setVisibility(View.VISIBLE);
                            attempts.setVisibility(View.VISIBLE);
                            Result.setText("Your guess is HIGHER");
                            score.setEnabled(false);
                            Enter_guess.setText("");
                            if ((b - c) > 39)
                                r.setBackgroundColor(RED);
                            else if ((b - c) > 19 && (b - c) < 40)
                                r.setBackgroundColor(Color.parseColor("#e57373"));
                            else if ((b - c) > 15 && (b - c) < 20)
                                r.setBackgroundColor(Color.parseColor("#ffcdd2"));
                            else if ((b - c) > 9 && (b - c) < 16)
                                r.setBackgroundColor(Color.parseColor("#C8E6C9"));
                            else if ((b - c) < 10)
                                r.setBackgroundColor(Color.parseColor("#81C784"));
                        } else if (b < c) {
                            Result.setVisibility(View.VISIBLE);
                            score.setVisibility(View.VISIBLE);
                            attempts.setVisibility(View.VISIBLE);
                            Result.setText("Your guess is LOWER");
                            score.setEnabled(false);
                            Enter_guess.setText("");
                            if ((c - b) > 39)
                                r.setBackgroundColor(RED);
                            else if ((c - b) > 19 && (c - b) < 40)
                                r.setBackgroundColor(Color.parseColor("#e57373"));
                            else if ((c - b) > 15 && (c - b) < 20)
                                r.setBackgroundColor(Color.parseColor("#ffcdd2"));
                            else if ((c - b) > 9 && ((c - b) < 16))
                                r.setBackgroundColor(Color.parseColor("#C8E6C9"));
                            else if ((c - b) < 10)
                                r.setBackgroundColor(Color.parseColor("#81C784"));
                        } else {
                            Result.setVisibility(View.VISIBLE);
                            score.setVisibility(View.VISIBLE);
                            Result.setText("Congratulations,your guess is CORRECT");
                            guess.setEnabled(false);
                            attempts.setVisibility(View.INVISIBLE);
                            score.setEnabled(true);
                            score.setText("Your score is:" + d);
                            r.setBackgroundColor(Color.parseColor("#388E3C"));
                            setRequestedOrientation(getOrientation);
                            replay.setEnabled(true);
                            SharedPreferences sp=getSharedPreferences("sharedPref",MODE_PRIVATE);
                            int i=sp.getInt("pass",0)+1;
                            SharedPreferences.Editor editor=sp.edit();
                            editor.putInt("pass",i);
                            editor.apply();
                        }
                        attempts.setText("Number of guesses: " + d);
                        if (d > 10) {
                            score.setEnabled(false);
                            score.setText("LOST THE GAME");
                            Result.setVisibility(View.INVISIBLE);
                            guess.setEnabled(false);
                            attempts.setVisibility(View.INVISIBLE);
                            setRequestedOrientation(getOrientation);
                            replay.setEnabled(true);
                            SharedPreferences sp=getSharedPreferences("sharedPref",MODE_PRIVATE);
                            int j=sp.getInt("fail",0)+1;
                            SharedPreferences.Editor editor=sp.edit();
                            editor.putInt("fail",j);
                            editor.apply();
                        }

                    } }

            }


        });
        replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(activity_2.this, MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);

            }
        });

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loss.setVisibility(View.VISIBLE);
                wins.setVisibility(View.VISIBLE);
                SharedPreferences sp=getSharedPreferences("sharedPref",MODE_PRIVATE);
                wins.setText("Number of wins:"+sp.getInt("pass",0));
          loss.setText("Number of losses:"+sp.getInt("fail",0));

            }
        });

}
}


