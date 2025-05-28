package com.example.arquivomobileoficialnitro.ui.screen

import BackgroundPrincipal
import HeaderLogin
import Logo
import SectionTodasAsOpcoesLogin
import SloganTexto
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun LoginScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        BackgroundPrincipal()
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HeaderLogin(Modifier.padding(top = 0.dp))
            SectionTodasAsOpcoesLogin(Modifier.padding(top = 14.dp))
        }
    }
}
@Preview()
@Composable
private fun LoginScreenPreview() {
    LoginScreen()
}
