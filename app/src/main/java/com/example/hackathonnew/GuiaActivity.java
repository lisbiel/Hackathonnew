package com.example.hackathonnew;

import android.content.Context;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class GuiaActivity extends AppCompatActivity {

    LocationManager locationManager;

    LocationListener locationListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        locationManager = (LocationManager)
                getSystemService(Context.LOCATION_SERVICE);

    }
}
