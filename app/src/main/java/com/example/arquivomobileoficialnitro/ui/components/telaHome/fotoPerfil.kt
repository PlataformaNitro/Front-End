package com.example.arquivomobileoficialnitro.ui.components.telaHome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.arquivomobileoficialnitro.R

@Composable
fun FotoPerfil(tamanho:Int,image:Int) {
    Image(
        painter = painterResource(id = image),
        contentDescription = "Foto de perfil",
        modifier = Modifier
            .size(tamanho.dp)
            .clip(CircleShape),
        contentScale = ContentScale.Crop
    )

}

@Preview
@Composable
private fun FotoPerfilPreview() {
    FotoPerfil(74,R.drawable.foto_perfil)
}