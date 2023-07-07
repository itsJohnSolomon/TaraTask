package com.bks.taskfortara;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnPolylineClickListener,
        GoogleMap.OnPolygonClickListener, GoogleMap.OnMarkerClickListener {
    private GoogleMap mMap;

    // below are the latitude and longitude
    // of 4 different locations.
    LatLng sydney = new LatLng(11.0081661, 76.9480779);
    LatLng TamWorth = new LatLng(11.016521,  76.953199);
    LatLng NewCastle = new LatLng(11.018372, 76.966428);
    LatLng Brisbane = new LatLng(11.031862, 76.981920);
   TextView pageName;
    // creating array list for adding all our locations.
    private ArrayList<LatLng> locationArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pageName=findViewById(R.id.pageName);
        pageName.setText("Google Maps");
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        locationArrayList = new ArrayList<>();

        // on below line we are adding our
        // locations in our array list.
        locationArrayList.add(sydney);
        locationArrayList.add(TamWorth);
        locationArrayList.add(NewCastle);
        locationArrayList.add(Brisbane);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        for (int i = 0; i < locationArrayList.size(); i++) {

            // below line is use to add marker to each location of our array list.
            mMap.addMarker(new MarkerOptions().position(locationArrayList.get(i)).title("Marker"));

            // below lin is use to zoom our camera on map.
            mMap.animateCamera(CameraUpdateFactory.zoomTo(18.0f));

            // below line is use to move our camera to the specific location.
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(locationArrayList.get(0), 13.0f));

            mMap.addPolyline((new PolylineOptions()).add(sydney,TamWorth, NewCastle, Brisbane).
                    // below line is use to specify the width of poly line.
                            width(5)
                    // below line is use to add color to our poly line.
                    .color(Color.RED)
                    // below line is to make our poly line geodesic.
                    .geodesic(true));
            // on below line we will be starting the drawing of polyline.
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Brisbane, 13));
            googleMap.setOnMarkerClickListener(this);
        }
    }

    @Override
    public void onPolygonClick(@NonNull Polygon polygon) {
//        Intent intent = new Intent(getApplicationContext(), ProductList.class);
//        startActivity(intent);
    }

    @Override
    public void onPolylineClick(@NonNull Polyline polyline) {
//        Intent intent = new Intent(getApplicationContext(), ProductList.class);
//        startActivity(intent);
    }

    @Override
    public boolean onMarkerClick(@NonNull Marker marker) {
        Intent intent = new Intent(MainActivity.this, ProductList.class);
        startActivity(intent);
        return false;
    }
}