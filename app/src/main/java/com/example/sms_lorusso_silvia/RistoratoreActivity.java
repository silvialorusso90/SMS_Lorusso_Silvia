package com.example.sms_lorusso_silvia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

public class RistoratoreActivity extends AppCompatActivity {
    //private static final String LOG_TAG = RistoratoreActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ristoratore);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void lanciaVisualizzaMenu(View view) {
        //Log.d(LOG_TAG, "Button clicked!");
        Intent intent1 = new Intent(this, Visualizza_menu_activity.class);
        startActivity(intent1);
    }

    public void lanciaModificaMenu(View view) {
        //Log.d(LOG_TAG, "Button clicked!");
        Intent intent1 = new Intent(this, Modifica_menu_activity.class);
        startActivity(intent1);
    }

    public void lanciaVisualizzaComande(View view) {
        //Log.d(LOG_TAG, "Button clicked!");
        Intent intent1 = new Intent(this, Visualizza_comande_activity.class);
        startActivity(intent1);
    }
}
