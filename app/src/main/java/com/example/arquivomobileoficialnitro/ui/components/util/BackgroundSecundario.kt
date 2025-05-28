package com.example.arquivomobileoficialnitro.ui.components.util

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BackgroundSecundario(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            // Segundo plano: o gradiente escuro (por baixo)
            .background(
                brush = Brush.verticalGradient(
                    colorStops = arrayOf(
                        0.0f to Color(0xFF021030),
                        0.3f to Color(0xFF021030),
                        1.0f to Color(0xFF014677)
                    )
                )
            )
            // Primeiro plano: overlay escuro semi-transparente (por cima)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0x33000000), // rgba(0,0,0,0.2) = 0x33 opacity
                        Color(0x33000000)
                    )
                )
            ),
    )
}



@Preview(showSystemUi = true)
@Composable
private fun BackgroundSecundarioPreview() {
    BackgroundSecundario()
}