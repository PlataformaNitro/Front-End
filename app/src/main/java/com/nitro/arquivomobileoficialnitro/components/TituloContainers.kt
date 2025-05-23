package com.nitro.arquivomobileoficialnitro.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.nitro.arquivomobileoficialnitro.R


@Composable
fun TituloContainer(leftText:String,rightText:String) {
    Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()){
        Text(
            text = leftText, fontSize = 20.sp, color = Color.White, fontFamily = FontFamily(Font(R.font.archivo_black))
        )
        Text(
            text = rightText, fontSize = 15.sp, color = Color.White, fontFamily  = FontFamily(Font(R.font.archivo_black))
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TituloContainerPreview() {
    TituloContainer("talvez você conheça","ver mais")
}