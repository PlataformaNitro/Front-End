import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.orgs.myapplication.Model.Evento
import com.orgs.myapplication.Model.MotoClube

@Composable
fun MotoClubeSection(
    title: String = "motoClubes",
    modifier: Modifier = Modifier,
    listaDeMotoCLubes: List<MotoClube>,
    onVerTodosClick: @Composable () -> Unit = {}
) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp), modifier = modifier) {
        Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = title, modifier = modifier.padding(horizontal = 16.dp), color = Color.White)
            Text(text = "Ver Todos", modifier = modifier.padding(horizontal = 16.dp).clickable{onVerTodosClick}, color = Color.White)
        }
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(listaDeMotoCLubes) { motoclubes ->
                MotoCLubeItem(motoClube = motoclubes)
            }
        }
    }
}

@Preview
@Composable
private fun EventoSectionPreview() {
    EventoSection(listaDeEventos = sampleEvents)
}

