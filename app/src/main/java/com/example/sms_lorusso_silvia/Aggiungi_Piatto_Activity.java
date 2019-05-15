package com.example.sms_lorusso_silvia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sms_lorusso_silvia.mMySQL.Sender_a_pi;

public class Aggiungi_Piatto_Activity extends AppCompatActivity {

    String url="http://spacecrafts.altervista.org/ScritturaDati/scrivi_piatti.php";
    EditText nomeTxt, tipoTxt, prezzoTxt;
    Button saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aggiungi_pi);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //INITIALIE VIEW
        nomeTxt = (EditText) findViewById(R.id.nomeEditTxt);
        tipoTxt = (EditText) findViewById(R.id.tipoEditTxt);
        prezzoTxt = (EditText) findViewById(R.id.prezzoEditTxt);

        saveBtn= (Button) findViewById(R.id.saveBtn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sender_a_pi s=new Sender_a_pi(Aggiungi_Piatto_Activity.this, url, nomeTxt, tipoTxt, prezzoTxt);
                s.execute();
            }
        });
    }
}
