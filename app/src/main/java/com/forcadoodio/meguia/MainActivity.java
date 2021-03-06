package com.forcadoodio.meguia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button souGuia = findViewById(R.id.sou_guia);

        souGuia.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, GuiaActivity.class);
                startActivity(it);
            }
        });
        Button estouPerdido = findViewById(R.id.estou_perdido);

        estouPerdido.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, PerdidaActivity.class);
                startActivity(it);
            }
        });
    }
}
