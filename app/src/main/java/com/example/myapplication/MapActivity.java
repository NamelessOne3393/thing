package com.example.myapplication;

import android.os.Bundle;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        Toast.makeText(this,"HI",Toast.LENGTH_SHORT).show();

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Toast.makeText(this,"HI",Toast.LENGTH_SHORT).show();
        mMap = googleMap;

        new Thread(() -> {

            // Simulate some data loading
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Back on UI Thread to intercact with the map safely
            runOnUiThread(() -> {
                LatLng kelowna = new LatLng(49.8801, -119.4436);

                mMap.addMarker(new MarkerOptions().position(kelowna).title("Gabi Cropland"));

                LatLng ubco = new LatLng(49.9394, -119.3948);
                mMap.addMarker(new MarkerOptions().position(ubco).title("Zaki Holds"));

                LatLng lakeCountry = new LatLng(50.0537, -119.4106);
                mMap.addMarker(new MarkerOptions().position(lakeCountry).title("Gamu Plantations"));

                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(kelowna, 10));

                UiSettings uiSettings = mMap.getUiSettings();
                uiSettings.setZoomControlsEnabled(true);
            });
        }).start();
    }



//
//        // Add markers for Kelowna, UBCO, and Lake Country
//        LatLng kelowna = new LatLng(49.8801, -119.4436);
//        mMap.addMarker(new MarkerOptions().position(kelowna).title("Gabi Cropland"));
//
//        LatLng ubco = new LatLng(49.9394, -119.3948);
//        mMap.addMarker(new MarkerOptions().position(ubco).title("Gamu Plantations"));
//
//        LatLng lakeCountry = new LatLng(50.0537, -119.4106);
//        mMap.addMarker(new MarkerOptions().position(lakeCountry).title("Zaki Holds"));
//
//        LatLng WestKelowna = new LatLng(50.0537, -119.4106);
//        mMap.addMarker(new MarkerOptions().position(lakeCountry).title("Keegan Ranches"));
//
//        // Move the camera to Kelowna and set the zoom level
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(kelowna, 10));
//
//        // Enable zoom controls
//        UiSettings uiSettings = mMap.getUiSettings();
//        uiSettings.setZoomControlsEnabled(true);
//    }
}