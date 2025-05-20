package com.example.arquivomobileoficialnitro.ui.sections.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.arquivomobileoficialnitro.R
import com.example.arquivomobileoficialnitro.ui.sections.homeimport.CardHome

@Composable
fun SectionCardHome(modifier: Modifier = Modifier) {
    LazyRow(contentPadding = PaddingValues(horizontal = 16.dp),modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.spacedBy(17.dp)){
       item {
           CardHome(image = R.drawable.eventosacontecendo)
           CardHome(image = R.drawable.eventosacontecendo)
           CardHome(image = R.drawable.eventosacontecendo)
           CardHome(image = R.drawable.eventosacontecendo)
       }
    }
}

@Preview
@Composable
private fun SectionCardHomePreview() {
    SectionCardHome()
}