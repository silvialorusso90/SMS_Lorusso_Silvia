package com.example.sms_lorusso_silvia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.sms_lorusso_silvia.mMySQL.Downloader_v_c;

public class Visualizza_comande_activity extends AppCompatActivity {

    String url="http://spacecrafts.altervista.org/LetturaDati/comande.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizza_comande);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //setTitle("Ordini: ");

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rec_v_c);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        new Downloader_v_c(this, url, recyclerView).execute();
    }
}
