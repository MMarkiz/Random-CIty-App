package com.netguru.randomcityapp.presentation.details.map

import com.google.android.gms.maps.GoogleMap
import java.io.IOException

interface DetailsMapManager {

    fun setupGoogleMap(map: GoogleMap?)

    fun findCityOnMapByName(cityName: String, onError: (IOException) -> Unit)
}