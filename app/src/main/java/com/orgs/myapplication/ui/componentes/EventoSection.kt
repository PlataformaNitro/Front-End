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

@Composable
fun EventoSection(
    title: String = "Próximos Eventos",
    modifier: Modifier = Modifier,
    listaDeEventos: List<Evento>
) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp), modifier = modifier) {
        Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = title, modifier = modifier.padding(horizontal = 16.dp), color = Color.White)
            Text(text = "Ver Todos", modifier = modifier.padding(horizontal = 16.dp), color = Color.White)
        }
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(listaDeEventos) { evento ->
                EventoItem(evento = evento)
            }
        }
    }
}

@Preview
@Composable
private fun EventoSectionPreview() {
    EventoSection(listaDeEventos = sampleEvents)
}

