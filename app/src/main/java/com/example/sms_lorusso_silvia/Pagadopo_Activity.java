package com.example.sms_lorusso_silvia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class Pagadopo_Activity extends AppCompatActivity {

    TextView a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagadopo_);

        setTitle("");

        a = (TextView) findViewById(R.id.textView7);
    }
}
