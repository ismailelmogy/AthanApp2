package com.ismail.athanapp.activity;


import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.location.LocationListener;
import android.widget.Toast;

import com.ismail.athanapp.R;

public class MainActivity extends AppCompatActivity implements LocationListener {

    Button btnPrayerTimes;
    Double lat_loc;
    Double lon_loc;
    String provider;
    private LocationManager locationManager;
    private TextView latitudeField;
    private TextView longitudeField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        latitudeField = findViewById(R.id.TextView02);
        longitudeField = findViewById(R.id.TextView04);
        btnPrayerTimes = findViewById(R.id.btnPrayerTimes);
        getLocation();
        btnPrayerTimes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lat_loc != null && lon_loc != null) {
                    android.content.Intent intent = new android.content.Intent(MainActivity.this,
                            PrayerTimesActivity.class);
                    intent.putExtra("lattitude", lat_loc);
                    intent.putExtra("longitude", lon_loc);
                    startActivity(intent);
                }
            }
        });

    }

    private void getLocation() {
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Criteria cri = new Criteria();
        provider = locationManager.getBestProvider(cri, false);
        if (provider != null & !provider.equals("")) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            Location location = locationManager.getLastKnownLocation(provider);
            locationManager.requestLocationUpdates(provider, 2000, 1, this);

            if (location != null) {
                onLocationChanged(location);
            } else {
                Toast.makeText(getApplicationContext(), "location not found", Toast.LENGTH_LONG).show();
            }

        } else

        {
            Toast.makeText(getApplicationContext(), "Provider is null", Toast.LENGTH_LONG).show();
        }

    }


    @Override
    public void onLocationChanged(Location location) {
        lat_loc = location.getLatitude();
        lon_loc = location.getLongitude();

        latitudeField.setText( " " + lat_loc);
        longitudeField.setText( " " + lon_loc);
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
}
