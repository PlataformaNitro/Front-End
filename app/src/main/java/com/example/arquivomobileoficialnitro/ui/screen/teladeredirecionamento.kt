package com.example.arquivomobileoficialnitro.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.ui.graphics.Brush
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.arquivomobileoficialnitro.R

@Composable
fun TeladeRedirecionamento(modifier: Modifier = Modifier) {
    Box(Modifier.fillMaxSize()){
    Box(modifier = Modifier.fillMaxHeight(0.3f) .fillMaxWidth()) {

        Image(
            painter = painterResource(id = R.drawable.imagem_exemplo_de_mapa),
            modifier = Modifier.fillMaxSize(),
            contentDescription = "Mapa",
            contentScale = ContentScale.FillBounds
        )
        // Aqui você pode adicionar o conteúdo da tela de redirecionamento
        // Por exemplo, um texto ou uma imagem que indique que o usuário está sendo redirecionado
        IconButton(onClick = {}, modifier = Modifier.align(Alignment.TopStart) .shadow(elevation = 4.dp, spotColor = Color(0x40000000), ambientColor = Color(0x40000000))

            .padding(10.dp)

        ){
            Icon(painter = painterResource(id = R.drawable.icone_de_saida),
                contentDescription = "Voltar",
              tint = Color.White,
                modifier = Modifier             .width(32.dp)
                    .height(31.dp)
            )

        }
        Button(onClick = {}, modifier = Modifier.align(Alignment.TopEnd)
            .padding(10.dp)
            .width(74.dp)
            .height(39.dp)
            ,
                colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFD9D9D9) // Cor de fundo do botão
        ), shape = RoundedCornerShape(size = 30.dp), contentPadding = PaddingValues()
        ){
            Image(
                painter = painterResource(id = R.drawable.icone_de_caneta),
                contentDescription = "Botão de ação",
                modifier =  Modifier.size(32.dp),
            )
        }
    }
        Surface(Modifier.align(Alignment.BottomCenter) .fillMaxHeight(0.75f) .fillMaxWidth(), shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colorStops = arrayOf( 0.3f to Color(0xFF021030), 1f to Color(0xFF014677) )
                            // Definindo as posições das cores no gradiente (de 0f a 1f)
                        )
                    )
                    .padding(20.dp)
            ) {
                Column(Modifier.fillMaxSize()){
                    Text(
                        text = "Descanso no parque",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = FontFamily(Font(R.font.archivo_black)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFFFFFFFF),

                            )
                    )
                    Text(
                        text = "Estimativa: 1 hora",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.archivo)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFFFFFFFF),

                            )
                    )
                    Row (horizontalArrangement = Arrangement.spacedBy(5.dp)){
                        Icon(
                            painter = painterResource(R.drawable.icone_bomba_de_gasolina),
                            contentDescription = "Ícone de gasolina",
                            modifier = Modifier
                                .size(24.dp),
                            tint = Color.White

                        )
                        Box(Modifier
                            .align(Alignment.CenterVertically)
                            .width(35.64376.dp)
                            .height(4.dp)
                            .background(color = Color(0xFF4A83DE), shape = RoundedCornerShape(size = 10.dp)))
                        Box(Modifier
                            .align(Alignment.CenterVertically)
                            .width(35.64376.dp)
                            .height(4.dp)
                            .background(color = Color(0xFFD9D9D9), shape = RoundedCornerShape(size = 10.dp)))
                        Box(Modifier
                            .align(Alignment.CenterVertically)
                            .width(35.64376.dp)
                            .height(4.dp)
                            .background(color = Color(0xFFD9D9D9), shape = RoundedCornerShape(size = 10.dp)))

                    }
                    Spacer(Modifier.height(30.dp))
                    Box(Modifier .align(Alignment.CenterHorizontally)
                        .width(373.dp)
                        .wrapContentHeight()){
                    Surface(modifier= Modifier.matchParentSize()  .alpha(0.55f), color = Color(0xFF00183C), shape = RoundedCornerShape(size = 20.dp)
                        ) {   }
                        Box(modifier = Modifier.fillMaxWidth() .wrapContentHeight() .padding(10.dp)){
Column {
                            Text(
                            text = "Descrição:",
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontFamily = FontFamily(Font(R.font.archivo_black)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFFFFFFFF),

                                )
                        )
                            Text(
                                text = "Nesse trajeto maravilhoso, a Rua Tito, Lapa se transforma em avenidas arborizadas que revelam paisagens naturais surpreendentes. Ao longo do caminho, admire a transição dos prédios altos para colinas verdejantes, com a Mata Atlântica surgindo gradualmente. #ConexãoVerde",
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    fontFamily = FontFamily(Font(R.font.archivo)),
                                    fontWeight = FontWeight(400),
                                    color = Color(0xFFFFFFFF),

                                    )
                            )}

                        }}

                }
                Row(modifier = Modifier.align(Alignment.BottomCenter) .padding(bottom = 40.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(30.dp)){
                    IconButton(onClick = {}, modifier = Modifier.size(49.dp)){
                            Icon(
                                painter = painterResource(R.drawable.icone_compartihamento),
                                contentDescription = "Compartilhar",
                                modifier = Modifier.size(width = 38.dp, height = 41.dp) .shadow(40.dp),
                                tint = Color.White
                            )
                         }
                    Button(onClick={},
                        modifier = Modifier .width(94.dp)
                            .height(90.dp) ,colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD9D9D9)),
                        contentPadding = PaddingValues(1.dp,1.dp)
                    ){
                        Icon(
                            painter = painterResource(R.drawable.icone_de_especialidade),
                            contentDescription = "Especialidade",
                            tint = Color.Black,
                            modifier = Modifier
                                    .width(67.dp)
                                .height(60.dp)
                        )
                    }
                    IconButton(onClick = {}, modifier = Modifier.size(49.dp)){
                        Icon(
                            painter = painterResource(R.drawable.icone_estrela_desativada),
                            contentDescription = "Compartilhar",
                            modifier = Modifier .width(59.dp)
                                .height(56.dp) .shadow(60.dp),
                            tint = Color.White
                        )
                    }
                }

            }

        }
    }
}

@Preview
@Composable
private fun PreviewTelaDeRedirecionamento() {
    TeladeRedirecionamento()
}