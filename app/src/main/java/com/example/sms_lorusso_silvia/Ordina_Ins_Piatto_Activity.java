package com.example.sms_lorusso_silvia;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sms_lorusso_silvia.mMySQL.Downloader_Ordina_Pi;

import java.util.ArrayList;

public class Ordina_Ins_Piatto_Activity extends AppCompatActivity {

    String url="http://spacecrafts.altervista.org/LetturaDati/piatti.php";

    Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordina__ins__piatto_);

        Bundle extras = getIntent().getExtras();
        final String tel = extras.getString("Telefono");
        final String orac = extras.getString("OraConsegna");
        setTitle("Tel: "+tel+"   OraC: "+orac);

        //Toast.makeText(this, orac, Toast.LENGTH_SHORT).show();

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        new Downloader_Ordina_Pi(this, url, tel, orac, recyclerView).execute();

        mBtn = (Button) findViewById(R.id.button4);


        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Ordina_Ins_Piatto_Activity.this, Riepilogo_Ordine_Activity.class);
                i.putExtra("Telefono", tel);
                i.putExtra("OraConsegna", orac);
                startActivity(i);
            }
        });


    }
}
