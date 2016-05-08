package com.example.drago.food;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by drago on 2016-01-21.
 */
public class Fragment7 extends Fragment
{
    MapView myMap;
    private GoogleMap googlemap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup containter, Bundle savedInStanceState)
    {
        View rootView = inflater.inflate(R.layout.frag7, containter, false);
        myMap = (MapView) rootView.findViewById(R.id.f7);
        myMap.onCreate(savedInStanceState);
        myMap.onResume();

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        googlemap = myMap.getMap();
        // latitude and longitude
        //43.6702276,-79.3877231 = yonge and bloor
        //43.7242597,-79.4091657 = yong's house
        double latitude = 43.6702276;
        double longitude = -79.3877231;
        double myhomelat = 43.7242597;
        double myhomelng = -79.4091657;
        // create marker
        MarkerOptions marker = new MarkerOptions().position(
                new LatLng(latitude, longitude)).title("Yonge and Bloor");

        MarkerOptions home = new MarkerOptions().position(
                new LatLng(myhomelat, myhomelng)).title("Home");

        // Changing marker icon
        marker.icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_ROSE));

        // adding marker
        googlemap.addMarker(marker);
        googlemap.addMarker(home);
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(myhomelat, myhomelng)).zoom(12).build();
        googlemap.animateCamera(CameraUpdateFactory
                .newCameraPosition(cameraPosition));

        // Perform any camera updates here
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        myMap.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        myMap.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        myMap.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        myMap.onLowMemory();
    }
}