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
import com.google.android.gms.maps.model.MapStyleOptions
import com.example.arquivomobileoficialnitro.R



@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun ScreenMaps() {
    val context = LocalContext.current

    val locationPermissionState = rememberPermissionState(Manifest.permission.ACCESS_FINE_LOCATION)

    val mapView = remember { MapView(context) }
    var userLocation by rememberSaveable { mutableStateOf<LatLng?>(null) }
    var addedMarkers by remember { mutableStateOf(listOf<LatLng>()) }
    val googleMapState = remember { mutableStateOf<com.google.android.gms.maps.GoogleMap?>(null) }

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
    AndroidView(factory = { mapView }) { map ->
        map.getMapAsync { gMap ->

            if (googleMapState.value == null) {
                googleMapState.value = gMap

                // 👉 Aplica o estilo do mapa
                val styleSuccess = gMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(context, R.raw.map_style)
                )

                if (!styleSuccess) {
                    Toast.makeText(context, "Erro ao aplicar estilo do mapa", Toast.LENGTH_SHORT).show()
                }

                // 👉 Habilita zoom
                gMap.uiSettings.isZoomControlsEnabled = true

                // 👉 Clique para adicionar marcador
                gMap.setOnMapClickListener { latLng ->
                    addedMarkers = addedMarkers + latLng
                }

                // 👉 Anima ao clicar no marcador
                gMap.setOnMarkerClickListener { marker ->
                    gMap.animateCamera(CameraUpdateFactory.newLatLngZoom(marker.position, 16f))
                    true
                }
            }


            // NÃO LIMPE nem adicione marcadores aqui!
        }
    }
    LaunchedEffect(userLocation, addedMarkers) {
        googleMapState.value?.let { gMap ->
            gMap.clear()

            // Adiciona marcador da localização atual
            userLocation?.let { location ->
                gMap.addMarker(
                    MarkerOptions()
                        .position(location)
                        .title("Você está aqui!")
                )
            }

            // Adiciona marcadores adicionados
            addedMarkers.forEachIndexed { index, latLng ->
                gMap.addMarker(
                    MarkerOptions()
                        .position(latLng)
                        .title("Ponto ${index + 1}")
                )
            }

            // Decide para onde mover a câmera:
            // Se tiver marcadores, foca no último que foi adicionado
            // Senão, foca na localização do usuário

            val target = if (addedMarkers.isNotEmpty()) {
                addedMarkers.last()
            } else {
                userLocation
            }

            target?.let {
                gMap.animateCamera(CameraUpdateFactory.newLatLngZoom(it, 16f))
            }
        }
    }



}
