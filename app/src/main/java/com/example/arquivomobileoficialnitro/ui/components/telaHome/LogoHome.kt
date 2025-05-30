package com.example.arquivomobileoficialnitro.ui.components.telaHome
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.zIndex
import com.example.arquivomobileoficialnitro.R

@Composable
fun LogoHome(modifier: Modifier = Modifier) {
        Image(
            painter = painterResource(id = R.drawable.nitropnglogodark),
            contentDescription = "Nitro Logo",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(40.dp)
        )
    }


@Preview
@Composable
private fun LogoPreview() {
    LogoHome()
}