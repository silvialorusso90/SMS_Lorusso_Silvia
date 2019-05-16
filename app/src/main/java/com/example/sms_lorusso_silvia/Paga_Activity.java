package com.example.sms_lorusso_silvia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Paga_Activity extends AppCompatActivity {

    EditText nCarta, sCarta, cvvCarta;
    Button pagaBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paga);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setTitle("Dati pagamento");

        nCarta = (EditText) findViewById(R.id.nCartaTxt);
        sCarta = (EditText) findViewById(R.id.sCartaTxt);
        cvvCarta = (EditText) findViewById(R.id.cvvCartaTxt);
        pagaBtn = (Button) findViewById(R.id.btnPaga);
    }

    public void lanciaPagato(View view) {
        Intent i = new Intent(Paga_Activity.this, Pagato_Activity.class);
        startActivity(i);
    }
}
