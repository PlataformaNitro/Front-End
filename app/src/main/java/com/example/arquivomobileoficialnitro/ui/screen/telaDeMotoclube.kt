package com.example.arquivomobileoficialnitro.ui.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.ui.graphics.Brush
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.arquivomobileoficialnitro.R

/*

Pesquisar layout adaptativo e mudar as fontes
*/
@Composable
fun TeladeMotoClubes(modifier: Modifier = Modifier) {
    Column(Modifier .verticalScroll(rememberScrollState()) .fillMaxSize()){
        Box(Modifier
        .fillMaxWidth().height(280.dp)) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {

                Image(
                    painter = painterResource(id = R.drawable.banner_motoclube_default),
                    modifier = Modifier.fillMaxSize(),
                    contentDescription = "Mapa",
                    contentScale = ContentScale.FillBounds
                )
                Box(Modifier.fillMaxSize() .alpha(0.4f) .background(Color.Black)){}
                Text(
                    text = "Insanos MC",
                    style = TextStyle(
                        fontSize = 32.sp,
                        fontFamily = FontFamily(Font(R.font.archivo_black)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFFFFFFFF),

                        ),
                    modifier = Modifier
                        .align(Alignment.Center),
                )
                Text(
                    text = "24.600.520",
                    style = TextStyle(
                        fontSize = 32.sp,
                        fontFamily = FontFamily(Font(R.font.archivo)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFFFFFFFF),

                        ),
                    modifier = Modifier.align(Alignment.BottomStart) .padding(vertical = 30.dp, horizontal = 35.dp)
                )
                Text(
                    text = "Membros",
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontFamily = FontFamily(Font(R.font.archivo)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFFFFFFFF),

                        ),
                    modifier = Modifier.align(Alignment.BottomStart) .padding(vertical = 5.dp, horizontal = 35.dp)
                )
                Box(Modifier.align(Alignment.TopEnd) .padding(horizontal = 10.dp, vertical = 10.dp) .width(70.dp)
                    .height(70.dp)
                    .background(color = Color(0xFFD9D9D9), shape = CircleShape)){
                    Column(Modifier.align(Alignment.Center)) {
                        Text(
                            text = "1º",
                            style = TextStyle(
                                fontSize = 32.sp,
                                fontFamily = FontFamily(Font(R.font.archivo)),
                                fontWeight = FontWeight(500),
                                color = Color(0xFF000000),

                                textAlign = TextAlign.Center,
                        ),
                                    modifier = Modifier.align(Alignment.CenterHorizontally) .padding(start = 5.dp),
                        )
                        Text(
                            text = "no Mundo",
                            modifier = Modifier .padding(bottom = 5.dp) .align(Alignment.CenterHorizontally),
                            style = TextStyle(
                                fontSize = 11.sp,
                                fontFamily = FontFamily(Font(R.font.archivo)),
                                fontWeight = FontWeight(500),
                                color = Color(0xFF000000),

                                textAlign = TextAlign.Center,
                            )
                        )
                    }

                }
                IconButton(
                    onClick = {}, modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(10.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBackIosNew,
                        contentDescription = "Voltar",
                        modifier = Modifier
                            .width(50.dp)
                            .height(50.dp),
                        tint = Color.White
                    )

                }


            }
        }

        Surface(
            Modifier
                .fillMaxHeight(0.70f)
                .fillMaxWidth(),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colorStops = arrayOf(0.3f to Color(0xFF012E52), 1f to Color(0xFF010C26))
                            // Definindo as posições das cores no gradiente (de 0f a 1f)
                        )
                    )
                    .padding(vertical = 10.dp, horizontal = 5.dp)
            ) {
                Column(
                    Modifier
                        .fillMaxSize()

                ) {
                    Box(
                        Modifier
                            .align(Alignment.CenterHorizontally)
                            .fillMaxWidth()
                            .wrapContentHeight()
                    ) {
                        Surface(
                            modifier = Modifier
                                .matchParentSize()
                                .alpha(0.55f),
                            color = Color(0xFF00183C),
                            shape = RoundedCornerShape(size = 20.dp)
                        ) { }
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .padding(10.dp)
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                                Text(
                                    text = "Descrição",
                                    style = TextStyle(
                                        fontSize = 24.sp,
                                        fontFamily = FontFamily(Font(R.font.archivo_black)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFFFFFFFF),

                                        )
                                )
                                Text(
                                    text = "Participar do Insanos MC é mais do que fazer parte do maior moto clube do Brasil; é integrar uma família onde cada membro é tratado com respeito e dignidade. Juntos, compartilhamos não apenas a paixão pelas motocicletas, mas também valores e princípios que fortalecem nossos laços e enriquecem nossas vidas.",
                                    modifier = Modifier.padding(top = 5.dp),
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontFamily = FontFamily(Font(R.font.archivo)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFFFFFFFF),
                                        textAlign = TextAlign.Center,
                                    )
                                )
                                Text(
                                    text = "Localização", modifier = Modifier.padding(top = 40.dp),

                                    style = TextStyle(
                                        fontSize = 20.sp,
                                        fontFamily = FontFamily(Font(R.font.archivo_black)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFFFFFFFF),
                                    )
                                )
                                Text(
                                    text = "São Paulo, SP",
                                    modifier = Modifier.padding(top = 5.dp),
                                    style = TextStyle(
                                        fontSize = 20.sp,
                                        fontFamily = FontFamily(Font(R.font.archivo)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFFFFFFFF),
                                    )
                                )
                                Text(
                                    text = "Estilo",
                                    modifier = Modifier.padding(top = 20.dp),
                                    style = TextStyle(
                                        fontSize = 20.sp,
                                        fontFamily = FontFamily(Font(R.font.archivo_black)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFFFFFFFF),
                                    )
                                )
                                Text(
                                    text = "Motociclistas Brasileiros",
                                    modifier = Modifier.padding(top = 5.dp),
                                    style = TextStyle(
                                        fontSize = 20.sp,
                                        fontFamily = FontFamily(Font(R.font.archivo)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFFFFFFFF),
                                    )
                                )
                            }


                        }

                    }
                    Text(
                        text = "Contatos",
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(top = 20.dp),
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = FontFamily(Font(R.font.archivo_black)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFFFFFFFF),
                        )
                    )
                    Column(
                        modifier = Modifier.padding(bottom = 40.dp),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.spacedBy(30.dp)
                    ) {
                        Row{
                        Box {
                            Surface(
                                Modifier
                                    .alpha(0.55f)
                                    .width(90.dp)
                                    .height(90.dp),
                                color = Color(0xFF00183C),
                                shape = RoundedCornerShape(size = 25.dp)
                            ) {}
                            IconButton(
                                onClick = {},
                                Modifier
                                    .align(Alignment.Center)
                                    .width(65.dp)
                                    .height(65.dp)
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.facebook_default),
                                    contentDescription = null,
                                )
                            }
                        }
                        Text("Facebook",
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontFamily = FontFamily(Font(R.font.archivo)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFFFFFFFF),
                            ),
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .padding(start = 10.dp)
                        )

                        }
                        Row{
                        Box {
                            Surface(
                                Modifier
                                    .alpha(0.55f)
                                    .width(90.dp)
                                    .height(90.dp),
                                color = Color(0xFF00183C),
                                shape = RoundedCornerShape(size = 25.dp)
                            ) {}
                            IconButton(
                                onClick = {},
                                Modifier
                                    .align(Alignment.Center)
                                    .width(75.dp)
                                    .height(75.dp)
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.instagram),
                                    contentDescription = null,
                                )
                            }
                        }
                            Text("Instagram",
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    fontFamily = FontFamily(Font(R.font.archivo)),
                                    fontWeight = FontWeight(400),
                                    color = Color(0xFFFFFFFF),
                                ),
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                                    .padding(start = 10.dp)
                            )
                        }
                    }

                }


            }

        }
    }
}

@Preview
@Composable
private fun PreviewTelaDeMotoclube() {
    TeladeMotoClubes()
}