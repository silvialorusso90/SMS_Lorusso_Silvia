package com.example.sms_lorusso_silvia;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setTitle("");
    }

    public void lanciaRistoratoreAxctivity(View view) {
        Intent intent1 = new Intent(this, RistoratoreActivity.class);
        startActivity(intent1);
    }

    public void lanciaClienteActivity(View view) {
        Intent intent2 = new Intent(this, Cliente_Activity.class);
        startActivity(intent2);
    }
}
