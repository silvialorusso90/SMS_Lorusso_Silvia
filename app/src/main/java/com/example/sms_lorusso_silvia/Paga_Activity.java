package com.example.sms_lorusso_silvia;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Paga_Activity extends AppCompatActivity {

    EditText nCartaT, sCartaT, cvvCartaT;
    Button pagaBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paga);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //setTitle("Dati pagamento");

        initUI();


    }

    private void initUI() {

        nCartaT = (EditText) findViewById(R.id.nCartaTxt);
        sCartaT = (EditText) findViewById(R.id.sCartaTxt);
        cvvCartaT = (EditText) findViewById(R.id.cvvCartaTxt);
        pagaBtn = (Button) findViewById(R.id.btnPaga);

        pagaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paga();
            }
        });
    }

    private void paga(){

        String nCarta = nCartaT.getText().toString();
        String sCarta = sCartaT.getText().toString();
        String cvvCarta = cvvCartaT.getText().toString();

        //Validazione dati
        if(!nCartaValido(nCarta) ){
            showDialog("Errore: numero di carta non valido","Errore", android.R.drawable.ic_dialog_alert);
        }
        else if(!sCartaValido(sCarta)){
            showDialog("Errore: scadenza non valida","Errore", android.R.drawable.ic_dialog_alert);
        }
        else if(!cvvCartaValido(cvvCarta)){
            showDialog("Errore: cvv non valido","Errore", android.R.drawable.ic_dialog_alert);
        }
        else{
            Intent i = new Intent(Paga_Activity.this, Pagato_Activity.class);
            startActivity(i);
        }
    }

    private boolean cvvCartaValido(String cvvCarta) {
        if(cvvCarta.length()==3)
            return true;
        else
            return false;
    }

    private boolean nCartaValido(String nCarta) {
        if(nCarta.length()==16)
            return true;
        else
            return false;
    }

    private boolean sCartaValido(String sCarta) {
        if(sCarta.length()==7 & sCarta.contains("/"))
            return true;
        else
            return false;
    }

    private void showDialog(String message, String title, int icon){
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(android.R.string.ok,null)
                .setIcon(icon)
                .show();
    }

}
