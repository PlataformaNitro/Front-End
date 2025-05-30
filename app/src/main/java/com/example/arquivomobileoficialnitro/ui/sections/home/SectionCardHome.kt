package com.example.arquivomobileoficialnitro.ui.sections.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items // IMPORTANTE!
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.arquivomobileoficialnitro.R
import com.example.arquivomobileoficialnitro.ui.sections.homeimport.CardHome

@Composable
fun SectionCardHome() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Eventos Acontecendo",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Ver mais",
                color = Color.Cyan,
                fontSize = 14.sp,
                modifier = Modifier.clickable { /* ação de ver mais */ }
            )
        }

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 0.dp)
        ) {
            items(5) { // substitua por sua lista real de eventos
                Box(
                    modifier = Modifier.background(Color.DarkGray),
                    contentAlignment = Alignment.Center
                ) {
                    CardHome(image = R.drawable.eventosacontecendo)
                }
            }
        }
    }
}


@Preview
@Composable
private fun SectionCardHomePreview() {
    SectionCardHome()
}
