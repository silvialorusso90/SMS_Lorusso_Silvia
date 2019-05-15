package com.example.sms_lorusso_silvia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

        nomeTxt = (EditText) findViewById(R.id.nomeEditTxt);
        cognomeTxt = (EditText) findViewById(R.id.cognomeEditTxt);
        telefonoTxt = (EditText) findViewById(R.id.telefonoEditTxt);
        oraconsegnaTxt = (EditText) findViewById(R.id.oraconsegnaEditTxt);

        saveBtn= (Button) findViewById(R.id.saveBtn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sender_o_i_c s=new Sender_o_i_c(Ordina_Ins_Cliente_Activity.this,urlAddress, nomeTxt, cognomeTxt, telefonoTxt, oraconsegnaTxt);
                s.execute();
            }
        });
    }
}
