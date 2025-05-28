package com.nitro.arquivomobileoficialnitro.components
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nitro.arquivomobileoficialnitro.R

@Composable
fun LogoHome(modifier: Modifier = Modifier) {
        Image(
            painter = painterResource(id = R.drawable.nitro_logo),
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