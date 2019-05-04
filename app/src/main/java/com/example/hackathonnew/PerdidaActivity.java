package com.example.hackathonnew;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class PerdidaActivity extends AppCompatActivity {

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.cadastro_pessoa_perdida);

        Button encontrarguia = findViewById(R.id.estou_perdido);

        encontrarguia.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(PerdidaActivity.this, PerdidaActivity.class);
                startActivity(it);
            }
        });
    }
}
