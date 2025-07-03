package com.example.arquivomobileoficialnitro.ui.screen

import android.Manifest
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
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
import com.orgs.myapplication.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomSearchBar(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    onSearchClick: (String) -> Unit
) {
    // Gerenciador de foco para controlar o teclado
    val focusManager = LocalFocusManager.current

    // State para guardar o texto da busca
    var query by remember { mutableStateOf("") }

    // Cor de fundo e conteúdo da barra
    val backgroundColor = Color(0xFF2C2C2E) // Um cinza escuro, similar ao da imagem
    val contentColor = Color.White

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // 1. Ícone de Voltar
        IconButton(onClick = onBackClick) {
            Image(
                painter = painterResource(R.drawable.group_639),
                modifier = Modifier.size(44.dp),
                contentDescription = "Voltar",
            )
        }

        // 2. Barra de Busca Principal (usando BasicTextField para customização)
        BasicTextField(
            value = query,
            onValueChange = { query = it },
            modifier = Modifier.weight(1f),
            singleLine = true,
            textStyle = TextStyle(color = contentColor, fontSize = 16.sp),
            cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearchClick(query)
                    // Esconde o teclado ao pressionar "Search"
                    focusManager.clearFocus()
                }
            ),
            decorationBox = { innerTextField ->
                // Este é o container que desenha a aparência da barra

                    Box(Modifier.wrapContentSize()) {
                        // Fundo da barra de busca
                        Row(Modifier.matchParentSize()
                            .alpha(0.9f)
                            .background(color = Color(0xFF1C2228), CircleShape)) {}
                        Row(
                            modifier = Modifier

                                .padding(horizontal = 16.dp, vertical = 10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Ícone de Busca",
                            tint = contentColor.copy(alpha = 0.7f)
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        // Caixa para o texto e o placeholder
                        Box(modifier = Modifier.weight(1f)) {
                            if (query.isEmpty()) {
                                Text(
                                    text = "Buscar",
                                    style = TextStyle(
                                        fontSize = 20.sp,
                                        fontFamily = FontFamily(Font(R.font.inter)),
                                        fontWeight = FontWeight(700),
                                        color = Color(0xFF49515D),

                                        )
                                )
                            }
                            // O campo de texto real
                            innerTextField()
                        }

                        Spacer(modifier = Modifier.width(8.dp))

                        // Ícone de Microfone
                        IconButton(
                            onClick = { /* TODO: Ação do microfone */ },
                            modifier = Modifier.size(24.dp)
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.microphone),
                                modifier = Modifier.size(24.dp),
                                contentDescription = "Busca por voz",
                                tint = contentColor
                            )
                        }

                        Spacer(modifier = Modifier.width(8.dp))

                        // Ícone de Câmera
                        IconButton(
                            onClick = { /* TODO: Ação da câmera */ },
                            modifier = Modifier.size(24.dp)
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.camera),
                                modifier = Modifier.size(24.dp),

                                contentDescription = "Busca por imagem",
                                tint = contentColor,
                            )
                        }

                    }
                    // Ícone de Lupa

                }
            }
        )
    }
}

// Exemplo de como usar o componente
@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun CustomSearchBarPreview() {
    CustomSearchBar(
        onBackClick = {},
        onSearchClick = {}
    )
}


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
    Box{
        CustomSearchBar(Modifier,{}) { }

    }



}