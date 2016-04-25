package com.example.group26.locationbasedservicesdemo;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LocationManager locationManager;
    LocationListener locationListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("GPS Not Enabled!")
                    .setMessage("Would you like to enable the GPS?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener(){

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                            startActivity(intent);
                        }
                    }).setNegativeButton("No", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                            finish();
                        }
                    });
                    AlertDialog alert = builder.create();
                    alert.show();
        }
        else {
            locationListener = new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    Log.d("location", location.getLatitude() + " , " + location.getLongitude());
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
            try{
                locationManager.requestLocationUpdates(locationManager.GPS_PROVIDER, 0, 100, locationListener);
            } catch(SecurityException e){
                Log.d("error", e.getMessage());
                Log.d("error", e.getStackTrace().toString());
            }

            Toast.makeText(MainActivity.this, "GPS ENABLED!", Toast.LENGTH_SHORT).show();
        }
    }
}
