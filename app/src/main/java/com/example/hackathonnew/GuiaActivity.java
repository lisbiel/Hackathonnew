package com.example.hackathonnew;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class GuiaActivity extends AppCompatActivity {

    private static final int REQUEST_PERMISSION_GPS = 1;
    LocationManager locationManager;

    LocationListener locationListener;

    ArrayList<PessoaPerdida> perdidas;

    PerdidosAdapter perdidosAdapter;

    int distance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guia_activity);

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
        perdidas.add(new PessoaPerdida("Cralos Otário", "Estação Mauá", "Estação Paulista"));
        perdidas.add(new PessoaPerdida("Leonardo Vedovate", "Estação Mauá", "Estação Alto do Ipiranga"));
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
