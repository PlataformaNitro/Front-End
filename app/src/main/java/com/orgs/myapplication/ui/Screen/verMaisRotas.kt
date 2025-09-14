package com.orgs.myapplication.ui.Screen

import BackgroundPrincipal
import ImagemPerfil
import androidx.compose.foundation.rememberScrollState
import NitroLogo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.shadow
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
import com.example.arquivomobileoficialnitro.ui.screen.badgenotification
import com.example.nitroapp.ui.components.SideDrawerMenu
import com.orgs.myapplication.Model.User
import com.orgs.myapplication.R
import java.util.logging.Filter

// Supondo que você tenha esses recursos de imagem em sua pasta res/drawable
// Como não tenho os assets originais, estou usando placeholders.
// Substitua R.drawable.placeholder pelos seus próprios recursos.
val suggestedMechanics = listOf(
    R.drawable.moto_tool_1,
    R.drawable.moto_tool_2
)
val fastMechanics = listOf(
    R.drawable.moto_tool_3,
    R.drawable.moto_tool_3
)
val winchMechanics = listOf(
    R.drawable.moto_tool_3,
    R.drawable.moto_tool_3,

)
val garageMechanics = listOf(
    R.drawable.moto_tool_3,
    R.drawable.moto_tool_3,

)


// Definição de Cores para o tema do App
private val DarkBlue = Color(0xFF0A1931)
private val LightBlue = Color(0xFF185ADB)
private val TextColor = Color.White
private val SecondaryTextColor = Color.LightGray
@Composable
fun MainScreen() {
    var isDrawerOpen by remember {mutableStateOf(false)}

    if (isDrawerOpen) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.5f))
                .clickable { isDrawerOpen = false }
        )
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .background(Color(0xFF001233))
        ) {
            SideDrawerMenu(
                onItemClick = {
                    isDrawerOpen = false
                    // outras ações
                },
                modifier = Modifier.fillMaxSize()
            )
        }
    }else{
        BackgroundPrincipal()
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.Transparent
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                item {
                    TopBarContent(clique = {isDrawerOpen = true})
                }
                item { MechanicTabs() }
                item {
                    Spacer(modifier = Modifier.height(16.dp))
                    MechanicSections()
                }
            }
        }
    }
}

@Composable
fun TopBarContent(clique : () -> Unit = {}) {

    Column {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
            NitroLogo(
                modifier = Modifier
                    .size(91.dp)
                    .padding(end = 23.dp),
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            ImagemPerfil(
                modifier = Modifier
                    .padding(start = 18.dp)
                    .size(58.dp),
                User(
                    nome = "Convidado",
                    imagem = R.drawable.motoqueiro,
                    bio = "Celebro minha paixão sobre duas rodas.",
                    moto = "Sahara 300",
                    tipo = "Adventure",
                    totalKm = 12450
                )
            )
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    "Olá Convidado!",
                    fontSize = 25.sp,
                    color = Color.White,
                    fontFamily = FontFamily(Font(R.font.archivo_black)),
                    fontWeight = FontWeight(400),
                    modifier = Modifier.padding(start = 8.dp)
                )
                Text(
                    "faça sua jornada!",
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.archivo_black)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF5D7FA5),
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
            Icon(
                imageVector = Icons.Rounded.Menu,
                contentDescription = "Menu",
                tint = Color.Gray,
                modifier = Modifier
                    .padding(end = 23.dp)
                    .size(33.dp)
                    .clickable {
                        clique()
                    }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        // --- Barra de Busca ---
        TopNavigationBar()
    }
}



@Composable
fun MechanicTabs() {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val tabs = listOf("Recentes", "Populares", "Para Você", "Relevantes")
    Spacer(Modifier
        .alpha(0.5f)
        .shadow(elevation = 10.dp)
        .width(418.dp)
        .height(3.dp)
        .background(color = Color(0xFF091D3A)))
    Row(Modifier.horizontalScroll(rememberScrollState()), horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Spacer(Modifier.width(10.dp))
        FilterChip("Recentes")
        FilterChip("Populares")
        FilterChip("Para Você")
        FilterChip("Relevantes")
    }
}

@Composable
fun MechanicSections() {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Section(title = "Mecânicos Sugeridos", items = suggestedMechanics)
        Spacer(modifier = Modifier.height(16.dp))
        Section(title = "Mecânicos Rápidos", items = fastMechanics)
        Spacer(modifier = Modifier.height(16.dp))
        Section(title = "Mecânicos com guincho", items = winchMechanics)
        Spacer(modifier = Modifier.height(16.dp))
        Section(title = "Garagens Mecânicas", items = garageMechanics)
    }
}

@Composable
fun Section(title: String, items: List<Int>) {
    Column(Modifier.fillMaxWidth()) {
        Text(
            text = title,
            style = TextStyle(
                fontSize = 15.sp,
                fontFamily = FontFamily(Font(R.font.archivo_black)),
                fontWeight = FontWeight(400),
                color = Color(0xFFF2F4F7),

                )
        )
        Spacer(modifier = Modifier.height(15.dp))
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(start = 4.dp),// A rolagem principal é da LazyColumn

            userScrollEnabled = true,
        ) {
            items(items) { drawableId ->
                MechanicCard(drawableId = drawableId)
            }
        }
    }
}

@Composable
fun MechanicCard(drawableId: Int) {
        Box(
            modifier = Modifier
                .width(180.dp)
                .height(230.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.DarkGray), // Cor de fundo para os cards
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = drawableId),
                contentDescription = null, // Descrição viria de um modelo de dados
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
        }

}


// Preview para o Android Studio
@Preview(showBackground = true, widthDp = 360, heightDp = 800)
@Composable
fun DefaultPreview() {
    MainScreen()
}

@Composable
fun TopNavigationBar() {
    // Cores aproximadas com base na imagem
    val iconColor = Color(0xFFFFFFFF)         // Cor dos ícones
    val notificationBadgeColor = Color(0xFF4285F4) // Azul para o contador de mensagens
    var searchText by remember { mutableStateOf("") }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Botão de retorno
        IconButton(
            onClick = { /* Ação de retorno */ },
            modifier = Modifier.align(Alignment.CenterVertically)
        ) {
            Image(
                painter =  painterResource(R.drawable.voltar_padrao),
                contentDescription = "Voltar",
                modifier = Modifier.size(42.dp).align(Alignment.CenterVertically),
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        // Barra de pesquisa
        OutlinedTextField(
            value = searchText,
            onValueChange = { searchText = it },
            modifier = Modifier
                .weight(1f)
                .height(55.dp),
            placeholder = {
                Text(
                    "Buscar",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.inter)),
                        fontWeight = FontWeight(700),
                        color = Color(0xFF49515D)
                    )
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Pesquisar",
                    modifier = Modifier.size(24.dp),
                    tint = iconColor
                )
            },
            trailingIcon = {
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.microphone),
                        contentDescription = "Microfone",
                        modifier = Modifier.clickable { /* Ação do microfone */ }
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Image(
                        painter = painterResource(id = R.drawable.camera),
                        contentDescription = "Câmera",
                        modifier = Modifier.clickable { /* Ação da câmera */ }
                    )
                }
            },
            shape = RoundedCornerShape(24.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = Color(0xFF1C232D),
                focusedContainerColor = Color(0xFF1C232D),
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = Color.Transparent,
                unfocusedTextColor = Color.White,
                focusedTextColor = Color.White
            ),
            singleLine = true
        )

        Spacer(modifier = Modifier.width(8.dp))

        // Ícone de Notificações
        IconButton(
            onClick = { /* Ação de notificações */ },
            modifier = Modifier
                .size(48.dp)
                .background(Color(0xFF1B222E), CircleShape)
        ) {
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "Notificações",
                tint = iconColor
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        // Ícone de Mensagens com contador
        Box(
            modifier = Modifier
                .size(48.dp)
                .background(Color(0xFF1B222E), CircleShape),
            contentAlignment = Alignment.Center
        ) {
            IconButton(
                onClick = { /* Ação de mensagens */ },
                modifier = Modifier.fillMaxSize() // Preenche o Box para o clique
            ) {
                Icon(
                    imageVector = Icons.Default.MailOutline,
                    contentDescription = "Mensagens",
                    tint = iconColor
                )
            }
            // Contador de mensagens
            badgenotification(Modifier .align(Alignment.BottomEnd))

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTopNavigationBar() {
    MaterialTheme {
        TopNavigationBar()
    }
}
@Composable
fun FilterChip(text: String) {
    Box(
        Modifier
            .width(98.dp)
            .height(37.dp)
            .background(color = Color(0xFF23538F), shape = RoundedCornerShape(size = 10.dp))
    ) {
        Text(
            text = text,
            modifier = Modifier.align(Alignment.Center),
            style = TextStyle(
                fontSize = 17.sp,
                fontFamily = FontFamily(Font(R.font.inter)),
                fontWeight = FontWeight(700),
                color = Color(0xFFFBFEFE),

                textAlign = TextAlign.Center,
            )
        )
    }
}

@Preview
@Composable
private fun PreviewBotaoFiltro()
{
    FilterChip("iu")
}
