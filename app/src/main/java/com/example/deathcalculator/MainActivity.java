package com.example.deathcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{

    private EditText Enter_age;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Enter_age =( EditText)findViewById(R.id.etEnterNumber);
        button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              int a=Integer.parseInt(Enter_age.getText().toString());
                Intent intent = new Intent(MainActivity.this,activity_2.class);
                intent.putExtra("my_key",a);
                startActivity(intent);

            }
        });


        }
        }









