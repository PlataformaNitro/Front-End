package com.example.arquivomobileoficialnitro.ui.screen

import NitroLogo
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.orgs.myapplication.Model.User
import com.orgs.myapplication.R

@Composable
fun TelaDePerfil(
    user: User,
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues = PaddingValues(0.dp)
) {
    val scrollEstado = rememberScrollState()
    Column(
        Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colorStops = arrayOf(
                        0.3f to Color(0xFF021030), // 021030 a 30%
                        1.0f to Color(0xFF014677)  // 014677 a 100%
                    )
                )
            )
            .verticalScroll(scrollEstado),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Box(
            modifier
                .fillMaxWidth()
                .height(311.dp)
        ) {
            NitroLogo(modifier.size(94.dp))

            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .height(220.dp)
                    .fillMaxWidth(0.95f)
            ) {
                Surface(
                    Modifier
                        .align(Alignment.BottomCenter)
                        .alpha(0.55f)
                        .fillMaxSize(),
                    color = Color(0xFF2C486B), shape = RoundedCornerShape(size = 25.dp),
                    shadowElevation = 8.dp,
                ) {}

                IconButton(
                    onClick = { println("Botão de menu clicado") },
                    Modifier
                        .align(Alignment.TopStart)
                        .padding(8.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.nitrologo),
                        contentDescription = "Menu",
                        modifier = Modifier
                            .size(38.dp)
                            .alpha(1f),
                        tint = Color.White
                    )
                }

                Row(
                    Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth(0.97f)
                        .padding(vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    listOf("Editar Perfil", "Minhas Rotas", "Moto Clubes").forEach { texto ->
                        Button(
                            onClick = {},
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFBEDAF7)),
                            elevation = ButtonDefaults.buttonElevation(
                                defaultElevation = 5.dp,
                                pressedElevation = 8.dp
                            ),
                            contentPadding = PaddingValues(horizontal = 2.dp, vertical = 2.dp),
                            modifier = Modifier.height(41.dp)
                        ) {
                            Text(
                                text = texto,
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
            }

            Column(
                modifier = Modifier.align(Alignment.Center),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = user.imagem),
                    contentDescription = null,
                    modifier = Modifier
                        .shadow(8.dp, shape = CircleShape)
                        .size(120.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop,
                )
                Text(
                    text = user.nome,
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontFamily = FontFamily(Font(R.font.archivo_black)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFFFFFFFF),
                    ),
                    modifier = Modifier.padding(top = 5.dp)
                )
                // Aqui não tinha campo cidade na classe, se quiser, pode adicionar.
                Text(
                    text = "São Paulo, SP", // Fixado por enquanto
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontFamily = FontFamily(Font(R.font.archivo_black)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFFFFFFFF),
                    )
                )
            }
        }

        Box(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Box(
                Modifier
                    .align(Alignment.Center)
                    .fillMaxWidth(0.95f)
                    .height(220.dp)
            ) {
                Surface(
                    color = Color(0xFF2C486B),
                    shadowElevation = 8.dp,
                    shape = RoundedCornerShape(size = 25.dp),
                    modifier = Modifier
                        .align(Alignment.Center)
                        .alpha(0.55f)
                        .fillMaxSize(),
                ) {}

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 5.dp),
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
                        text = "Biografia: ${user.bio}",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = FontFamily(Font(R.font.archivo_black)),
                            fontWeight = FontWeight(700),
                            color = Color(0xFFFFFFFF),
                        )
                    )
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Moto: ${user.moto}",
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontFamily = FontFamily(Font(R.font.archivo_black)),
                                fontWeight = FontWeight(700),
                                color = Color(0xFFFFFFFF),
                            )
                        )
                        Text(
                            text = "Tipo: ${user.tipo}",
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontFamily = FontFamily(Font(R.font.archivo_black)),
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
                                fontFamily = FontFamily(Font(R.font.archivo_black)),
                                fontWeight = FontWeight(700),
                                color = Color(0xFFFFFFFF),
                            )
                        )
                        Row {
                            Text(
                                modifier = Modifier.align(Alignment.CenterVertically),
                                text = "${user.totalKm} km",
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    fontFamily = FontFamily(Font(R.font.archivo_black)),
                                    fontWeight = FontWeight(400),
                                    color = Color(0xFFFFFFFF),
                                )
                            )
                        }
                    }
                }
            }
        }

        Box(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Box(
                Modifier
                    .align(Alignment.Center)
                    .fillMaxWidth(0.95f)
                    .wrapContentHeight()
            ) {
                Surface(
                    modifier = Modifier
                        .matchParentSize()
                        .align(Alignment.Center)
                        .alpha(0.55f),
                    color = Color(0xFF2C486B),
                    shape = RoundedCornerShape(size = 25.dp),
                    shadowElevation = 8.dp
                ) {}
                Column(
                    verticalArrangement = Arrangement.spacedBy(15.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(horizontal = 10.dp, vertical = 15.dp)
                ) {
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
                    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        Surface(
                            modifier = Modifier
                                .size(width = 192.dp, height = 168.dp),
                            shadowElevation = 5.dp,
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.caiovas),
                                contentDescription = "image description",
                                contentScale = ContentScale.Crop
                            )
                        }
                        Surface(
                            modifier = Modifier
                                .size(width = 192.dp, height = 168.dp)
                                .shadow(5.dp),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.anrjpi),
                                contentDescription = "image description",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .width(400.dp)
                                    .height(400.dp),
                                alignment = Alignment.Center,
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TelaDePerfilPreview() {
    val userPreview = User(
        nome = "Diego",
        imagem = R.drawable.avatarplaceholder,
        bio = "Celebro minha paixão \nsobre duas rodas",
        moto = "Sahara 300",
        tipo = "Adventure",
        totalKm = 12450
    )
    Scaffold { paddingValues -> TelaDePerfil(user = userPreview, paddingValues = paddingValues) }
}
