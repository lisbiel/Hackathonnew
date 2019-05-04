package com.example.hackathonnew;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class AnimacaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animacao);

            Button chatButton = findViewById(R.id.chat);

        chatButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(AnimacaoActivity.this, ChatActivity.class);
                startActivity(it);
            }
        });

    }
}
