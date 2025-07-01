import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.orgs.myapplication.Model.MotoClube

@Composable
fun MotoClubeSection(
    title: String = "motoClubes",
    modifier: Modifier = Modifier,
    listaDeMotoCLubes: List<MotoClube>,
    onVerTodosClick: () -> Unit = {}
) {
    var motoClubeSelecionado by remember { mutableStateOf<MotoClube?>(null) }
    val mostrarDialog = motoClubeSelecionado != null

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = title,
                modifier = Modifier.padding(horizontal = 16.dp),
                color = Color.White
            )
            Text(
                text = "Ver Todos",
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .clickable { onVerTodosClick() },
                color = Color.White
            )
        }
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(listaDeMotoCLubes) { motoclube ->
                MotoCLubeItem(
                    motoClube = motoclube,
                    onClick = { motoClubeSelecionado = motoclube }
                )
            }
        }

        // Dialog dentro do composable!
        if (mostrarDialog) {
            Dialog(onDismissRequest = { motoClubeSelecionado = null }) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.85f)
                        .background(Color(0xFF162A45), shape = RoundedCornerShape(16.dp))
                        .padding(16.dp)
                ) {
                    Column {
                        motoClubeSelecionado?.let { motoClube ->
                            Image(
                                painter = painterResource(motoClube.imagem),
                                contentDescription = "Imagem ampliada",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(200.dp),
                                contentScale = ContentScale.Crop
                            )
                            Spacer(modifier = Modifier.height(12.dp))
                            Text(
                                text = motoClube.nome,
                                color = Color.White,
                                fontSize = 20.sp
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = motoClube.descricao,
                                color = Color.LightGray,
                                fontSize = 16.sp
                            )
                            Spacer(modifier = Modifier.height(20.dp))
                            Button(
                                onClick = { motoClubeSelecionado = null },
                                modifier = Modifier.align(Alignment.End)
                            ) {
                                Text("Fechar")
                            }
                        }
                    }
                }
            }
        }
    }
}
