package com.example.sms_lorusso_silvia;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sms_lorusso_silvia.mMySQL.Sender_a_pi;

public class Aggiungi_Piatto_Activity extends AppCompatActivity {

    String url="http://spacecrafts.altervista.org/ScritturaDati/scrivi_piatti.php";

    //UI
    EditText nomeTxt, tipoTxt, prezzoTxt;
    Button saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aggiungi_pi);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        //INITIALIE VIEW
        initUI();

        /*
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sender_a_pi s=new Sender_a_pi(Aggiungi_Piatto_Activity.this, url, nomeTxt, tipoTxt, prezzoTxt);
                s.execute();
            }
        });*/
    }

    private void initUI() {
        nomeTxt = (EditText) findViewById(R.id.nomeEditTxt);
        tipoTxt = (EditText) findViewById(R.id.tipoEditTxt);
        prezzoTxt = (EditText) findViewById(R.id.prezzoEditTxt);

        saveBtn= (Button) findViewById(R.id.saveBtn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salva();
            }
        });
    }

    private void salva() {
        String nome = nomeTxt.getText().toString();
        String tipo = tipoTxt.getText().toString();

        //Validazione dati
        if(!nomeValido(nome) ){
            showDialog("Errore: nome non valido","Errore", android.R.drawable.ic_dialog_alert);
        }
        else if(!tipoValido(tipo)){
            showDialog("Errore: portata non valida","Errore", android.R.drawable.ic_dialog_alert);
        }
        else {
            Sender_a_pi s=new Sender_a_pi(Aggiungi_Piatto_Activity.this, url, nomeTxt, tipoTxt, prezzoTxt);
            s.execute();
        }


    }

    private boolean nomeValido(String nome) {
        if(nome.length()>3)
            return true;
        else
            return false;
    }

    private boolean tipoValido(String tipo) {
        if(tipo.length()>4)
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
