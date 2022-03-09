package com.example.androidexercisetracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.List;

public class RunningActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private MapView mMapView;

    private static final String MAPVIEW_BUNDLE_KEY = "MapViewBundleKey";
    private UiSettings mUiSettings;

    public TextView stepsValue;
    public TextView distanceValue;
    public TextView caloriesValue;

    public CountDownTimer stepsCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.running_activity);

        Bundle mapViewBundle = null;
        if (savedInstanceState != null) {
            mapViewBundle = savedInstanceState.getBundle(MAPVIEW_BUNDLE_KEY);
        }
        mMapView = (MapView) findViewById(R.id.map_view);
        mMapView.onCreate(mapViewBundle);

        mMapView.getMapAsync(this);

        stepsValue = findViewById(R.id.steps_value);
        stepsValue.setText("--");

        distanceValue = findViewById(R.id.distance_value);
        distanceValue.setText("--");

        caloriesValue = findViewById(R.id.calories_value);
        caloriesValue.setText("--");

        TextView stepsLabel = findViewById(R.id.steps_label);
        stepsLabel.setText("Steps");

        TextView distanceLabel = findViewById(R.id.distance_label);
        distanceLabel.setText("Distance");

        TextView caloriesLabel = findViewById(R.id.calories_label);
        caloriesLabel.setText("Calories");

        Button b = findViewById(R.id.record_button);
        b.setText("Start Recording");

        stepsCounter = new StepsTimer(Long.MAX_VALUE, 1000 / 3);
    }

    public void onClick(View v) {
        Button b = findViewById(R.id.record_button);
        if (b.getText().equals("Start Recording")) {
            b.setText("Stop Recording");

            List<LatLng> path = new ArrayList();
            path.add(new LatLng(37.872437,-122.273125));
            path.add(new LatLng(37.870577,-122.272941));
            PolylineOptions opts = new PolylineOptions().addAll(path).color(Color.BLUE).width(5);
            mMap.addPolyline(opts);

            stepsCounter.start();
        } else {
            b.setText("Start Recording");
            mMap.clear();

            stepsCounter.cancel();
            stepsCounter.onFinish();
        }
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        LatLng berkeley = new LatLng(37.871593, -122.272743);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(berkeley));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(17.0f));

        mUiSettings = mMap.getUiSettings();
        mUiSettings.setZoomControlsEnabled(true);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Bundle mapViewBundle = outState.getBundle(MAPVIEW_BUNDLE_KEY);
        if (mapViewBundle == null) {
            mapViewBundle = new Bundle();
            outState.putBundle(MAPVIEW_BUNDLE_KEY, mapViewBundle);
        }

        mMapView.onSaveInstanceState(mapViewBundle);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mMapView.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mMapView.onStop();
    }

    @Override
    protected void onPause() {
        mMapView.onPause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        mMapView.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

    public class StepsTimer extends CountDownTimer {
        public int steps = 0;

        public StepsTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            steps += 1;
            stepsValue.setText(Integer.toString(steps));
            distanceValue.setText(String.format("%.2f mi", steps / 2000.0));
            caloriesValue.setText(String.format("%.2f", steps * 0.04));
        }

        @Override
        public void onFinish() {
            steps = 0;
            stepsValue.setText("--");
            distanceValue.setText("--");
            caloriesValue.setText("--");
        }
    }
}
