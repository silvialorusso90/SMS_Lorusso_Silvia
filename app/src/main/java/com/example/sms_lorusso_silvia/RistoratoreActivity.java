package com.example.sms_lorusso_silvia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

public class RistoratoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ristoratore);
    }

    public void lanciaVisualizzaMenu(View view) {
        Intent intent1 = new Intent(this, Visualizza_menu_activity.class);
        startActivity(intent1);
    }

    public void lanciaModificaMenu(View view) {
        Intent intent1 = new Intent(this, Modifica_menu_activity.class);
        startActivity(intent1);
    }

    public void lanciaVisualizzaComande(View view) {
        Intent intent1 = new Intent(this, Visualizza_comande_activity.class);
        startActivity(intent1);
    }
}
