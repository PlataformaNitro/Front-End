package com.example.arquivomobileoficialnitro.ui.sections.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.arquivomobileoficialnitro.ui.components.telaHome.PessoasRecomendadas
import com.example.arquivomobileoficialnitro.R

@Composable
fun SectionPessoasRecomendas(modifier: Modifier = Modifier) {

    val pessoas = listOf(
        R.drawable.foto_perfil_amigos_recomendados,
        R.drawable.amigos_recomendados_1,
        R.drawable.amigos_recomendados_2,
        R.drawable.amigos_recomendados_3
    )

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(7.dp)
    ) {
        items(pessoas) { pessoa ->
            PessoasRecomendadas(pessoa)
        }
    }
}

@Preview
@Composable
private fun SectionPessoasRecomendasPreview() {
    SectionPessoasRecomendas()
}