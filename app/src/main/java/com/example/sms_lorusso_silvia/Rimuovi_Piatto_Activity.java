package com.example.sms_lorusso_silvia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.sms_lorusso_silvia.mDataObject.Piatti;
import com.example.sms_lorusso_silvia.mMySQL.Downloader_r_p;

public class Rimuovi_Piatto_Activity extends AppCompatActivity {

    //private static final String LOG_TAG = Visualizza_menu_activity.class.getSimpleName();

    String url="http://spacecrafts.altervista.org/LetturaDati/piatti.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rimuovi_pi);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rec_r_p);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        new Downloader_r_p(this, url, recyclerView).execute();
    }
}
