package com.example.valen.mapa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.StreetViewPanoramaFragment;
import com.google.android.gms.maps.model.LatLng;

public class StreetActivity extends AppCompatActivity implements OnStreetViewPanoramaReadyCallback{
    StreetViewPanoramaFragment streetViewPanoramaFragment;
    Bundle extra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_street);

        streetViewPanoramaFragment =
                (StreetViewPanoramaFragment) getFragmentManager()
                        .findFragmentById(R.id.streetviewpanorama);
        streetViewPanoramaFragment.getStreetViewPanoramaAsync(this);
    }

    @Override
    public void onStreetViewPanoramaReady(StreetViewPanorama streetViewPanorama) {
        extra = getIntent().getExtras();
        LatLng lg = new LatLng(((LatLng)extra.get("pos")).latitude,((LatLng)extra.get("pos")).longitude);
        streetViewPanorama.setPosition(lg);
    }
}
