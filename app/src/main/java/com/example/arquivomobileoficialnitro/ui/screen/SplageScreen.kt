package com.example.arquivomobileoficialnitro.ui.components.util

import LogoDark
import android.util.Size
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun SplashScreen(
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxSize()) {
        BackgroundSecundario()
        LogoDark(
            modifier = Modifier.align(Alignment.Center).size(634.dp)
        )
        Box(

            modifier = Modifier
                .size(width = 412.dp, height = 171.dp)
                .offset(y = 499.dp)
                .graphicsLayer { alpha = 0.1f }
                .align(Alignment.TopCenter)
        )

        {
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen()
}
