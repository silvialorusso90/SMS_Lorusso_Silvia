package com.example.sms_lorusso_silvia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
