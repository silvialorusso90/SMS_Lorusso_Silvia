package com.example.sms_lorusso_silvia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sms_lorusso_silvia.mMySQL.Sender_r_pi;

public class DetailActivity extends AppCompatActivity {

    String  url="http://spacecrafts.altervista.org/ScritturaDati/elimina_piatto.php";
    TextView nomePiattoTxt, tipoPiattoTxt, prezzoPiattoTxt;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //RECEIVE DATA
        Bundle extras = getIntent().getExtras();
        final String nome = extras.getString("Nome");
        final String tipo = extras.getString("Tipo");
        final String prezzo = extras.getString("Prezzo");

        //INITIALIE VIEW
        nomePiattoTxt = (TextView)findViewById(R.id.nomeTxtPiatto);
        tipoPiattoTxt = (TextView)findViewById(R.id.tipoTxtPiatto);
        prezzoPiattoTxt = (TextView)findViewById(R.id.prezzoTxtPiatto);
        btn = (Button)findViewById(R.id.button_rmv);

        //BIND DATA
        nomePiattoTxt.setText(nome);
        tipoPiattoTxt.setText(tipo);
        prezzoPiattoTxt.setText(prezzo);

        final String urll = url+"?Nome="+nome;

        //urll è corretto
        //Toast.makeText(getApplicationContext(), urll, Toast.LENGTH_LONG).show();


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Sender_r_pi(DetailActivity.this, urll, nome).execute();
            }
        });
    }
}
