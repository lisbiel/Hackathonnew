package com.forcadoodio.meguia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.DrawableImageViewTarget;


public class AnimacaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animacao);

        DrawableImageViewTarget target = new DrawableImageViewTarget((ImageView) findViewById(R.id.gif));
        Glide.with(this)
                .load(R.drawable.loading)
                .into(target);

            Button chatButton = findViewById(R.id.chat);

        chatButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(AnimacaoActivity.this, ChatActivity.class);
                startActivity(it);
            }
        });

    }
}
