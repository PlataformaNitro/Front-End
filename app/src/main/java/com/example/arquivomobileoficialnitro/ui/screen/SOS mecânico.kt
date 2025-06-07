package com.example.arquivomobileoficialnitro.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.arquivomobileoficialnitro.R
import kotlinx.coroutines.delay

@Preview(showBackground = true)
@Composable
fun PreviewMecanicoScreen() {
    MecanicoScreen()
}

@Composable
fun MecanicoScreen(paddingValues: PaddingValues = PaddingValues(0.dp), modifier: Modifier = Modifier) {
    val textos = listOf(
        "Uma \nambulância ","Uma \nautoridade policial ","Um \ncaminhão de bombeiro "
    )
    var finalDoTexto = listOf("será \nchamada", "está \nsendo chamada", "está \nsendo chamado", "será \nchamado")
    var apontadorTexto by rememberSaveable { mutableIntStateOf(0) }
    var apontadorFinalDoTexto by rememberSaveable { mutableIntStateOf(0) }
    val corDesativado = Color(0xFF001F54) // Azul escuro
    val corAtivado = Color.White
    var botoesVisiveis by rememberSaveable() {  mutableStateOf(true) }
    var tempoRestanteSegundos = 30
    var textotemporizador by rememberSaveable { mutableStateOf("0:30") }

    LaunchedEffect(Unit) {

        while (tempoRestanteSegundos > 0) {
            delay(1000) // Espera 1 segundo
            tempoRestanteSegundos--
        }
        botoesVisiveis = false // Esconde os botões quando o tempo acabar
        if( apontadorTexto == 1 || apontadorTexto == 0){
            apontadorFinalDoTexto = 1
        }else{
            apontadorFinalDoTexto = 2
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background( brush = Brush.verticalGradient(
                colors = listOf(
                    Color(0xFF030B3A), // Dark Purple
                    Color(0xFF005EAA)  // Lighter Purple
                )
            ))
            .padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = "SOS Mecânico",
            color = Color.White,
            fontFamily = FontFamily(Font(R.font.archivo_black)),
            fontSize = 32.sp,
            fontWeight = FontWeight(400),
            modifier = Modifier.padding(vertical = 39.dp),

            )

        Image(
            painter = painterResource(R.drawable.icone_do_sosmecanico), // Use your own icon resource
            contentDescription = "Ícone de Alerta",
            modifier = Modifier.size(100.dp)
        )
        Text(
            text = "Vamos entrar em contato com a " + "MotoPro",
            fontSize = 24.sp,
            fontFamily = FontFamily(Font(R.font.archivo_black)),
            fontWeight = FontWeight(400),
            modifier = Modifier.padding(top = 26.dp)
                .width(241.dp)
                .height(104.dp)
            ,
            color = Color(0xFFFFFFFF),

            textAlign = TextAlign.Center,
        )

        Spacer(Modifier.height(100.dp))
        if(botoesVisiveis){
            Text(
                text = "Trocar de mecânico",
                fontSize = 24.sp,
                fontFamily = FontFamily(Font(R.font.archivo)),
                fontWeight = FontWeight(400),
                color = Color(0xFFFFFFFF),

                textAlign = TextAlign.Center,
                modifier =   Modifier.padding(top = 20.dp)
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.padding(horizontal = 14.dp)
            ) {
                Button(
                    onClick = { apontadorTexto = 0;apontadorFinalDoTexto = 0 },
                    shape = RoundedCornerShape(10.dp), // Ajuste o raio para o arredondamento desejado
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (apontadorTexto != 0) corDesativado else Color.White // Um azul escuro, ajuste conforme necessário
                    ),
                    modifier = Modifier.height(56.dp)
                        .shadow(elevation = 4.dp),
                    contentPadding = PaddingValues(
                        horizontal = 11.dp,
                        vertical = 12.dp
                    ),

                    ) {
                    Text(
                        "Médico", color = if(apontadorTexto != 0) Color.White else Color.Black,

                        fontSize = 20.sp,
                        fontWeight = FontWeight(400),
                        fontFamily = FontFamily(Font(R.font.archivo_black))

                    )
                }
                MotoFreeBanner()
            }


            Button(
                onClick = { apontadorTexto = 2; apontadorFinalDoTexto = 4 },
                colors = ButtonDefaults.buttonColors(Color.Black),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding( top  = 10.dp, bottom = 20.dp, start = 14.dp, end = 14.dp),
                contentPadding = PaddingValues(vertical = 15.dp)
            ) {
                Text("Cancelar", color = Color.White,
                    fontSize = 28.sp,
                    fontFamily = FontFamily(Font(R.font.archivo_black)),
                    fontWeight = FontWeight(400),)
            }

        }else(
                Spacer(Modifier.height(200.dp))
                )
    }
}

@Composable
fun MotoFreeBanner() {
    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        shadowElevation = 4.dp, // Adiciona uma sombra para dar destaque
        shape = RoundedCornerShape(12.dp),
        color = Color(0xFFEAEAEA) // Um cinza claro similar ao da imagem
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically // Alinha todos os itens ao centro verticalmente
        ) {
            // Ícone de localização
            Icon(
                imageVector = Icons.Default.LocationOn,
                contentDescription = "Ícone de Localização"
            )

            Spacer(modifier = Modifier.width(8.dp))

            // Texto principal
            Text(
                text = "MotoFree",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyLarge
            )

            // Spacer com peso para empurrar o resto para a direita
            Spacer(modifier = Modifier.weight(1f))

            // Texto da distância
            Text(
                text = "2km",
                color = Color.Gray,
                style = MaterialTheme.typography.bodyMedium
            )

            // Ícone de seta
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "Ver detalhes",
                tint = Color.Black
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MotoFreeBannerPreview() {
    // Adicionamos um padding no preview para ver melhor o componente
    Box(modifier = Modifier.padding(16.dp)) {
        MotoFreeBanner()
    }
}
