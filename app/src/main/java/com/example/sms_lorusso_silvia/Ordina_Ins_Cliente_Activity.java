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

import com.example.sms_lorusso_silvia.mMySQL.Sender_o_i_c;

public class Ordina_Ins_Cliente_Activity extends AppCompatActivity {

    String urlAddress="http://spacecrafts.altervista.org/ScritturaDati/scrivi_utenti.php";
    EditText nomeTxt, cognomeTxt, telefonoTxt, oraconsegnaTxt;
    Button saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordina__ins__cliente);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setTitle("Ordina");

        initUI();

    }

    private void initUI() {

        nomeTxt = (EditText) findViewById(R.id.nomeEditTxt);
        cognomeTxt = (EditText) findViewById(R.id.cognomeEditTxt);
        telefonoTxt = (EditText) findViewById(R.id.telefonoEditTxt);
        oraconsegnaTxt = (EditText) findViewById(R.id.oraconsegnaEditTxt);

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
        String cognome = cognomeTxt.getText().toString();
        String telefono = telefonoTxt.getText().toString();
        String oraConsegna = oraconsegnaTxt.getText().toString();

        //Validazione dati
        if(!nomeValido(nome) ){
            showDialog("Errore: nome non valido","Errore", android.R.drawable.ic_dialog_alert);
            //Toast.makeText(getApplicationContext(),"Nome non Valido", Toast.LENGTH_SHORT).show();
        }

        else if(!cognomeValido(cognome)){
            showDialog("Errore: cognome non valido","Errore", android.R.drawable.ic_dialog_alert);
            Toast.makeText(getApplicationContext(),"Cognome non Valido", Toast.LENGTH_SHORT).show();
        }
        else if(!telefonoValido(telefono)){
            showDialog("Errore: telefono non valido","Errore", android.R.drawable.ic_dialog_alert);
            Toast.makeText(getApplicationContext(),"Telefono non Valido", Toast.LENGTH_SHORT).show();
        }
        else if(!oraConsegnaValida(oraConsegna)){
            showDialog("Errore: ora consegna non valida","Errore", android.R.drawable.ic_dialog_alert);
            Toast.makeText(getApplicationContext(),"Ora consegna non Valida", Toast.LENGTH_SHORT).show();
        }
        else {
            Sender_o_i_c s=new Sender_o_i_c(Ordina_Ins_Cliente_Activity.this,urlAddress, nomeTxt, cognomeTxt, telefonoTxt, oraconsegnaTxt);
            s.execute();
        }
    }

    private boolean nomeValido(String nome) {
        if(nome.length()>2)
            return true;
        else
            return false;
    }

    private boolean cognomeValido(String cognome) {
        if(cognome.length()>3)
            return true;
        else
            return false;
    }

    private boolean telefonoValido(String telefono) {
        if(telefono.length()==10)
            return true;
        else
            return false;
    }

    private boolean oraConsegnaValida(String oraConsegna) {
        if(oraConsegna.length()==5 && oraConsegna.contains("."))
            return true;
        else
            return false;
    }

    // TODO: Creare un alert dialog da mostrare in caso di registration failed
    private void showDialog(String message, String title, int icon){
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(android.R.string.ok,null)
                .setIcon(icon)
                .show();
    }

}
