package com.netguru.randomcityapp.presentation.details.map;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.netguru.randomcityapp.core.Constants;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.Locale;

import javax.inject.Inject;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class DetailsMapManagerImpl implements DetailsMapManager {

    GoogleMap map;

    private final Geocoder geocoder;

    @Inject
    public DetailsMapManagerImpl(Context context) {
        geocoder = new Geocoder(context, Locale.getDefault());
    }

    @Override
    public void setupGoogleMap(@Nullable GoogleMap map) {
        this.map = map;
    }

    @Override
    public void findCityOnMapByName(@NotNull String cityName, @NotNull Function1<? super IOException, Unit> onError) {
        try {
            LatLng cityLatLng = getCityLatLngByName(cityName);
            CameraPosition cameraPosition = new CameraPosition.Builder().target(cityLatLng).zoom(Constants.MAP_ZOOM).build();
            CameraUpdate camera = CameraUpdateFactory.newCameraPosition(cameraPosition);
            map.animateCamera(camera);
        } catch (IOException exception) {
            exception.printStackTrace();
            onError.invoke(exception);
        }
    }

    private LatLng getCityLatLngByName(String cityName) throws IOException {
        Address city = geocoder.getFromLocationName(cityName, Constants.LOCATION_RESULTS_NUMBER).get(0);
        return new LatLng(city.getLatitude(), city.getLongitude());
    }
}

