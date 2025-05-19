package com.nitro.arquivomobileoficialnitro.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nitro.arquivomobileoficialnitro.R


@Composable
fun backgroundPrincipal() {
    // Função para definir o background principal
    Image(
        painter = painterResource(id = R.drawable.img_background_claro_nitro),
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}
@Composable

fun LoginScreen(paddingValues: PaddingValues) {
    Box(modifier = Modifier.fillMaxSize()) {

        // Background Principal
        backgroundPrincipal()
        Image(
            painter = painterResource(id = R.drawable.img_background_claro_nitro),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        //Backgroun secundário
        Image(
            painter = painterResource(id = R.drawable.img_meio_background),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 0.0.dp)
                .align(Alignment.BottomCenter) // fixa ela embaixo
                .offset(y = 210.dp), // sobe um pouco, ou desce
            contentScale = ContentScale.FillWidth,
        )

        // Conteúdo da tela de login
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LoginHeader()
            EmailInput()
            PasswordInput()
            LoginButton()
        }
    }
}
@Composable
fun LoginHeader(loginOrSplash: Boolean = true) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 32.dp, bottom = 16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.nitro_logo),
            contentDescription = "Logo da Nitro",
            modifier = Modifier
                .height(350.dp) // Tamanho da Logo
        )
        // Texto abaixo da logo
        if( loginOrSplash){
        Text(
            text = "O Caminho Certo para quem vive sobre duas rodas!",
            fontSize = 25.sp, // Tamanho do texto
            fontWeight = FontWeight.Bold, // Peso da fonte
            color = Color.White, // Cor do texto
            textAlign = TextAlign.Center,
            letterSpacing = 1.5.sp, // Espaçamento entre as letras
            modifier = Modifier
                .offset(y = (-110).dp) // Espaço entre a logo e o texto
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally) // Centraliza o texto
        )
    }}

}

@Composable
fun EmailInput(){

}

@Composable
fun PasswordInput(){

}

@Composable
fun LoginButton(){

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(
        paddingValues = PaddingValues(16.dp)) // Defina o padding desejado aqui
}
