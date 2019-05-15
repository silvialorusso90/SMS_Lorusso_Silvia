package com.example.sms_lorusso_silvia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Seconda_Activity extends AppCompatActivity {

    //private static final String LOG_TAG = A2Activity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seconda);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void lanciaRistoratoreAxctivity(View view) {
        //Log.d(LOG_TAG, "Button clicked!");
        Intent intent1 = new Intent(this, RistoratoreActivity.class);
        startActivity(intent1);
    }

    public void lanciaClienteActivity(View view) {
        //Log.d(LOG_TAG, "Button clicked!");
        Intent intent2 = new Intent(this, Cliente_Activity.class);
        startActivity(intent2);
    }
}
