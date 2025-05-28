package com.nitro.arquivomobileoficialnitro.screens
import BackgroundPrincipal
import Header
import SectionBotoesDeFiltro
import SectionCardHome
import SectionPessoasRecomendas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nitro.arquivomobileoficialnitro.components.*


@Composable
fun TelaBusca(modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    Box() {
        BackgroundPrincipal()
        Column(
            Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .alpha(0.8f)
                .padding(horizontal = 20.dp), // Define a opacidade para 30%
            verticalArrangement = Arrangement.spacedBy(16.dp)

        ) {
            Spacer(modifier = Modifier)
            Header()
            Search(text = "", onTextChange = {})
            SectionBotoesDeFiltro()
            Recomendadas()
            TituloContainer("Talvez você conheça", "Ver mais")
            SectionPessoasRecomendas()
            TituloContainer("Eventos Acontecendo", "ver mais")
            SectionCardHome()
        }
    }
}

@Preview
@Composable
private fun TelaBuscaPreview() {
    TelaBusca()
}