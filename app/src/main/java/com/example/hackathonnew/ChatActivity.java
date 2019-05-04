package com.example.hackathonnew;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {

    ArrayList<String> mensagens;

    ArrayAdapter<String> adapter;

    EditText chatMessage;

    Button buttonSend;

    ListView mensagensList;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_activity);

        chatMessage = findViewById(R.id.chatMessage);
        buttonSend = findViewById(R.id.buttonSend);
        mensagensList = findViewById(R.id.mensagensList);

        mensagens = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, R.layout.chat_list,mensagens);

        runOnUiThread(()->{
            adapter.notifyDataSetChanged();
        });
        mensagensList.setAdapter(adapter);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mensagens.add(String.valueOf(chatMessage.getText()));
                chatMessage.setText("");
            }
        });
    }
}
