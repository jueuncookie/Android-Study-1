/**
 * @auther: 문주은
 * @취지: 과거 지하철마다 있었던 델리만쥬가 사라지기 시작했다!!! 위치를 알려주는 어플!!!!
 * @과정: 구글맵 APi 키를 받아 만들었다!!
 *
 */

package com.example.jueundelimanju;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.example.jueundelimanju.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.HashMap;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        HashMap<String, LatLng> location = new HashMap<>();
        location.put("군자역", new LatLng(37.557114, 127.079497));
        location.put("선릉역", new LatLng(37.504434, 127.049121));
        location.put("강남역", new LatLng(37.497816, 127.027673));
        location.put("왕십리역", new LatLng(37.561210, 127.038711));

        for (String key:
                location.keySet()) {
            mMap.addMarker(new MarkerOptions().position(location.get(key)).title("델리만주 in " + key));
        }

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location.get("선릉역"), 12));
    }
}