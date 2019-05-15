package com.example.sms_lorusso_silvia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

public class Cliente_Activity extends AppCompatActivity {

    private static final String LOG_TAG = Cliente_Activity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void lanciaOrdineCliente(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent1 = new Intent(this, Ordina_Ins_Cliente_Activity.class);
        startActivity(intent1);
    }
}
