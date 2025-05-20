package com.example.arquivomobileoficialnitro.ui.sections.homeimport

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.arquivomobileoficialnitro.R
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun CardHome(modifier: Modifier = Modifier,image:Int) {
    Box(modifier = Modifier
        .width(271.dp)
        .height(233.dp)
        .clip(RoundedCornerShape(25.dp))) {
        Image(
            painter = painterResource(id = image),
            contentDescription = "card de eventos",
            modifier = Modifier
                .width(271.dp)
                .height(233.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview
@Composable
private fun CardHomePreview() {
    CardHome(image = R.drawable.eventosacontecendo)
}