package com.nitro.arquivomobileoficialnitro.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import com.nitro.arquivomobileoficialnitro.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Search(
    modifier: Modifier = Modifier,
    text: String,
    onTextChange: (String) -> Unit
) {
    OutlinedTextField(
        value = text,
        onValueChange = onTextChange,
        label = { Text("Procurar", fontFamily = FontFamily(Font(R.font.archivo_black))) },
        placeholder = { Text("O que você procura?", fontFamily = FontFamily(Font(R.font.archivo_black))) },
        leadingIcon = {
            Icon(Icons.Default.Search, contentDescription = "Ícone de busca")
        },
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(25),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color(0xFF1C2228),
            unfocusedContainerColor = Color(0xFF1C2228),
            disabledContainerColor = Color(0xFF1C2228)
        )
    )
}

@Preview
@Composable
fun SearchPreview() {
    //var text by remember { mutableStateOf("") }
    Search(
        text = "",
        onTextChange = {  }
    )
}
