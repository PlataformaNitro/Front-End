import android.content.Intent
import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.orgs.myapplication.Model.MotoClube
import com.orgs.myapplication.Model.User
import com.orgs.myapplication.R
import com.orgs.myapplication.ui.Activitys.UsuarioActivity
import kotlinx.coroutines.delay
import model.Viajem
import kotlin.jvm.java

@Composable
fun HomeScreen(viewModel: EventosScreenViewModel) {
    val state by viewModel.uiState.collectAsState()
    HomeScreen(state = state)
}


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    state: EventoScreenUiState = EventoScreenUiState(),
    listUsers: List<User> = sampleUsers
) {
    val sections = state.sections
    var abaSelecionada by rememberSaveable { mutableStateOf(0) } // 0 = Eventos, 1 = Usuários, 2 = Clubes
    var text = state.searchText
    val eventosProucurados = state.eventosProucurados
    val usuariosProucurados = state.usuariosProucurados
    val clubesProucurados = state.clubesProucurados

    val pageItens = listOf(
            R.drawable.isanos_mc,
    R.drawable.lokqw,
    R.drawable.icebiker,
    R.drawable.anrjpi,
    R.drawable.maquinas_m
    )

    val pageState = rememberPagerState(initialPage = 0) { pageItens.size }

    LaunchedEffect(Unit) {
        while (true) {
            delay(2000)
            val nextPage = (pageState.currentPage + 1) % pageItens.size
            pageState.animateScrollToPage(nextPage)
        }
    }


    val motoClubesNome = listOf(
        "Isanos MC",
        "Lokas Mc",
        "Ice Bike",
        "Ankjpi",
        "Maquinas MC"
    )

    val viajens = listOf(
        Viajem("São Paulo", "Rio de Janeiro"),
        Viajem("São Paulo", "Rio de Janeiro"),
        Viajem("São Paulo", "Rio de Janeiro"),
        Viajem("São Paulo", "Rio de Janeiro"),
        Viajem("São Paulo", "Rio de Janeiro"),
    )

    val context = LocalContext.current


    Scaffold { paddingValues ->
        Box(Modifier.padding(paddingValues)) {
            BackgroundPrincipal()
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
                        user = User("Convidado", R.drawable.motoqueiro)
                    )
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            "Olá Convidado!",
                            fontSize = 25.sp,
                            color = Color.White,
                            fontWeight = FontWeight(400),
                            modifier = Modifier.padding(start = 8.dp)
                        )
                        Text(
                            "faça sua jornada!",
                            fontSize = 15.sp,
                            color = Color(0xFF5D7FA5),
                            fontWeight = FontWeight(400),
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                    Icon(
                        Icons.Rounded.Menu,
                        contentDescription = "Menu",
                        tint = Color.Gray,
                        modifier = Modifier
                            .padding(end = 23.dp)
                            .size(33.dp)
                    )
                }
                SearchText(
                    text = text,
                    onTextChange = { newText ->
                        state.onSearchChange(newText)
                    },
                    modifier = Modifier.padding(top = 28.dp)
                )
                Divider(
                    color = Color(0xFF091D3A),
                    thickness = 3.dp,
                    modifier = Modifier.padding(top = 11.dp)
                )

                // Seção de conteúdo (pesquisa ou conteúdo normal)
                if (state.isShowSections()) {
                    Column(modifier.verticalScroll(rememberScrollState())) {
                        WeatherScreen()
                        Box(
                            modifier = Modifier
                                .padding(horizontal = 23.dp, vertical = 10.dp)
                                .height(197.dp)
                        ) {
                            HorizontalPager(state = pageState, pageSize = PageSize.Fill) { page ->
                                Box(modifier = Modifier.fillMaxSize()) {
                                    Image(
                                        painter = painterResource(pageItens[page]),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(200.dp)
                                            .clip(shape = RoundedCornerShape(20.dp))
                                    )
                                }
                            }
                            NitroLogo(
                                modifier = Modifier
                                    .align(Alignment.TopStart)
                                    .size(35.dp)
                            )
                            Column(
                                modifier = Modifier
                                    .align(Alignment.BottomStart)
                                    .fillMaxWidth()
                                    .padding(bottom = 4.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    motoClubesNome[pageState.currentPage],
                                    fontSize = 20.sp,
                                    color = Color.White,
                                    modifier = Modifier.padding()
                                )
                                Row {
                                    repeat(pageState.pageCount) { index ->
                                        val color =
                                            if (pageState.currentPage == index) Color.White else Color.Gray
                                        Box(
                                            modifier = Modifier
                                                .padding(horizontal = 2.dp)
                                                .clip(CircleShape)
                                                .background(color = color)
                                                .size(10.dp)
                                        )
                                    }
                                }
                            }
                        }
                        Column {
                            Row(
                                Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    "Talvez Você Conheça",
                                    Modifier.padding(top = 10.dp, start = 16.dp),
                                    color = Color.White,
                                    fontSize = 15.sp
                                )
                                Text(
                                    "Ver Mais",
                                    Modifier.padding(top = 10.dp, end = 16.dp).clickable {
                                        context.startActivity(Intent(context, UsuarioActivity::class.java))
                                    },
                                    Color.White
                                )
                            }
                            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                items(listUsers) { user ->
                                    Box(Modifier.padding(top = 12.dp)) {
                                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                            Box {
                                                ImagemPerfil(Modifier.size(81.dp), user = user)
                                                Box(
                                                    modifier = Modifier
                                                        .padding(horizontal = 2.dp)
                                                        .clip(CircleShape)
                                                        .background(color = Color.White)
                                                        .size(30.dp)
                                                        .align(alignment = Alignment.BottomEnd)
                                                ) {
                                                    Icon(
                                                        Icons.Default.Add,
                                                        contentDescription = "adicionar",
                                                        modifier.align(Alignment.Center)
                                                    )
                                                }
                                            }
                                            Text(user.nome, color = Color.White, fontSize = 15.sp)
                                        }
                                    }
                                }
                            }
                        }
                        EventoSection(
                            title = "Eventos",
                            listaDeEventos = sampleEvents,
                            modifier = Modifier.padding(top = 23.dp),
                            onVerTodosClick = {
                                //todo
                            }
                        )
                        EventoSection(
                            title = "Mecanicos",
                            listaDeEventos = sampleEvents,
                            modifier = Modifier.padding(top = 13.dp)
                        )
                        SectionViajens(
                            title = "Viajens Proximas",
                            viajens = viajens,
                            modifier = Modifier.padding(top = 13.dp),
                        )
                        SectionViajens(
                            title = "Viajens Populares",
                            viajens = viajens,
                            modifier = Modifier.padding(top = 13.dp),
                        )
                        MotoClubeSection(
                            title = "MotoClubes",
                            listaDeMotoCLubes = sampleMotoClubes,
                            modifier = Modifier.padding(top = 13.dp)
                        )
                        Text(
                            "Quem Somos",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 13.dp, horizontal = 16.dp),
                            color = Color.White,
                            fontSize = 15.sp,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            "Bem-vindo a Nitro, um portal para todos, sendo um ambiente dedicado aos apaixonados por motocicletas e viagens. Fundado em 20 de março de 2025, nossa plataforma nasceu do desejo mutuo de unir motociclistas de diversas regiões, promovendo a proteção, troca de experiências, informações relevantes e, sobretudo, a paixão compartilhada pelas duas rodas.",
                            fontSize = 14.sp,
                            color = Color.White,
                            modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
                            textAlign = TextAlign.Justify
                        )
                    }
                } else {
                    // Abas de pesquisa
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        modifier = Modifier.padding(horizontal = 16.dp)
                    ) {
                        Button(
                            enabled = abaSelecionada != 0,
                            colors = ButtonColors(
                                containerColor = Color.Magenta,
                                disabledContainerColor = Color.Gray,
                                contentColor = Color.White,
                                disabledContentColor = Color.White
                            ),
                            onClick = { abaSelecionada = 0 },
                            modifier = modifier.weight(1f),
                        ) { Text("Eventos") }
                        Button(
                            enabled = abaSelecionada != 1,
                            colors = ButtonColors(
                                containerColor = Color.Magenta,
                                disabledContainerColor = Color.Gray,
                                contentColor = Color.White,
                                disabledContentColor = Color.White
                            ),
                            onClick = { abaSelecionada = 1 },
                            modifier = modifier.weight(1f),
                        ) { Text("Usuários") }
                        Button(
                            enabled = abaSelecionada != 2,
                            colors = ButtonColors(
                                containerColor = Color.Magenta,
                                disabledContainerColor = Color.Gray,
                                contentColor = Color.White,
                                disabledContentColor = Color.White
                            ),
                            onClick = { abaSelecionada = 2 },
                            modifier = modifier.weight(1f),
                        ) { Text("Clubes") }
                    }

                    // Conteúdo da pesquisa baseado na aba selecionada
                    LazyColumn(
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        when (abaSelecionada) {
                            0 -> { // Eventos
                                items(eventosProucurados) { evento ->
                                    CardItemEvento(evento = evento)
                                }
                                if (eventosProucurados.isEmpty()) {
                                    item {
                                        Text(
                                            "Nenhum evento encontrado",
                                            color = Color.White,
                                            modifier = Modifier.fillMaxWidth(),
                                            textAlign = TextAlign.Center
                                        )
                                    }
                                }
                            }
                            1 -> { // Usuários
                                items(usuariosProucurados) { usuario ->
                                    CardItemUsuario(usuario = usuario)
                                }
                                if (usuariosProucurados.isEmpty()) {
                                    item {
                                        Text(
                                            "Nenhum usuário encontrado",
                                            color = Color.White,
                                            modifier = Modifier.fillMaxWidth(),
                                            textAlign = TextAlign.Center
                                        )
                                    }
                                }
                            }
                            2 -> { // Clubes
                                items(clubesProucurados) { clube ->
                                    CardItemMotoClube(clube = clube)
                                }
                                if (clubesProucurados.isEmpty()) {
                                    item {
                                        Text(
                                            "Nenhum moto clube encontrado",
                                            color = Color.White,
                                            modifier = Modifier.fillMaxWidth(),
                                            textAlign = TextAlign.Center
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

// Componente para exibir um usuário nos resultados de pesquisa
@Composable
fun CardItemUsuario(usuario: User) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF1A2C47), RoundedCornerShape(8.dp))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ImagemPerfil(modifier = Modifier.size(50.dp), user = usuario)
        Text(usuario.nome, color = Color.White)
    }
}

// Componente para exibir um moto clube nos resultados de pesquisa
@Composable
fun CardItemMotoClube(clube: MotoClube) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF1A2C47), RoundedCornerShape(8.dp))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Image(
            painter = painterResource(id = clube.imagem),
            contentDescription = null,
            modifier = Modifier.size(50.dp)
        )
        Column {
            Text(clube.nome, color = Color.White)
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}