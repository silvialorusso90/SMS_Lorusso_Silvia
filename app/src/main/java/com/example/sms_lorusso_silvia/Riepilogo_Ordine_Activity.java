package com.example.sms_lorusso_silvia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.example.sms_lorusso_silvia.mMySQL.Downloader_riepilogo;

public class Riepilogo_Ordine_Activity extends AppCompatActivity {

    String url="http://spacecrafts.altervista.org/LetturaDati/carrello.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riepilogo__ordine);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle extras = getIntent().getExtras();
        final String tel = extras.getString("Telefono");
        setTitle("Tel: "+tel+" OraC: "+tel);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recy);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        String urll = url+"?Telefono="+tel;
        Toast.makeText(getApplicationContext(), urll, Toast.LENGTH_LONG).show();



        new Downloader_riepilogo(this, urll, tel, recyclerView).execute();

    }
}
