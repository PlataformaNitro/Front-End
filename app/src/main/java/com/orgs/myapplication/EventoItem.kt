import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.orgs.myapplication.Model.Evento

@Composable
fun EventoItem(modifier: Modifier = Modifier,evento:Evento) {
    Text(evento.titulo)
}

@Preview
@Composable
private fun EventoItemPreview() {
    EventoItem(evento = Evento("Evento 1"))
}