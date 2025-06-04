package com.example.arquivomobileoficialnitro.ui.components.telaHome

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.arquivomobileoficialnitro.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextoHeader(modifier: Modifier = Modifier, tamanhoFontTitulo: Int,tamanhoFontDescricao:Int) {
    Column(
        modifier = Modifier.padding(start = 10.dp),
        verticalArrangement = Arrangement.spacedBy(1.dp)
    ) {
        Text(
            text = "Olá, David!",
            fontSize = tamanhoFontTitulo.sp,
            fontFamily = FontFamily(Font(R.font.archivo_black)),
            color = Color.White
        )
        Text(
            text = "faça sua jornada!",
            fontSize = tamanhoFontDescricao.sp,
            fontFamily = FontFamily(Font(R.font.archivo_black)),
            color = Color.Gray
        )
    }
}

@Preview
@Composable
private fun TextoHeaderPreview() {
    TextoHeader(tamanhoFontTitulo = 36, tamanhoFontDescricao = 20)
}
