package com.ismail.athanapp.activity;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;

import com.ismail.athanapp.R;


public class MainActivity extends AppCompatActivity {
    private FusedLocationProviderClient mFusedLocationClient;

    private TextView latituteField;
    private TextView longitudeField;
    static final int REQUEST_LOCATION = 1;
    LocationManager locationManager;
    Button btnPrayerTimes;
    Location location;
    double latti = 0.00
            , longi = 0.00 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        latituteField = findViewById(R.id.TextView02);
        longitudeField = findViewById(R.id.TextView04);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        getLocation();
        btnPrayerTimes = findViewById(R.id.btnPrayerTimes);
        btnPrayerTimes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(location != null){
                    Intent intent = new Intent(MainActivity.this,PrayerTimesActivity.class);
                    intent.putExtra("lattitude",latti);
                    intent.putExtra("longitude",longi);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Your toast message",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}
                    , REQUEST_LOCATION);
        } else {

             location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            if (location != null) {
                 latti = location.getLatitude();
                 longi = location.getLongitude();
                 latituteField.setText(Double.toString(latti));
                 longitudeField.setText(Double.toString(longi));

            } else {
                latituteField.setText("unable to find latitude ");
                longitudeField.setText("unable to find longitude ");
            }
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case REQUEST_LOCATION:
                getLocation();
                break;
        }
    }
}
