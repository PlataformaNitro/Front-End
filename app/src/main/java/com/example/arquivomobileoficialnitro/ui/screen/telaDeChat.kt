package com.example.arquivomobileoficialnitro.ui.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Surface
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.ui.res.painterResource
import com.example.arquivomobileoficialnitro.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.BrushPainter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
// Componentes básicos
import androidx.compose.material3.Text
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.MaterialTheme

// Para usar 'by' com remember e mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

// Para ícones
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search

// Para formas
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun TelaDeChat(modifier: Modifier = Modifier) {
    Column {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .background(
                    Brush.linearGradient(
                        colors = listOf(
                            Color(0xFF020D26),
                            Color(0xFF020C24)
                        )
                    )
                ),
        ){
        Row{
Box() {
    Image(
       painter =  painterResource(R.drawable.nitro__1__2),
        contentDescription = "Logo do Nitro",
        modifier =  Modifier
            .padding(bottom = 15.dp)
            .size(91.dp)
    )
    Row(Modifier .align(Alignment.BottomCenter), verticalAlignment = Alignment.CenterVertically){
        IconButton(onClick={}) {
Icon(
    painterResource(R.drawable.menu),
    contentDescription = "Menu de opções do chat",
    tint = Color(0xFF8E9299)

)

        }
        Box(){
        Box(Modifier .width(33.dp)
            .height(33.dp)
            .background(color = Color(0xFF1C2128), shape = RoundedCornerShape(size = 10.dp))){
IconButton(onClick={}) {
    Icon(
        painterResource(R.drawable.icone_email)
        , contentDescription = "Botão de enviar mensagem",
        tint = Color.White,
    )

        }}
        Box(Modifier
            .align(Alignment.BottomEnd)
            .padding(start = 20.dp, top = 15.dp)
            .width(18.dp)
            .height(18.dp)
            .background(color = Color(0xFF4A83DE), shape = RoundedCornerShape(30.dp)
                )
        ){
            Text(
                text = "+9",
                modifier = Modifier.align(Alignment.Center) .padding(end = 2.dp),
                style = TextStyle(
                    fontSize = 13.sp,
                    fontFamily = FontFamily(Font(R.font.archivo)),
                    fontWeight = FontWeight(700),
                    color = Color(0xFFFFFFFF),

                    )
            )
        }
        }
    }

}

            Column(modifier = Modifier.align(Alignment.CenterVertically)) {
                Column {
                    Text("Messagem",
                            style = TextStyle(
                            fontSize = 25.sp,
                        fontFamily = FontFamily(Font(R.font.archivo_black)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFFF2F4F7),

                        )
                    )
                    SearchBar()

                }
            }
        }}
        Spacer(Modifier .fillMaxWidth()
            .height(3.dp)
            .background(color = Color(0xFF061530))
        )
        Row{
    Column(Modifier.weight(0.3f)){
        Box(modifier
            .fillMaxHeight()
            .width(96.dp)
            .background(Color(0xFF010715))
            .padding(10.dp)){
            Column(Modifier.align(Alignment.Center) .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
Surface(Modifier
    .width(66.dp)
    .wrapContentHeight(),
    color = Color(0xFF051538), shape = RoundedCornerShape(size = 30.dp)
                ){
    Column(Modifier.align(Alignment.CenterHorizontally) .padding(vertical = 10.dp) , horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(5.dp),  ) {
                IconsDoChat()
        IconsDoChat()}
}
            }

        }
    }
    Column(Modifier  .background(Brush.linearGradient( 0.1f to Color(0xFF020C22), 1f to Color(0xFF014677))) .weight(1f) .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
ChatItem()
    }
}
    }


}

@Preview
@Composable
private fun PreviewTelaDeChat() {
    TelaDeChat()

}
@Composable
fun SearchBar() {
    var searchText by remember { mutableStateOf("") }

    Row(
        modifier = Modifier
            .fillMaxWidth()

    ) {
        OutlinedTextField(
            value = searchText,
            onValueChange = { searchText = it },
            modifier = Modifier
                .fillMaxWidth()
                .height(47.dp)
                .padding(end = 10.dp),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Ícone de Pesquisa",
                    tint = Color.LightGray, // Cor do ícone
                    modifier = Modifier.size(43.dp)
                )
            },
            placeholder = {
                Text(
                    text = "Buscar Motociclistas",
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontFamily = FontFamily(Font(R.font.archivo)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFFAABDD1),

                        )// Cor do texto do placeholder
                )
            },
            shape = RoundedCornerShape(23.dp), // Ajuste o raio para as bordas arredondadas
            colors = TextFieldDefaults.colors( // Alterado para colors()
                focusedIndicatorColor = Color.DarkGray,    // Controla a cor da borda focada
                unfocusedIndicatorColor = Color.DarkGray,  // Controla a cor da borda não focada
                cursorColor = Color.White,
                focusedTextColor = Color.White,            // Cor do texto quando focado
                unfocusedTextColor = Color.White,          // Cor do texto quando não focado
                focusedContainerColor = Color(0xFF2C323D), // Cor de fundo quando focado
                unfocusedContainerColor = Color(0xFF2C323D) // Cor de fundo quando não focado
                // Adicione outras cores de estado (disabled, error) se necessário
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSearchBar() {
    MaterialTheme { // Use um MaterialTheme para que os componentes tenham o estilo correto
        SearchBar()
    }
}

@Composable
fun IconsDoChat(modifier: Modifier = Modifier, imagem: Int = R.drawable.icone_email) {
    Surface(
       modifier = Modifier
        .width(55.dp)
        .height(55.dp)
        ,color = Color(0xFFB8D4EF), shape = RoundedCornerShape(size = 20.dp)
    ){
        Image(
            painter = painterResource(id = imagem),
            contentDescription = "Ícone do chat",
        )
    }
    
}

@Preview
@Composable
private fun PreviewIconesDoChat() {
    IconsDoChat()

}


// Supondo que você tenha uma imagem em res/drawable/avatar_skull.png
// import com.your.package.name.R

@Composable
fun ChatItem() {
    // 1. Container Principal (Row)
    // Organiza os elementos horizontalmente (avatar, textos, tempo)
    Row(
        modifier = Modifier
            .fillMaxWidth(0.97f)
            .height(87.dp)
            .background(color = Color(0xFF0C1D45), shape = RoundedCornerShape(size = 30.dp))
            .padding(horizontal = 10.dp)
        ,
        verticalAlignment = Alignment.Top,
    ) {
        // 2. Avatar Circular
        Image(
            painter = painterResource(id = R.drawable.amigos_recomendados_1), // Substitua pelo seu recurso
            contentDescription = "Avatar do usuário",
            contentScale = ContentScale.Crop, // Garante que a imagem preencha o círculo
            modifier = Modifier

                .size(73.dp) // Tamanho do avatar
                .shadow(elevation = 5.dp, shape = CircleShape) // Sombra opcional
                .clip(CircleShape)
                .align(Alignment.CenterVertically)// Formato circular
        )

        // Espaçador entre o avatar e o texto
        Spacer(modifier = Modifier.width(12.dp))

        // 3. Coluna para Nome e Mensagem
        // Ocupa o espaço disponível, empurrando o tempo para a direita
Box(Modifier.fillMaxSize()){
        Column(
            modifier = Modifier.align(Alignment.TopStart) // ESSENCIAL para o layout
        ) {
            Text(
                text = "Cláudio",
                modifier = Modifier.padding(top = 10.dp),
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.archivo)),
                    fontWeight = FontWeight(700),
                    color = Color(0xFFFFFFFF),

                    )
            )
            // Pequeno espaço vertical entre o nome e a mensagem
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Psé ela é muito importante ag... ",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.archivo)),
                    fontWeight = FontWeight(300),
                    color = Color(0xFFF8FBFF),

                    )
            )}

        // 4. Texto do Tempo
        // Fica no final da Row por causa do .weight(1f) da Column
        Text(
            text = "7m",
            modifier = Modifier.padding(end = 15.dp, top = 13.dp) .align(Alignment.TopEnd),
            style = TextStyle(
                fontSize = 10.sp,
                fontFamily = FontFamily(Font(R.font.archivo)),
                fontWeight = FontWeight(700),
                color = Color(0xFFAABDD1),

                )
        )
}

    }
}

// --- Preview e Exemplo de Uso ---

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun ChatItemPreview() {
    // Adiciona um padding externo no preview para ver melhor os cantos arredondados
    Box(modifier = Modifier.padding(16.dp)) {
        ChatItem()
    }
}

