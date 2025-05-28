package com.example.arquivomobileoficialnitro.ui.sections.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items // IMPORTANTE!
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.arquivomobileoficialnitro.R
import com.example.arquivomobileoficialnitro.ui.sections.homeimport.CardHome

@Composable
fun SectionCardHome(modifier: Modifier = Modifier) {
    val cards = listOf(
        R.drawable.eventosacontecendo,
        R.drawable.eventosacontecendo,
        R.drawable.eventosacontecendo,
        R.drawable.eventosacontecendo
    )

    LazyRow(
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(17.dp)
    ) {
        items(cards) { image ->
            CardHome(image = image)
        }
    }
}

@Preview
@Composable
private fun SectionCardHomePreview() {
    SectionCardHome()
}
