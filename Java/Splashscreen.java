package com.cs2415.tempratureconversionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        Intent iHome=new Intent(Splashscreen.this,MainActivity.class);

        // Use a handler to delay the start of the main activity
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                startActivity(iHome);
                finish();
            }
        },1000);
    }
    }
