package com.orgs.myapplication.ui.Screen

import BackgroundPrincipal
import ImagemPerfil
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
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
import model.Viajem

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

val viajens = listOf(
    Viajem(R.drawable.viajem_1, "Lapa", "Rota passando pela Marginal e vista do Rio Pinheiros", "Ibirapuera"),
    Viajem(R.drawable.viajem_2, "Mooca", "Passeio pela Av. Paes de Barros até o parque mais famoso da cidade", "Ibirapuera"),
    Viajem(R.drawable.viajem_3, "Santana", "Viagem passando pelo centro e região da Luz", "Vila Mariana"),
    Viajem(R.drawable.viajem_4, "Tatuapé", "Rota por avenidas amplas até a região arborizada da zona sul", "Santo Amaro"),
    Viajem(R.drawable.viajem_5, "Pinheiros", "Passeio moderno por avenidas como Faria Lima e Juscelino Kubitschek", "Brooklin"),
    Viajem(R.drawable.viajem_6, "Butantã", "Caminho passando pela USP e chegando em área comercial e residencial", "Morumbi"),
    Viajem(R.drawable.viajem_9, "Liberdade", "Rota cultural passando pelo centro antigo e museus", "Aclimação"),
    Viajem(R.drawable.viajem_8, "Perdizes", "Subidas e descidas até a arborizada zona norte", "Tremembé"),
    Viajem(R.drawable.viajem_1, "São Miguel Paulista", "Viagem longa pela zona leste até bairro nobre e gastronômico", "Vila Madalena"),
    Viajem(R.drawable.viajem_10, "Capão Redondo", "Rota movimentada com trechos da Estrada de Itapecerica", "Ipiranga")
)


// Definição de Cores para o tema do App
private val DarkBlue = Color(0xFF0A1931)
private val LightBlue = Color(0xFF185ADB)
private val TextColor = Color.White
private val SecondaryTextColor = Color.LightGray

@Composable
fun MainScreen(type: Int = 0) {
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
        Surface(
            modifier = Modifier.fillMaxSize()   ,
            color = Color.Transparent
        ) {
    BackgroundPrincipal()
Column {
    TopBarContent(clique = { isDrawerOpen = true })
    MechanicTabs()
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState()) // Apply verticalScroll first
                .fillMaxSize() // Ensure the Column takes up available space for the gradient
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            if(type == 0)
                MechanicSections();
            else if(type == 1)
                ViagensSections();
            else if(type == 2)
                LugaresSections();
            else if(type == 3)
                MotoClubesSections();
        }

    }
}
        }
    }

@Composable
fun ViajensCards(modifier: Modifier = Modifier, drawableId: Int = R.drawable.viajem_1) {
    Box(
        modifier = Modifier
            .width(180.dp)
            .height(230.dp)
            .clip(RoundedCornerShape(10.dp)),
        contentAlignment = Alignment.Center
    ) {

        Image(
            painter = painterResource(id = drawableId),
            contentDescription = null, // Descrição viria de um modelo de dados
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Box(Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colorStops = arrayOf(
                        0.0f to Color.Transparent,
                        0.55f to Color.Transparent,
                        1.0f to Color.Black
                    )
                )
            )){}
        Text(
            text = "Tito → Parque Ibirapuera",
            style = TextStyle(
                fontSize = 10.sp,
                fontFamily = FontFamily(Font(R.font.archivo)),
                fontWeight = FontWeight(700),
                color = Color(0xFFFFFFFF),
            ),
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(8.dp)
        )
    }

}

@Composable
fun MotoClubeCards(modifier: Modifier = Modifier, drawableId: Int = R.drawable.viajem_1) {
    Box(
        modifier = Modifier
            .width(180.dp)
            .height(230.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(
                Brush.verticalGradient(
                    colorStops = arrayOf(
                        0.9f to Color(0xFF010C2),
                        1f to Color(0xFF014677)
                    )
                )
            )
    )
    {}
    Box(
        modifier = Modifier
            .width(180.dp)
            .height(230.dp)
            .clip(RoundedCornerShape(10.dp)),
        contentAlignment = Alignment.Center
    ) {

        Box(modifier = Modifier .height(205.dp) .fillMaxWidth() .align(Alignment.TopCenter)
            .clip(RoundedCornerShape(10.dp) ),
        )
        {
            Image(
                painter = painterResource(id = drawableId),
                contentDescription = null, // Descrição viria de um modelo de dados
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
        }
        Text(
            text = "Tito → Parque Ibirapuera",
            style = TextStyle(
                fontSize = 10.sp,
                fontFamily = FontFamily(Font(R.font.archivo)),
                fontWeight = FontWeight(700),
                color = Color(0xFFFFFFFF),
            ),
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(8.dp)
        )
    }

}

@Preview
@Composable
private fun ViajemCardsPreview() {
    ViajensCards()
}
@Preview
@Composable
private fun MotoClubeCardsPreview() {
    MotoClubeCards()
}
@Composable
fun LugarCards(modifier: Modifier = Modifier, drawableId: Int = R.drawable.viajem_1) {
    Box(
        modifier = Modifier
            .width(201.dp)
            .height(259.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(
                Brush.verticalGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF010C24),
                        0.65f to Color(0xFF014677)
                    )
                )
            ), // Cor de fundo para os cards
        contentAlignment = Alignment.Center
    ) {

        Image(
            painter = painterResource(id = drawableId),
            contentDescription = null, // Descrição viria de um modelo de dados
            modifier = Modifier
                .padding(bottom = 24.dp)
                .width(154.dp)
                .height(201.dp)
                .clip(CircleShape)
                .align(Alignment.Center)
                ,
            contentScale = ContentScale.FillBounds
        )
Column(     modifier = Modifier
    .align(Alignment.BottomStart)
    .padding(start = 16.dp, bottom = 8.dp)){
        Text(
            text = "Bar Cacilda - Lapa Tito",
            style = TextStyle(
                fontSize = 10.sp,
                fontFamily = FontFamily(Font(R.font.archivo)),
                fontWeight = FontWeight(700),
                color = Color(0xFFFFFFFF),
            ),
            textAlign = TextAlign.Left,

        )
    Spacer(modifier = Modifier.height(4.dp))
    Text(
        text = "#Bar #Restaurante",
        style = TextStyle(
            fontSize = 10.sp,
            fontFamily = FontFamily(Font(R.font.archivo)),
            fontWeight = FontWeight(700),
            color = Color(0xFFFFFFFF),
        ),
        textAlign = TextAlign.Left,
    )
}
    }


    }



@Preview
@Composable
private fun PreviewLugarCards() {
    LugarCards()
    
}

@Composable
fun MecanicoCard(modifier: Modifier = Modifier, drawableId: Int = R.drawable.viajem_1) {
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
        Box(Modifier.width(180.dp)
            .height(59.dp)
            .align(Alignment.BottomCenter)) {
            Box(Modifier
                .fillMaxSize()
                .alpha(0.4f)
                .background(
                    Brush.linearGradient(
                        colorStops = arrayOf(
                            0.0f to Color(0xFF021030),
                            0.4f to Color(0xFF021030),
                            0.55f to Color(0xFF014677)
                        )
                    )

                )){}
            Box(Modifier.fillMaxSize() .alpha(0.2f) .background(Color.Black)){}
            Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Industry Automotive",
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontFamily = FontFamily(Font(R.font.archivo_black)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFFFFFFFF),
                    )
                )
                Text(
                    text = "oficina especializada - 3km",
                    style = TextStyle(
                        fontSize = 10.sp,
                        fontFamily = FontFamily(Font(R.font.archivo)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFFFFFFFF),
                    )
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "4.9 ★ | 139 ",
                        style = TextStyle(
                            fontSize = 10.sp,
                            fontFamily = FontFamily(Font(R.font.archivo)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFFFFFFFF),
                        )
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.emoji_moto_png),
                        contentDescription = "Moto",
                        modifier = Modifier.size(14.dp),
                        tint = Color.White
                    )
                }


            }
        }
    }

}

@Preview
@Composable
private fun PreviewMecanicoCard() {
    MecanicoCard()
}
@Composable
fun TopBarContent(clique : () -> Unit = {}) {
    Box(){
        Image(
            painter = painterResource(R.drawable.topbar),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.FillBounds

        )

    Column {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
            Image(
                painterResource(R.drawable.nitro_logo_svg),
                modifier = Modifier
                    .size(91.dp)
                    .padding(end = 30.dp, top = 10.dp)
                    .alpha(0.0f),
                contentDescription = "Descrição da imagem"
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
}



@Composable
fun MechanicTabs() {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val tabs = listOf("Recentes", "Populares", "Para Você", "Relevantes")


    Spacer(Modifier
        .alpha(0.5f)
        .shadow(elevation = 10.dp)
        .fillMaxWidth()
        .height(3.dp)
        .background(color = Color(0xFF091D3A)))
    Spacer(modifier = Modifier.height(10.dp))

    Row(Modifier.horizontalScroll(rememberScrollState()), horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Spacer(Modifier.width(10.dp))
        FilterChip("Recentes")
        FilterChip("Populares")
        FilterChip("Para Você")
        FilterChip("Relevantes")
    }
    Spacer(modifier = Modifier.height(10.dp))

    Spacer(Modifier
        .alpha(0.5f)
        .shadow(elevation = 10.dp)
        .fillMaxWidth()
        .height(3.dp)
        .background(color = Color(0xFF091D3A)))

}

@Composable
fun MechanicSections() {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Section(title = "Mecânicos Próximos", items = suggestedMechanics, card = 0)
        Section(title = "Mecânicos 24h", items = fastMechanics, card = 0)
        Section(title = "Mecânicos Guincho", items = winchMechanics, card = 0)
        Section(title = "Oficinas", items = garageMechanics, card = 0)
        Spacer(modifier = Modifier.height(30.dp))
    }
}
@Composable
fun ViagensSections() {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Section(title = "Viagens Próximos", items = suggestedMechanics, card = 1)
        Section(title = "Viagnes Relevantes", items = fastMechanics, card = 1)
        Section(title = "Viagens Populares", items = winchMechanics, card = 1)
        Section(title = "Viagens exoticas", items = garageMechanics, card = 1)
        Spacer(modifier = Modifier.height(30.dp))
    }
}

@Composable
fun LugaresSections() {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Section(title = "Lugares Próximos", items = suggestedMechanics, card = 2)
        Section(title = "Restaurantes", items = fastMechanics, card = 2)
        Section(title = "Paisagens", items = winchMechanics, card = 2)
        Section(title = "Parques", items = garageMechanics, card = 2)
        Spacer(modifier = Modifier.height(30.dp))
    }
}
@Composable
fun MotoClubesSections() {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Section(title = "Lugares Próximos", items = suggestedMechanics, card = 2)
        Section(title = "Restaurantes", items = fastMechanics, card = 2)
        Section(title = "Paisagens", items = winchMechanics, card = 2)
        Section(title = "Parques", items = garageMechanics, card = 2)
        Spacer(modifier = Modifier.height(30.dp))
    }
}

@Composable
fun Section(title: String, items: List<Int>, card: Int = 0) {

    Column(Modifier.fillMaxWidth()) {
        Text(
            text = title,
            modifier = Modifier.padding(horizontal = 16.dp),
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
            contentPadding = PaddingValues(horizontal = 16.dp),

            userScrollEnabled = true,
        ) {
            items(items) { drawableId ->
                if (card == 0) {
                    MecanicoCard(drawableId = drawableId)
                } else if (card == 1) {
                    ViajensCards(drawableId = drawableId)
                } else if (card == 2) {
                    LugarCards(drawableId = drawableId)
                } else if (card == 3) {
                    MotoClubeCards(drawableId = drawableId)
                }
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
        Box(
            modifier = Modifier
                .size(48.dp)
                .border(width = 1.dp, color = Color(0xFF34353B), shape = CircleShape) // cor da borda
                .background(Color(0xFF1B212A), CircleShape)
        ) {
            IconButton(
                onClick = { /* ação */ },
                modifier = Modifier.fillMaxSize()
            ) {
                Icon(
                    painter = painterResource(R.drawable.icon_voltar),
                    contentDescription = "Notificações",
                    tint = iconColor,
                    modifier = Modifier.size(18.dp)
                )
            }
        }

        Spacer(modifier = Modifier.width(8.dp))

        // Barra de pesquisa
        OutlinedTextField(
            value = searchText,
            onValueChange = { searchText = it },
            modifier = Modifier
                .weight(1f)
                .height(50.dp),
            placeholder = {
                Text(
                    "Buscar",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.inter)),
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF49515D),
                    )
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF1B222A),      // cor da borda quando focado
                unfocusedBorderColor = Color(0xFF323335),
                focusedContainerColor = Color(0xFF1B222E),
                unfocusedContainerColor = Color(0xFF1B222E)
// cor da borda quando não está focado
            ),
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
                    Icon(
                        painter = painterResource(id = R.drawable.icone_mic),
                        contentDescription = "Microfone",
                        modifier = Modifier
                            .clickable { /* Ação do microfone */ }
                            .size(26.dp),
                        tint = iconColor
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.icone_camera),
                        contentDescription = "Câmera",
                        modifier = Modifier
                            .clickable { /* Ação da câmera */ }
                            .size(26.dp),
                        tint = iconColor

                    )
                    Spacer(modifier = Modifier.width(15.dp))

                }
            },
            shape = RoundedCornerShape(24.dp),
            singleLine = true
        )

        Spacer(modifier = Modifier.width(8.dp))

        // Ícone de Notificações
        Box(
            modifier = Modifier
                .size(48.dp)
                .border(width = 1.dp, color = Color(0xFF34353B), shape = CircleShape) // cor da borda
                .background(Color(0xFF1B212A), CircleShape)
        ) {
            IconButton(
                onClick = { /* ação */ },
                modifier = Modifier.fillMaxSize()
            ) {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Notificações",
                    tint = Color.White
                )
            }
        }

        Spacer(modifier = Modifier.width(8.dp))

        // Ícone de Mensagens com contador
        Box{
        Box(
            modifier = Modifier
                .size(48.dp)
                .background(Color(0xFF1B222E), CircleShape)
                .border(width = 1.dp, color = Color(0xFF34353B), shape = CircleShape),
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

        }
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
    FilterChip("ui")
}
