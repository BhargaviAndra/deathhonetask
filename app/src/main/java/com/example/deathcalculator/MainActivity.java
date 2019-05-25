package com.example.deathcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private Button button;
    private EditText enter_age;
    int a;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
       enter_age= (EditText) findViewById(R.id.enter_age);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(enter_age.length()==0)
                    enter_age.setError("Please Enter age");
                else
                    {
                    a=Integer.parseInt(enter_age.getText().toString());
                    if((a>100)||(a==0))
                    {
                        enter_age.setError("Please enter age betwwn 1 to 100");
                    }
                    else
                    {
                        Intent intent = new Intent(MainActivity.this, activity_2.class);
                    intent.putExtra("my_key", a);
                    startActivity(intent);
                }
                    }

        }
        });


        }
        }









