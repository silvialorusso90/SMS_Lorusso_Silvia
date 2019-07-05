package com.example.sms_lorusso_silvia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.sms_lorusso_silvia.mMySQL.Adapter_v_m;
import com.example.sms_lorusso_silvia.mMySQL.Downloader_v_m;
import com.example.sms_lorusso_silvia.mDataObject.Piatti;

public class Visualizza_menu_activity extends AppCompatActivity {

    String url="http://spacecrafts.altervista.org/LetturaDati/piatti.php";
    Adapter_v_m adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizza_menu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setTitle("Menu");

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rec_v_m);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        new Downloader_v_m(this, url, recyclerView).execute();
    }
}
