package com.example.arquivomobileoficialnitro.ui.components.util

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Looper
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.*
import com.google.android.gms.maps.model.LatLng

fun getCurrentLocation(
    context: Context,
    onLocationResult: (LatLng?) -> Unit
) {
    val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)

    if (ActivityCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) != PackageManager.PERMISSION_GRANTED
    ) {
        onLocationResult(null)
        return
    }

    val locationRequest = LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY, 0)
        .setWaitForAccurateLocation(true)
        .setMaxUpdates(1)
        .build()

    val locationCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult) {
            val location = locationResult.lastLocation
            if (location != null) {
                onLocationResult(LatLng(location.latitude, location.longitude))
            } else {
                onLocationResult(null)
            }
            fusedLocationClient.removeLocationUpdates(this)
        }
    }

    fusedLocationClient.requestLocationUpdates(
        locationRequest,
        locationCallback,
        Looper.getMainLooper()
    )
}
