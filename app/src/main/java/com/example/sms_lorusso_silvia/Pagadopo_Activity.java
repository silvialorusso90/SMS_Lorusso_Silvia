package com.example.sms_lorusso_silvia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Pagadopo_Activity extends AppCompatActivity {

    TextView a;
    Button homeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagadopo_);

        setTitle("");

        a = (TextView) findViewById(R.id.textView7);
        homeBtn =(Button)findViewById(R.id.btnh);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Pagadopo_Activity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
