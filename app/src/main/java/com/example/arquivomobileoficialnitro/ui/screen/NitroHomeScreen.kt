import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.arquivomobileoficialnitro.R
import com.example.arquivomobileoficialnitro.ui.components.telaHome.PessoasRecomendadas
import com.example.arquivomobileoficialnitro.ui.components.telaHome.Recomendadas
import com.example.arquivomobileoficialnitro.ui.components.telaHome.Search
import com.example.arquivomobileoficialnitro.ui.components.util.BackgroundSecundario
import com.example.arquivomobileoficialnitro.ui.sections.home.SectionCardHome
import com.example.arquivomobileoficialnitro.ui.sections.homeimport.Header
import com.example.nitroapp.ui.components.SideDrawerMenu


@Composable
fun NitroHomeScreen(navController: NavController) {
    var isDrawerOpen by remember { mutableStateOf(false) }
    Box(Modifier.fillMaxSize()) {
        BackgroundSecundario()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            TopAppBar(
                backgroundColor = Color.Transparent,
                elevation = 0.dp,
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(horizontal = 0.dp)
            ) {
                LogoDark(Modifier.size(60.dp))
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = {
                    isDrawerOpen = !isDrawerOpen
                }) {
                    Icon(Icons.Filled.Menu, contentDescription = "Menu", tint = Color.White)
                }
            }

            Header()

            Spacer(modifier = Modifier.height(16.dp))

            Text("17°C", color = Color.White, fontSize = 20.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Search()
            Spacer(modifier = Modifier.height(16.dp))

            Recomendadas()

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                "Talvez você conheça",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            val users = remember {
                listOf("Diego Messias", "Rodrigo Jesus", "Ruan Duarte", "Alexias Alberiz")
            }

            LazyRow(
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                items(users) { user ->
                    PessoasRecomendadas(R.drawable.amigos_recomendados_1, user)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            SectionCardHome()
        }

        if (isDrawerOpen) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .align(Alignment.CenterEnd)
            ) {
                SideDrawerMenu(
                    onItemClick = {
                        if (it == "close") {
                            isDrawerOpen = false
                        } else {
                            // Ações para outros cliques de menu podem ser tratadas aqui
                            isDrawerOpen = false
                        }
                    },
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

@Preview
@Composable
private fun NitroHomeScreenPreview() {
    //NitroHomeScreen()
}
