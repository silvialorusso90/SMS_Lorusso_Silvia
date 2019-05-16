package com.example.sms_lorusso_silvia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class Pagato_Activity extends AppCompatActivity {

    TextView a, b, c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagato);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        a = (TextView)findViewById(R.id.textView4);
        b = (TextView)findViewById(R.id.textView5);
        c = (TextView)findViewById(R.id.textView6);
    }
}
