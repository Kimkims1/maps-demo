package com.carldroid.mapsdemo;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

       // mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 34.7774578);
        LatLng australia = new LatLng(-35.6879592, 34.776953);
        LatLng adelaide = new LatLng(-36.6887113,34.7768089);

        mMap.addMarker(new MarkerOptions().position(sydney).title("City"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,18f));

        mMap.addCircle(new CircleOptions()
        .radius(200)
        .center(sydney)
        .strokeColor(Color.WHITE)
        .fillColor(Color.WHITE));

        mMap.addPolyline(new PolylineOptions()
        .add(sydney,australia)
        .width(2f)
        .color(Color.RED)
        .geodesic(true));

        mMap.addPolygon(new PolygonOptions()
        .add(sydney,australia,adelaide));


       /* mMap.addMarker(new MarkerOptions().position(crystal).title("Marker in Adelaide").snippet("She's here"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(crystal,3f));*/
    }
}
