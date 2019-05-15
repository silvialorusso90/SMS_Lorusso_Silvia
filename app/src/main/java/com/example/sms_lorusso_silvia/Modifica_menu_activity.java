package com.example.sms_lorusso_silvia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

public class Modifica_menu_activity extends AppCompatActivity {

    private static final String LOG_TAG = Modifica_menu_activity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifica_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void lanciaAggiungiPiatto(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent1 = new Intent(this, Aggiungi_Piatto_Activity.class);
        startActivity(intent1);
    }

    public void lanciaRimuoviPiatto(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent2 = new Intent(this, Rimuovi_Piatto_Activity.class);
        startActivity(intent2);
    }
}
