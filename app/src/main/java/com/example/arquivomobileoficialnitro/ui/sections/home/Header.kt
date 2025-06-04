package com.example.arquivomobileoficialnitro.ui.sections.homeimport

import androidx.compose.foundation.layout.Row
import com.example.arquivomobileoficialnitro.ui.components.telaHome.FotoPerfil
import com.example.arquivomobileoficialnitro.ui.components.telaHome.TextoHeader
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.arquivomobileoficialnitro.R

@Composable
fun Header(modifier: Modifier = Modifier) {
    Row{
        FotoPerfil(74, R.drawable.foto_perfil,modifier)
        TextoHeader(tamanhoFontTitulo = 36, tamanhoFontDescricao = 20)
    }
}

@Preview
@Composable
private fun HeaderPreview() {
    Header()
}