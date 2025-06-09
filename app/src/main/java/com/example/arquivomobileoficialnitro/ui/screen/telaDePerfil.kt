package com.example.arquivomobileoficialnitro.ui.screen

import androidx.compose.material3.Surface
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.example.arquivomobileoficialnitro.R

@Composable
fun TelaDePerfil(modifier: Modifier = Modifier, paddingValues: PaddingValues = PaddingValues(0.dp)) {
    val scrollEstado = rememberScrollState()
Column(Modifier.fillMaxSize() .background(brush = Brush.verticalGradient(
    colorStops = arrayOf(
        0.3f to Color(0xFF021030), // 021030 a 30%
        1.0f to Color(0xFF014677)  // 014677 a 100%
    )))  .verticalScroll(scrollEstado), verticalArrangement = Arrangement.spacedBy(10.dp)) {
    Box(modifier.fillMaxWidth() .height(311.dp)) {
        /*
        Image(
            painter = painterResource(id = R.drawable.perfil), // Substitua pelo seu logo
            modifier = Modifier.fillMaxWidth(),
            contentDescription = null,
            contentScale = ContentScale.Crop// Tamanho do seu logo
            // Raio do brilho, ajuste conforme necessário
        )
        */
            Image(
                painter = painterResource(id = R.drawable.mini_logo),
                contentDescription = null,
                modifier = Modifier.size(91.dp)
                    .shadow( spotColor = Color(0xFF4A83DE), ambientColor = Color(0xFF4A83DE), elevation = 60.dp, shape = CircleShape)
                    .align(Alignment.TopStart)
            )
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter) // Alinhamento original do Surface
                .height(220.dp)
                .fillMaxWidth(0.95f)
        ){
        Surface(Modifier.align(Alignment.BottomCenter)
            .alpha(0.55f)
            .fillMaxSize(),
            color = Color(0xFF2C486B), shape = RoundedCornerShape(size = 25.dp),
            shadowElevation = 8.dp,

        ){}

            IconButton(onClick = {
                println("Botão de menu clicado")
            }, Modifier.align(Alignment.TopStart).padding(8.dp)) {
                Icon(
                    painter = painterResource(id = R.drawable.seta_para_esquerda),
                    contentDescription = "Menu",
                    modifier = Modifier.size(38.dp) .alpha(1f),
                    tint = Color.White
                )
            }
            Row(Modifier.align(Alignment.BottomCenter)  .fillMaxWidth(0.97f) .padding(vertical  = 10.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween ){
Button(onClick = {}, shape = RoundedCornerShape(10.dp), colors = ButtonDefaults.buttonColors(
    containerColor =  Color(0xFFBEDAF7)), elevation = ButtonDefaults.buttonElevation(
    defaultElevation = 5.dp,
    pressedElevation = 8.dp
    ), contentPadding = PaddingValues(horizontal = 2.dp, vertical = 2.dp), modifier = Modifier.height(41.dp)  ) {
    Text(
        text = "Editar Perfil",
        style = TextStyle(
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.archivo_black)),
            fontWeight = FontWeight(400),
            color = Color(0xFF00183C),

            )
    )
}
                Button(onClick = {}, shape = RoundedCornerShape(10.dp), colors = ButtonDefaults.buttonColors(
                    containerColor =  Color(0xFFBEDAF7)), elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 5.dp,
                    pressedElevation = 8.dp
                ), contentPadding = PaddingValues(horizontal = 2.dp, vertical = 2.dp), modifier = Modifier.height(41.dp)) {
                    Text(
                        text = "Minhas Rotas",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.archivo_black)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF00183C),

                            )
                    )
                }
                Button(onClick = {}, shape = RoundedCornerShape(10.dp), colors = ButtonDefaults.buttonColors(
                    containerColor =  Color(0xFFBEDAF7)), elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 5.dp,
                    pressedElevation = 8.dp
                ), contentPadding = PaddingValues(horizontal = 2.dp, vertical = 2.dp), modifier = Modifier.height(41.dp)) {
                    Text(
                            text = "Moto Clubes",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontFamily = FontFamily(Font(R.font.archivo_black)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF00183C),

                                )

                    )
                }
            }
        }
        Column(modifier =Modifier.align(Alignment.Center), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
        Image(
            painter = painterResource(id = R.drawable.foto_perfil),
            contentDescription = null,
            modifier = Modifier
                .shadow(8.dp, shape = CircleShape)
                .size(120.dp)
                .clip(CircleShape)
            ,
            contentScale = ContentScale.Crop,
        )
            Text(
                text = "Diego",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font(R.font.archivo_black)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFFFFFFFF),

                    ),modifier = Modifier.padding(top = 5.dp)
            )
            Text(
                text = "São Paulo, SP",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font(R.font.archivo)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFFFFFFFF),

                    )
            )

        }



    }
    Box(modifier = Modifier.align(Alignment.CenterHorizontally)) {
        Box(
            Modifier.align(Alignment.Center)
                .fillMaxWidth(0.95f)
                .height(220.dp)
        ) {
            Surface(
                color = Color(0xFF2C486B),shadowElevation = 8.dp, shape = RoundedCornerShape(size = 25.dp),
                 modifier = Modifier.align(Alignment.Center)
                    .alpha(0.55f)
                    .fillMaxSize(),


                ) {}

            Column(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp, vertical = 5.dp),
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = "Informações Pessoais",
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontFamily = FontFamily(Font(R.font.archivo_black)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFFFFFFFF),

                        )


                )
                Text(
                    text = "Biografia: Celebro minha paixão \nsobre duas rodas",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.archivo)),
                        fontWeight = FontWeight(700),
                        color = Color(0xFFFFFFFF),

                        )
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Moto: Sahara 300 ",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = FontFamily(Font(R.font.archivo)),
                            fontWeight = FontWeight(700),
                            color = Color(0xFFFFFFFF),

                            )
                    )
                    Text(
                        text = "Tipo: Adventure",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = FontFamily(Font(R.font.archivo)),
                            fontWeight = FontWeight(700),
                            color = Color(0xFFFFFFFF),

                            )
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Total de Quilômetros \nRodados:",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = FontFamily(Font(R.font.archivo)),
                            fontWeight = FontWeight(700),
                            color = Color(0xFFFFFFFF),

                            )
                    )
                    Row {
                        Text(
                            modifier = Modifier.align(Alignment.CenterVertically),
                            text = "12.450 km",
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
        }


            }
    Box(modifier = Modifier.align(Alignment.CenterHorizontally)){
        Box(Modifier.align(Alignment.Center)
            .fillMaxWidth(0.95f)
            .height(440.dp)
        ){
            Surface(    modifier = Modifier
                .align(Alignment.Center)
                .alpha(0.55f)
                .fillMaxSize(),
                color = Color(0xFF2C486B),
                shape = RoundedCornerShape(size = 25.dp),
                shadowElevation = 8.dp

                ){}
            Column(verticalArrangement = Arrangement.spacedBy(15.dp), horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize() .padding(horizontal = 10.dp, vertical = 15.dp)) {
                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = "Galeria de Fotos",
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontFamily = FontFamily(Font(R.font.archivo_black)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFFFFFFFF),

                        )
                )
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)){
                    Surface(
                        modifier = Modifier
                            .size(width = 192.dp, height = 168.dp),
                            shadowElevation = 5.dp,
                             shape =    RoundedCornerShape(12.dp)
                    ) {
                        Image(
                            modifier = Modifier.fillMaxSize(),
                            painter = painterResource(id = R.drawable.imagem_galeria2),
                            contentDescription = "image description",
                            contentScale = ContentScale.Crop // imagens bugadas para consertar
                        )
                    }
                    Surface(
                        modifier = Modifier
                            .size(width = 192.dp, height = 168.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .shadow(5.dp)
                    ) {
                        Image(
                            modifier = Modifier.fillMaxSize(),
                            painter = painterResource(id = R.drawable.unsplash_crqe6xl_4pe),
                            contentDescription = "image description",
                            contentScale = ContentScale.FillBounds
                        )
                    }


                }
            }
        }}
        }

}

@Preview
@Composable
private fun TelaDePerfilPreview()
{Scaffold{ paddingValues -> TelaDePerfil(paddingValues = paddingValues) }

}



