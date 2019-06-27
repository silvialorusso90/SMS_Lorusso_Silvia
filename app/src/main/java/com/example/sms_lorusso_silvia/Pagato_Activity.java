package com.example.sms_lorusso_silvia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Pagato_Activity extends AppCompatActivity {

    TextView a, b, c;
    Button homeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagato);

        a = (TextView)findViewById(R.id.textView4);
        b = (TextView)findViewById(R.id.textView5);
        c = (TextView)findViewById(R.id.textView6);
        homeBtn =(Button)findViewById(R.id.btnH);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Pagato_Activity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
