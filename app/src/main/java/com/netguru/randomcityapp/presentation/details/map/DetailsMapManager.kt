package com.netguru.randomcityapp.presentation.details.map

import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng

interface DetailsMapManager {

    fun setupGoogleMap(map: GoogleMap?)

    fun showLocationOnMap(location: LatLng)

    fun getCityLatLngByName(cityName: String) : LatLng?
}