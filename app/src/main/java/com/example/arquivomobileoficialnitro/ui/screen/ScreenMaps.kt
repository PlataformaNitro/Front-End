package com.example.arquivomobileoficialnitro.ui.screen

import android.Manifest
import android.widget.Toast
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberPermissionState
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.arquivomobileoficialnitro.ui.components.util.getCurrentLocation
import com.google.accompanist.permissions.isGranted

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun ScreenMaps() {
    val context = LocalContext.current

    val locationPermissionState = rememberPermissionState(Manifest.permission.ACCESS_FINE_LOCATION)

    val mapView = remember { MapView(context) }
    var userLocation by rememberSaveable { mutableStateOf<LatLng?>(null) }

    LaunchedEffect(locationPermissionState.status) {
        if (locationPermissionState.status.isGranted) {
            getCurrentLocation(context) { location ->
                if (location != null) {
                    userLocation = location
                } else {
                    Toast.makeText(context, "Localização não disponível", Toast.LENGTH_SHORT).show()
                }
            }
        } else {
            locationPermissionState.launchPermissionRequest()
        }
    }

    DisposableEffect(Unit) {
        mapView.onCreate(null)
        mapView.onStart()
        mapView.onResume()

        onDispose {
            mapView.onPause()
            mapView.onStop()
            mapView.onDestroy()
        }
    }

    AndroidView(factory = { mapView })

    LaunchedEffect(userLocation) {
        userLocation?.let { location ->
            mapView.getMapAsync { gMap ->
                gMap.clear()
                gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 16f))
                gMap.addMarker(
                    MarkerOptions()
                        .position(location)
                        .title("Você está aqui!")
                )
            }
        }
    }
}
