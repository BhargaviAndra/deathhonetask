package com.example.deathcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class activity_2 extends AppCompatActivity
{ private android.widget.EditText Enter_guess;
  private Button guess;
  private TextView Result;
  private TextView attempts;
  private TextView score;
  int d=0;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Enter_guess = (EditText)findViewById(R.id.etEnterGuess);
        guess = (Button)findViewById(R.id.guess);
        Result =(TextView)findViewById(R.id.result);
        attempts =(TextView)findViewById(R.id.attempts);
        score=(TextView)findViewById(R.id.score);
        guess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                d = d + 1;
                int b = Integer.parseInt(Enter_guess.getText().toString());
                int c = getIntent().getExtras().getInt("my_key");

                if (b > c) {
                    Result.setText("Your guess is HIGHER");
                    score.setEnabled(false);
                    Enter_guess.setText("");
                }
                else if (b < c) {
                    Result.setText("Your guess is LOWER");
                     score.setEnabled(false);
                     Enter_guess.setText("");
                }else {
                    Result.setText("Congratulations,your guess is CORRECT");
                    guess.setEnabled(false);
                    attempts.setVisibility(View.INVISIBLE);
                    score.setEnabled(true);
                    score.setText("Your score is:" +d);
                }
                attempts.setText("Number of guesses: " + d);
                if(d>=10) {
                    score.setEnabled(true);
                    score.setText("LOST THE GAME");
                    guess.setEnabled(false);
                    attempts.setVisibility(View.INVISIBLE);
                }

            }

        });

            }
        }