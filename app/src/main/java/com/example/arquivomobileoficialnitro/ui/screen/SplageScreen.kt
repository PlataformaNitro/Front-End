package com.example.arquivomobileoficialnitro.ui.components.util

import LogoDark
import android.util.Size
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.arquivomobileoficialnitro.R
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(modifier: Modifier = Modifier,navController: NavController?=null){
    LaunchedEffect(Unit) {
        delay(2000)
        navController?.navigate("boasVindas") {
            popUpTo("splash") { inclusive = true }
        }
    }

    Box(Modifier.fillMaxSize()){
        Image(painter = painterResource(id = R.drawable.splash_screen_dark),contentDescription = "Splage Screen",
            Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen()
}
