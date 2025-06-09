package com.example.arquivomobileoficialnitro.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
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
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
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
    val iconesTiposDeMecanico = listOf(
        R.drawable.icone_de_localproximo,R.drawable.icone_de_especialidade, R.drawable.icone_de_popularidade
    )
    var apontadorTexto by rememberSaveable { mutableIntStateOf(0) }
    var apontadorFinalDoTexto by rememberSaveable { mutableIntStateOf(0) }
    var botoesVisiveis by rememberSaveable() {  mutableStateOf(true) }
    var tempoRestanteSegundos = 20
    var textotemporizador by rememberSaveable { mutableStateOf("0:30") }
    var a by rememberSaveable { mutableIntStateOf(0) }
    var b by rememberSaveable { mutableIntStateOf(0) }
    var c by rememberSaveable { mutableIntStateOf(0) }
    var d by rememberSaveable { mutableIntStateOf(0) }
    var mecanicoPrincipal by rememberSaveable { mutableStateOf("MotoPro") }

    var listaMecanicoPopular = listOf(
        "MotoPOP" to "4.2km",
        "MotoPOP2" to "4.2km",
        "MotoPOP3" to "4.2km"
    )
    var listaMecanicoProximo = listOf(
        "MotoFree" to "4.2km",
        "MotoFree2" to "4.2km",
        "MotoFree3" to "4.2km"
    )
    var listaMecanicoespecialista = listOf(
        "MotoEspec" to "4.2km",
        "MotoEspec2" to "4.2km",
        "MotoEspec3" to "4.2km"
    )
    var visibleA by rememberSaveable { mutableStateOf(true) }
    var visibleB by rememberSaveable { mutableStateOf(true) }
    var visibleC by rememberSaveable { mutableStateOf(true) }
    var visibleAlternative by rememberSaveable { mutableStateOf(false) }

    var listadasListasDeMecanico = listOf(listaMecanicoProximo, listaMecanicoespecialista, listaMecanicoPopular)
    var listaDevarieveisModificaveis = mutableListOf(visibleA, visibleB, visibleC, visibleAlternative)
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
            modifier = Modifier.padding(top = 39.dp),

            )

        Image(
            painter = painterResource(R.drawable.icone_do_sosmecanico), // Use your own icon resource
            contentDescription = "Ícone de Alerta",
            modifier = Modifier.size(100.dp)
        )
        Spacer(Modifier.height(30.dp))
        Column (horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Vamos entrar em contato com a " + mecanicoPrincipal,
            fontSize = 24.sp,
            fontFamily = FontFamily(Font(R.font.archivo_black)),
            fontWeight = FontWeight(400),
            modifier = Modifier
                .width(241.dp)
            ,
            color = Color(0xFFFFFFFF),

            textAlign = TextAlign.Center,
        )
        if(!botoesVisiveis){
            Text(
                text = "(**) *****-****",
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font(R.font.archivo)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFFFFFFFF),
                    textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 20.dp)

            )
        }}

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
                if(visibleA) {
                    MotoFreeBanner(
                        nomeDoMecanico = listaMecanicoProximo[a],
                        icon = iconesTiposDeMecanico[0], aoApertar = {
                            visibleAlternative = !visibleAlternative
                            visibleB = !visibleB
                            visibleC = !visibleC
                            d = 0
                        }, aoApertarNaArea = {mecanicoPrincipal = listaMecanicoProximo[a].first}
                    )
                }
                if(visibleB) {
                    MotoFreeBanner(
                        nomeDoMecanico = listaMecanicoespecialista[b],
                        icon = iconesTiposDeMecanico[1], aoApertar = {
                            visibleAlternative = !visibleAlternative
                            visibleA = !visibleA
                            visibleC = !visibleC
                            d = 1
                        }, aoApertarNaArea = {mecanicoPrincipal = listaMecanicoespecialista[b].first}
                    )
                }

if(visibleC) {
                    MotoFreeBanner(
                        nomeDoMecanico = listaMecanicoPopular[c],
                        icon = iconesTiposDeMecanico[2], aoApertar = {
                            visibleAlternative = !visibleAlternative
                            visibleA = !visibleA
                            visibleB = !visibleB
                            d=2
                        }, aoApertarNaArea = {mecanicoPrincipal = listaMecanicoPopular[c].first}
                    )
                }
                if(visibleAlternative){
                    MotoFreeBanner(
                        nomeDoMecanico = listadasListasDeMecanico[d][1],
                        icon = iconesTiposDeMecanico[d], expanderView = false, aoApertar = {
                            visibleAlternative = !visibleAlternative
                            visibleA = true
                            visibleB = true
                            visibleC = true
                        },
                 aoApertarNaArea = {mecanicoPrincipal = listadasListasDeMecanico[d][1].first}

                    )
                    MotoFreeBanner(
                        nomeDoMecanico = listadasListasDeMecanico[d][2],
                        icon = iconesTiposDeMecanico[d], expanderView = false, aoApertar = {
                            visibleAlternative = !visibleAlternative
                            visibleA = true
                            visibleB = true
                            visibleC = true
                        },
                        aoApertarNaArea = {mecanicoPrincipal = listadasListasDeMecanico[d][2].first}
                    )
                }
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

        }else {
            Spacer(Modifier.height(100.dp))
            Button(
                onClick = { apontadorTexto = 2; apontadorFinalDoTexto = 4 },
                colors = ButtonDefaults.buttonColors(Color.Black),
                modifier = Modifier.padding(vertical = 3.dp),
                contentPadding = PaddingValues(vertical = 15.dp, horizontal=14.dp)
            ) {
                Text(
                    "Cancelar", color = Color.White,
                    fontSize = 28.sp,
                    fontFamily = FontFamily(Font(R.font.archivo_black)),
                    fontWeight = FontWeight(400),
                )
            }
        }
    }
}

@Composable
fun MotoFreeBanner(nomeDoMecanico: Pair<String,String> = "MotoFree" to "2km", modifier: Modifier = Modifier, icon:Int, aoApertar: () -> Unit= {},aoApertarNaArea: () -> Unit = {}, expanderView : Boolean = true) {
    var rotate by rememberSaveable() { mutableFloatStateOf(0f) }
    Surface(
        modifier = Modifier
            .width(252.dp)
            .height(36.dp)
            .clickable { aoApertarNaArea(); if(!expanderView || rotate == 90f) aoApertar() },
        shadowElevation = 4.dp, // Adiciona uma sombra para dar destaque
        shape = RoundedCornerShape(12.dp),
        color = Color(0xFFD9D9D9)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically // Alinha todos os itens ao centro verticalmente
        ) {
            // Ícone de localização
            Icon(
                painter = painterResource(icon), // Use o ícone de localização
                contentDescription = "Ícone de Localização",
                modifier = Modifier.padding(horizontal = 8.dp)
            )


            // Texto principal
            Text(
                text = nomeDoMecanico.first,
                fontFamily = FontFamily(Font(R.font.archivo_black)),
            )

            // Spacer com peso para empurrar o resto para a direita
            Spacer(modifier = Modifier.weight(1f))

            // Texto da distância
            Text(
                text = nomeDoMecanico.second,
                color = Color.Gray,
                style = MaterialTheme.typography.bodyMedium
            )

            // Ícone de seta
            if(expanderView){
            IconButton(onClick = {
                if(rotate == 0f) {
                    rotate = 90f
                } else {
                    rotate = 0f
                }
                aoApertar()

            }) {
            Icon(
                painter = painterResource(R.drawable.icone_de_setasosmecanico),
                contentDescription = "Ver detalhes",
                tint = Color.Black,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .rotate(rotate)
            )}
        }else{
          Spacer(Modifier.width(46.dp))  }}
    }
}

@Preview(showBackground = true)
@Composable
fun MotoFreeBannerPreview() {
    // Adicionamos um padding no preview para ver melhor o componente
    Box(modifier = Modifier.padding(16.dp)) {
    }
}
