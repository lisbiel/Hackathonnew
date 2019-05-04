package com.forcadoodio.meguia;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class GuiaActivity extends AppCompatActivity {

    private static final int REQUEST_PERMISSION_GPS = 1;
    LocationManager locationManager;

    LocationListener locationListener;

    ArrayList<PessoaPerdida> perdidas;

    PerdidosAdapter perdidosAdapter;

    ListView perdidosListView;

    int distance;
    private Object PerdidosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guia_activity);
        perdidosListView = findViewById(R.id.perdidosListView);

        perdidosListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent(GuiaActivity.this, ChatActivity.class);
                startActivity(it);
            }
            }
        );

        perdidas = new ArrayList<PessoaPerdida>();
        listCreate(perdidas);

        distance = 1000;

        perdidosAdapter =
                new PerdidosAdapter(this, perdidas, distance);

        locationManager = (LocationManager)
                getSystemService(Context.LOCATION_SERVICE);

        locationListener =
                new LocationListener() {
                    @Override
                    public void onLocationChanged(Location location) {

                    }

                    @Override
                    public void onStatusChanged(String provider, int status, Bundle extras) {

                    }

                    @Override
                    public void onProviderEnabled(String provider) {

                    }

                    @Override
                    public void onProviderDisabled(String provider) {

                    }
                };

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED) {
            perdidosListView.setAdapter(perdidosAdapter);
            perdidosAdapter.notifyDataSetChanged();
        } else {
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{
                            Manifest.permission.ACCESS_FINE_LOCATION
                    },
                    REQUEST_PERMISSION_GPS
            );
        }
    }

    private void listCreate(ArrayList<PessoaPerdida> perdidas) {
        perdidas.add(new PessoaPerdida("Renato Stefan", "Estação Sacomã", "Estação Carrão"));
        perdidas.add(new PessoaPerdida("Cralos Otávio", "Estação Mauá", "Estação Paulista"));
        perdidas.add(new PessoaPerdida("Leonardo Vedovate", "Estação Mauá", "Alto do Ipiranga"));
        perdidas.add(new PessoaPerdida("Jośe Antônio", "Estação Ribeirão Pires", "Estação Brás"));
        perdidas.add(new PessoaPerdida("Maria Roberta", "Estação Guapituba", "Estação Jundiaí"));
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_PERMISSION_GPS){
            if (grantResults.length > 0 &&
                    grantResults[0] ==
                            PackageManager.PERMISSION_GRANTED){
                if (ActivityCompat.checkSelfPermission(
                        this,
                        Manifest.permission.ACCESS_FINE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED){
                    perdidosListView.setAdapter(perdidosAdapter);
                    perdidosAdapter.notifyDataSetChanged();
                }
            }
            else{
                Toast.makeText(this,
                        getString(
                                R.string.no_gps_no_app
                        ),
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
}
