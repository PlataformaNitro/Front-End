import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.orgs.myapplication.Model.Evento

@Composable
fun CardItemEvento(modifier: Modifier = Modifier, evento: Evento) {
    var expanded by rememberSaveable() { mutableStateOf(false) }

    Card(modifier = modifier.clickable { expanded = !expanded }) {
    EventoItem(evento = evento, modifier = Modifier.fillMaxWidth(), larguraTexto = 170.dp)
    }
}

@Preview
@Composable
private fun CardItemEventoPreview() {
    CardItemEvento(evento = Evento("Evento 1", "Descrição do evento 1"))
}