package com.diy.macload1.tracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mapbox.mapboxsdk.MapboxAccountManager;           // !Account Manager
import com.mapbox.mapboxsdk.maps.MapView;                   // !Mapview
import com.mapbox.mapboxsdk.maps.MapboxMap;                 // !Mapbox
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;        // !Callbacks
import com.mapbox.mapboxsdk.annotations.MarkerOptions;      // Marler Option
import com.mapbox.mapboxsdk.geometry.LatLng;                // Lattitude/Longitude values


public class TrackerActivity extends AppCompatActivity {

    private MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Mapbox access token is configured here. This needs to be called either in your application
        // object or in the same activity which contains the mapview.
        MapboxAccountManager.start(this, getString(R.string.access_token));

        // This contains the MapView in XML and needs to be called after the account manager
        setContentView(R.layout.activity_tracker);

        mapView = (MapView) findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {

                // Customize map with markers, polylines, etc.
                /*mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(48.868789, 2.770173))
                        .title("Disneyland Paris")
                        .snippet("Hello Mickey!"));*/
                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(50.597557, 5.398630))
                        .title("Home")
                        .snippet("Hello Kids!"));
            }
        });
    }

    // Add the mapView lifecycle to the activity's lifecycle methods
    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }
}